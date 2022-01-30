package org.netdata.automationtesting.service;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NetDataClientDownloaderService {

//    Process process;

    @SneakyThrows
    public NetDataClientDownloaderService(@Value("${command_for_installing}") String commandToRun) {
        log.info("Starting to download and install netdata by running {}", commandToRun);
//        process = Runtime.getRuntime().exec(commandToRun);
//        int exitCode = process.waitFor();
//        log.info("Process finished with code {}", exitCode);
    }

    public void justSaySomething(){
        System.out.println("Say");
    }

}
