package com.example.user.controller;

import com.example.user.dto.AccountDTO;
import com.example.user.request.LoginReq;
import com.example.user.response.Result;
import com.example.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 登录
     * @param req
     * @return
     */
    @RequestMapping( value = "/login")
    public Result login(@RequestBody LoginReq req){
        return Result.success(accountService.login(req));
    }

    /**
     * 根据id获取账号信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAccountById")
    public Result getAccountById(Long id) {
        return Result.success(accountService.getAccountById(id));
    }

    /**
     * 创建账号
     * @param accountDto
     * @return
     */
    @RequestMapping(value = "/createAccount")
    public Result createAccount(@RequestBody AccountDTO accountDto)   {
        return Result.success(accountService.createAccount(accountDto));
    }
}
