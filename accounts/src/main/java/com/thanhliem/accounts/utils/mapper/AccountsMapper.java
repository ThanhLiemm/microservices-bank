package com.thanhliem.accounts.utils.mapper;

import com.thanhliem.accounts.dto.AccountsDto;
import com.thanhliem.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static AccountsDto mapToAccountsDto(Accounts accounts) {
        return mapToAccountsDto(accounts, new AccountsDto());
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

    public static Accounts mapToAccounts(AccountsDto accountDto) {
        return mapToAccounts(accountDto, new Accounts());
    }
}
