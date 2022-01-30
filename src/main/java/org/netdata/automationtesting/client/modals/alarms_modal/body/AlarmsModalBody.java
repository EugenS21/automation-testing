package org.netdata.automationtesting.client.modals.alarms_modal.body;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlarmsModalBody {

    WebDriver webDriver;

    @FindBy(how = How.XPATH, using = "//div[@class='modal-body' and ancestor::div[@id='alarmsModal']]")
    @NonFinal WebElement alarmsModal;

    public List<Tab> getTabs() {
        return alarmsModal.findElements(By.xpath("//li//a[@role='tab']")).stream()
                .map(WebElement::getText)
                .map(tabName -> new Tab(webDriver, alarmsModal, tabName))
                .collect(Collectors.toList());
    }

    public Tab getTab(String name) {
        return getTabs().stream()
                .filter(el -> el.getTitle().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find any tab with name: " + name));
    }

}
