package com.thanhliem.accounts.service;

import com.thanhliem.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     * @param customerDto - CustomerDto
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - String
     * @return CustomerDto - Get account details based on mobile number
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * @param customerDto
     * @return boolean - Return boolean indicating if the update of account details is successful
     * of not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - String
     * @return boolean - Return boolean indicating if the delete of account is successful of not
     */
    boolean deleteAccount(String mobileNumber);
}
