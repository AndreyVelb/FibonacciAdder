package com.velb.fibonacciadder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.codec.CharSequenceEncoder;
import org.springframework.core.codec.StringDecoder;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class RsocketClientConfig {


    @Bean
    public RSocketStrategies rsocketStrategies() {
        return RSocketStrategies.builder()
                .decoder(StringDecoder.allMimeTypes())
                .encoder(CharSequenceEncoder.allMimeTypes())
                .dataBufferFactory(new DefaultDataBufferFactory(true))
                .build();
    }

    @Bean
    public RSocketRequester getRSocketRequester(){
        RSocketRequester.Builder builder = RSocketRequester.builder();

        return builder
                .rsocketConnector(
                        rSocketConnector ->
                                rSocketConnector.reconnect(Retry.fixedDelay(2, Duration.ofSeconds(2)))
                )
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .rsocketStrategies(rsocketStrategies())
                .tcp("localhost", 7000);
    }


}
