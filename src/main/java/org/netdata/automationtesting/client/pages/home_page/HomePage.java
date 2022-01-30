package org.netdata.automationtesting.client.pages.home_page;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.client.pages.IPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomePage implements IPage {

    @Getter
    Footer footer;
    WebDriver webDriver;

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public void open() {
        webDriver.get("http://localhost:19999");
    }
}
