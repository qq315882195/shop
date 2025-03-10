package com.example.user.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.user.converter.AccountConverter;
import com.example.user.dto.AccountDTO;
import com.example.user.dto.RegisterMessageDTO;
import com.example.user.enums.ChatErrorEnum;
import com.example.user.exception.BusinessException;
import com.example.user.mapper.AccountMapper;
import com.example.user.pojo.Account;
import com.example.user.request.LoginReq;
import com.example.user.util.MD5Util;
import com.example.user.vo.AccountVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private JmsTemplate jmsTemplate;

    public AccountVO getAccountById(Long id) {
        Account account = accountMapper.selectById(id);
        if (account == null) {
            throw new BusinessException(ChatErrorEnum.ACCOUNT_NOT_EXIST.getDesc(),ChatErrorEnum.ACCOUNT_NOT_EXIST.getCode());
        }
        return AccountConverter.toVO(account);
    }

    public Account createAccount(AccountDTO accountDto) {
        boolean exists = checkAccount(accountDto);
        if (exists){
            throw new BusinessException(ChatErrorEnum.ACCOUNT_ALREADY_EXIST.getDesc(),ChatErrorEnum.ACCOUNT_ALREADY_EXIST.getCode());
        }
        Account account = AccountConverter.toPO(accountDto);
        account.setPassword(MD5Util.encrypt(account.getPassword()));
        int insert = accountMapper.insert(account);
        if (insert == 0) {
            throw new BusinessException(ChatErrorEnum.ACCOUNT_REGISTER_ERROR.getDesc(),ChatErrorEnum.ACCOUNT_REGISTER_ERROR.getCode());
        }
        //发送邮件
        RegisterMessageDTO registerMessageDTO = new RegisterMessageDTO();
        registerMessageDTO.setMessage("注册成功");
        registerMessageDTO.setEmail(account.getEmail());
        jmsTemplate.convertAndSend("register-queue", JSON.toJSONString(registerMessageDTO));

        return account;
    }

    private boolean checkAccount(AccountDTO accountDto) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<Account>();
        queryWrapper.eq(Account::getAccount, accountDto.getAccount());
        Account account = accountMapper.selectOne(queryWrapper, false);
        if (account != null) {
            return true;
        }
        return false;
    }

    public List<Account> getAccountList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return accountMapper.selectList(null);
    }

    public Account login(LoginReq req) {
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<Account>();
        queryWrapper.eq(Account::getAccount, req.getAccount());
        Account account = accountMapper.selectOne(queryWrapper, false);
        if (account == null) {
            throw new BusinessException(ChatErrorEnum.ACCOUNT_NOT_EXIST.getDesc(),ChatErrorEnum.ACCOUNT_NOT_EXIST.getCode());
        }
        String md5Password = MD5Util.encrypt(req.getPassword());

        if (!account.getPassword().equals(md5Password)) {
            throw new BusinessException(ChatErrorEnum.PASSWORD_ERROR.getDesc(),ChatErrorEnum.PASSWORD_ERROR.getCode());
        }
        //更新最后登录的时间
        LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Account::getLastLogin, new Date());
        updateWrapper.eq(Account::getId, account.getId());
        accountMapper.update(null,updateWrapper);
        return account;
    }
}
