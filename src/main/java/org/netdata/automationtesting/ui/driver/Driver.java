package org.netdata.automationtesting.ui.driver;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static io.vavr.API.*;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Driver {

    @Bean(destroyMethod = "quit")
    @Scope(value = SCOPE_SINGLETON)
    private WebDriver getWebDriver(
            @Value("${driver.to.use}") String driverToUse,
            @Value("${implicit.wait}") Integer implicitWait,
            @Value("${page.load.timeout}") Integer pageLoadTimeOut
    ) {
        WebDriver webDriver = Match(driverToUse.toLowerCase()).of(
                Case($("ie"), () -> {
                    edgedriver().setup();
                    return new EdgeDriver();
                }),
                Case($("firefox"), () -> {
                    firefoxdriver().setup();
                    return new FirefoxDriver();
                }),
                Case($(), () -> {
                    chromedriver().setup();
                    return new ChromeDriver();
                })
        );
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
        return webDriver;
    }


}
