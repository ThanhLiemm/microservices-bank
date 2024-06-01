package com.thanhliem.accounts.service.impl;

import com.thanhliem.accounts.dto.AccountsDto;
import com.thanhliem.accounts.dto.CardsDto;
import com.thanhliem.accounts.dto.CustomerDetailsDto;
import com.thanhliem.accounts.dto.LoansDto;
import com.thanhliem.accounts.entity.Accounts;
import com.thanhliem.accounts.entity.Customer;
import com.thanhliem.accounts.repository.AccountsRepository;
import com.thanhliem.accounts.repository.CustomerRepository;
import com.thanhliem.accounts.service.ICustomersService;
import com.thanhliem.accounts.service.client.CardsFeignClient;
import com.thanhliem.accounts.service.client.LoansFeignClient;
import com.thanhliem.accounts.utils.exception.ResourceNotFoundException;
import com.thanhliem.accounts.utils.mapper.AccountsMapper;
import com.thanhliem.accounts.utils.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements ICustomersService {

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardsFeignClient cardsFeignClient;
    @Autowired
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account", "customerId",
                                customer.getCustomerId().toString())
                );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer);
        customerDetailsDto.setAccountsDto(
                AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(
                mobileNumber, correlationId);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(
                mobileNumber, correlationId);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
