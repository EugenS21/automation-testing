package org.netdata.automationtesting.client.modals.alarms_modal.body;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.client.elements.ITab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Tab implements ITab {

    WebDriver webDriver;
    WebElement tab;

    @Getter
    String title;

    @Autowired
    public Tab(WebDriver webDriver, WebElement tabsHeader, String tabName) {
        this.webDriver = webDriver;
        this.title = tabName;
        this.tab = tabsHeader.findElement(By.xpath(format("//a[contains(text(), '%s')]", tabName)));
    }

    @Override
    @SneakyThrows
    public <T> T getBody(Class<T> clazz) {
        T dynamicBody = clazz.getDeclaredConstructor(WebElement.class).newInstance(tab);
        PageFactory.initElements(webDriver, dynamicBody);
        return dynamicBody;
    }

    @Override
    public void open() {
        tab.click();
    }

}