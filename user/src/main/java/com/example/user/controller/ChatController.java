package com.example.user.controller;


import com.example.user.dto.ReturnMessageDTO;
import com.example.user.dto.SendMessageDTO;
import com.zhipu.oapi.ClientV4;
import com.zhipu.oapi.Constants;
import com.zhipu.oapi.service.v4.model.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class ChatController {


    @GetMapping("/ai/generate")
    public Choice generate(@RequestParam(value =  "message", defaultValue =  "Tell me a joke") String message) {
        ClientV4 client = new ClientV4.Builder("515fc186b84f418495882b38fa5f3edf.KKQ6SSgthTLYLH2U").build();
        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage chatMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        messages.add(chatMessage);
        String requestId = UUID.randomUUID()+"";

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(Constants.ModelChatGLM4)
                .stream(Boolean.FALSE)
                .invokeMethod(Constants.invokeMethod)
                .messages(messages)
                .requestId(requestId)
                .build();
        ModelApiResponse invokeModelApiResp = client.invokeModelApi(chatCompletionRequest);
        try {
            List<Choice> choices = invokeModelApiResp.getData().getChoices();
            if (choices != null && choices.size() > 0){
                //System.out.println("model output:" + Jackson.toJSONString(choices.get(0).getMessage().getContent()));
                return choices.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 处理客户端发送到 /app/user 的消息
    @MessageMapping("/user")
    @SendTo("/topic/messages") // 广播到所有订阅 /topic/messages 的客户端
    public ReturnMessageDTO returnMessage(SendMessageDTO sendMessageDTO) {
        Choice choice = generate(sendMessageDTO.getContent());
        if (choice != null) {
            ReturnMessageDTO returnMessageDTO = new ReturnMessageDTO();
            returnMessageDTO.setContent((String) choice.getMessage().getContent());
            returnMessageDTO.setSender("AI小薛");
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            String currentTime = sendMessageDTO.getCurrentTime();
            returnMessageDTO.setCurrentTime(simpleDateFormat.format(date));
            return returnMessageDTO;
        }
        return null;
    }
}
