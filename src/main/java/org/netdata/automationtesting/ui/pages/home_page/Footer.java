package org.netdata.automationtesting.ui.pages.home_page;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Footer {

    WebDriver webDriver;

    public AlertsContainer getAlertsContainer() {
        return PageFactory.initElements(webDriver, AlertsContainer.class);
    }

}
