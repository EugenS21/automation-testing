package org.netdata.automationtesting.rest.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.rest.dto.AlarmDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlarmService {

    WebClient webClient;

    public AlarmService(WebClient webClient) {
        this.webClient = webClient.mutate()
                .baseUrl("http://localhost:19999/api/v1/".concat("alarms"))
                .build();
    }

    public AlarmDto getActiveAlarms() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.query("active").build())
                .retrieve()
                .bodyToMono(AlarmDto.class)
                .block();
    }

}
