package org.netdata.automationtesting.client.modals.alarms_modal.body;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.client.elements.ITable;
import org.netdata.automationtesting.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlarmsTable implements ITable {

    List<String> columnNames;
    List<String> rowValue;

    public AlarmsTable(WebElement root) {
        this.columnNames = root.findElements(By.xpath("//table//th//div[contains(@class,'sortable')]")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        this.rowValue = root.findElements(By.xpath("//table//tbody//td[@style]")).stream()
                .map(WebElement::getText)
                .filter(el -> !el.isBlank())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<String>> getTableBody() {
        return Utils.getMapFromLists.apply(columnNames, rowValue);
    }
}
