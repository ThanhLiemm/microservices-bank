package com.thanhliem.accounts.service.client;

import com.thanhliem.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;

public class LoansFallback implements LoansFeignClient{
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
