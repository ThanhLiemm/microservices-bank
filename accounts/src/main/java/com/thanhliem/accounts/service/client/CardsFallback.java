package com.thanhliem.accounts.service.client;

import com.thanhliem.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;

public class CardsFallback implements CardsFeignClient {
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
