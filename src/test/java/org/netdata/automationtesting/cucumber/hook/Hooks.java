package org.netdata.automationtesting.cucumber.hook;

import io.cucumber.java.After;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.cucumber.assertion.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Hooks {

    SoftAssert softAssertions;
    WebDriver webDriver;

    @After("@UI")
    public void closeBrowser() {
        webDriver.close();
    }

    @After
    public void doAssertAll() {
        softAssertions.assertAll();
    }

}
