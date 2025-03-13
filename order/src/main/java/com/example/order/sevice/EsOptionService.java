package com.example.order.sevice;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.example.order.dto.OrderMessageDTO;
import com.example.order.dto.OrderQuery;
import com.example.order.dto.OrderResponeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class EsOptionService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private static final String INDEX_NAME = "sale_order";

    public void addOrderToEs(OrderMessageDTO orderMessageDTO) {

    }

    public List<OrderResponeDTO> searchOrder(OrderQuery orderQuery) {
        try {
            // 创建 BoolQueryBuilder
            BoolQuery.Builder boolQueryBuilder = new BoolQuery.Builder();

            // 添加条件：orderNo（精确匹配）
            if (!StringUtils.isEmpty(orderQuery.getOrderNo())) {
                boolQueryBuilder.must(Query.of(q -> q
                        .term(t -> t
                                .field("orderNo")
                                .value(orderQuery.getOrderNo())
                        )
                ));
            }

            // 添加条件：orderStatus（精确匹配）
            if (orderQuery.getOrderStatus() != null) {
                boolQueryBuilder.must(Query.of(q -> q
                        .term(t -> t
                                .field("orderStatus")
                                .value(orderQuery.getOrderStatus())
                        )
                ));
            }

            // 添加条件：storeId（精确匹配）
            if (orderQuery.getStoreId() != null ) {
                boolQueryBuilder.must(Query.of(q -> q
                        .term(t -> t
                                .field("storeId")
                                .value(orderQuery.getStoreId())
                        )
                ));
            }

            // 构建查询
            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index(INDEX_NAME)
                    .query(Query.of(q -> q
                            .bool(boolQueryBuilder.build())
                    ))
                    //排序
                    .sort(Lists.newArrayList(SortOptions.of(so -> so.field(f -> f.field("created").order(SortOrder.Desc)))))
                    //分页
                    .from((orderQuery.getPage()-1)*orderQuery.getSize())
                    .size(orderQuery.getSize())
            );
            // 执行查询
            SearchResponse<OrderResponeDTO> searchResponse = elasticsearchClient.search(searchRequest, OrderResponeDTO.class);
            if (searchResponse.hits().hits().size()==0){
                return null;
            }

            List<OrderResponeDTO> orderResponeDTOList = Lists.newArrayList();
            for (int i = 0; i < searchResponse.hits().hits().size(); i++) {
                OrderResponeDTO orderResponeDTO = searchResponse.hits().hits().get(i).source();
                orderResponeDTOList.add(orderResponeDTO);
            }
            long value = searchResponse.hits().total().value();
            return orderResponeDTOList;
        } catch (Exception e) {
            log.error("ES查询失败", e);
        }
        return null;
    }
}
