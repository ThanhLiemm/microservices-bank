package com.thanhliem.messages.functions;

import com.thanhliem.messages.viewmodal.AccountMessageVM;
import java.util.function.Function;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageFunction {

    Logger logger = Logger.getLogger(MessageFunction.class.getName());

    @Bean
    public Function<AccountMessageVM, AccountMessageVM> email() {
        return message -> {
            logger.info("Email received: " + message.toString());
            return message;
        };
    }

    @Bean
    public Function<AccountMessageVM, Long> sms() {
        return message -> {
            logger.info("SMS received: " + message.toString());
            return message.accountNumber();
        };
    }

}
