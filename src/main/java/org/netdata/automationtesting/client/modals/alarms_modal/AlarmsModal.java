package org.netdata.automationtesting.client.modals.alarms_modal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.netdata.automationtesting.client.elements.IModal;
import org.netdata.automationtesting.client.modals.alarms_modal.body.AlarmsModalBody;
import org.netdata.automationtesting.client.pages.IPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlarmsModal implements IModal {

    @FindBy(id = "alarmsModalLabel")
    @NonFinal WebElement title;

    @FindBy(xpath = "//button[@type='button' and contains(text(),'Close') and ancestor::div[@id='alarmsModal']]")
    @NonFinal WebElement closeButton;

    WebDriver webDriver;

    public String getTitle() {
        return title.getText();
    }

    @Override
    public <T> T getBody() {
        return (T) PageFactory.initElements(webDriver, AlarmsModalBody.class);
    }

    @Override
    public void close() {
        closeButton.click();
    }

    @Override
    public <T extends IPage> T close(T pageToReturnTo) {
        closeButton.click();
        return pageToReturnTo;
    }

}
