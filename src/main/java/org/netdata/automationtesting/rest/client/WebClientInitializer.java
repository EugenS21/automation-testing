package org.netdata.automationtesting.rest.client;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Component
public class WebClientInitializer {

    @Bean
    public WebClient webClient(
            @Value("${base.url}") String baseUrl,
            @Value("${rest.call.timeout}") Integer restCallTimeout
    ) {
        HttpClient httpClient = HttpClient.create()
                .option(CONNECT_TIMEOUT_MILLIS, restCallTimeout)
                .responseTimeout(Duration.ofMillis(restCallTimeout))
                .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(restCallTimeout, MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(restCallTimeout, MILLISECONDS)));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(baseUrl)
                .build();
    }

}
