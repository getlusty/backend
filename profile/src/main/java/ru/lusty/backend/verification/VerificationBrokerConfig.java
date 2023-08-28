package ru.lusty.backend.verification;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerificationBrokerConfig {

    @Bean("verifications")
    public FanoutExchange verifications() {
        return new FanoutExchange("verifications", true, false);
    }

    @Bean("verificationsPhoto")
    public FanoutExchange verificationsPhoto() {
        return new FanoutExchange("verifications-photo", true, false);
    }

}
