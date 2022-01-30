package org.netdata.automationtesting.client.pages.home_page;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlertsContainer {

    @FindBy(xpath = "//span[@color=\"warning\" and ancestor::div[@data-target=\"#alarmsModal\"]]")
    WebElement warningAlarms;
    @FindBy(xpath = "//span[@color=\"error\" and ancestor::div[@data-target=\"#alarmsModal\"]]")
    WebElement errorAlarms;

    public String getErrorAlarmsCount() {
        return errorAlarms.getText();
    }

    public String getWarningAlarmsCount() {
        return warningAlarms.getText();
    }

}
