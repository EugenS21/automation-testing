package org.netdata.automationtesting.cucumber.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.client.pages.home_page.HomePage;
import org.netdata.automationtesting.cucumber.context.ScenarioContext;
import org.netdata.automationtesting.rest.dto.AlarmDto;
import org.netdata.automationtesting.rest.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;

import static org.netdata.automationtesting.cucumber.context.StorageKey.ALARMS_COUNT;
import static org.netdata.automationtesting.cucumber.context.StorageKey.ALARMS_REST;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ActionSteps {

    ScenarioContext scenarioContext;
    HomePage homePage;
    AlarmService alarmService;

    @Given("user navigates to home page")
    public void userNavigatesToHomePage() {
        homePage.open();
    }

    @Given("user read {} alarms count")
    @SneakyThrows
    public void executeTestStep(String alarmType) {
        String count;
        if (alarmType.equalsIgnoreCase("warning")) {
            count = homePage.getFooter().getAlertsContainer().getWarningAlarmsCount();
        } else {
            count = homePage.getFooter().getAlertsContainer().getErrorAlarmsCount();
        }
        scenarioContext.addToStorage(ALARMS_COUNT, count);
    }

    @When("get active alarms")
    public void getActiveAlarms() {
        AlarmDto activeAlarms = alarmService.getActiveAlarms();
        scenarioContext.addToStorage(ALARMS_REST, activeAlarms);
    }

}
