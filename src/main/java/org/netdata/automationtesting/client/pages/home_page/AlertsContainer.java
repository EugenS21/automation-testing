package org.netdata.automationtesting.client.pages.home_page;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.netdata.automationtesting.client.modals.alarms_modal.AlarmsModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlertsContainer {

    @FindBy(xpath = "//span[@color=\"warning\" and ancestor::div[@data-target=\"#alarmsModal\"]]")
    @NonFinal WebElement warningAlarms;
    @FindBy(xpath = "//span[@color=\"error\" and ancestor::div[@data-target=\"#alarmsModal\"]]")
    @NonFinal WebElement errorAlarms;

    WebDriver webDriver;

    public String getErrorAlarmsCount() {
        return errorAlarms.getText();
    }

    public String getWarningAlarmsCount() {
        return warningAlarms.getText();
    }

    public AlarmsModal getErrorDetails() {
        errorAlarms.click();
        return PageFactory.initElements(webDriver, AlarmsModal.class);
    }

}
