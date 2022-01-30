package org.netdata.automationtesting.rest.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AlarmDto {

    String hostname;
    Integer latestAlarmLogUniqueId;
    Boolean status;
    Integer now;
    Map alarms;

}
