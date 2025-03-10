package com.example.user.converter;

import com.example.user.dto.AccountDTO;
import com.example.user.pojo.Account;
import com.example.user.vo.AccountVO;

public class AccountConverter {

    /**
     * DTO转换成POJO
     */
    public static Account toPO(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setName(accountDTO.getName());
        account.setPassword(accountDTO.getPassword());
        account.setPhone(accountDTO.getPhone());
        account.setEmail(accountDTO.getEmail());
        account.setAccount(accountDTO.getAccount());
        return account;
    }

    /**
     * POJO转换成VO
     */
    public static AccountVO toVO(Account account) {
        AccountVO accountVO = new AccountVO();
        accountVO.setId(account.getId());
        accountVO.setName(account.getName());
        accountVO.setPassword(account.getPassword());
        accountVO.setPhone(account.getPhone());
        accountVO.setEmail(account.getEmail());
        accountVO.setAccount(account.getAccount());
        accountVO.setLastLogin(account.getLastLogin());
        accountVO.setCreated(account.getCreated());
        accountVO.setUpdated(account.getUpdated());
        return accountVO;
    }
}
