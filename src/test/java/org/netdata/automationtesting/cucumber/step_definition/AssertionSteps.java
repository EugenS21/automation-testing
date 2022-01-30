package org.netdata.automationtesting.cucumber.step_definition;

import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.netdata.automationtesting.client.pages.home_page.HomePage;
import org.netdata.automationtesting.cucumber.assertion.SoftAssert;
import org.netdata.automationtesting.cucumber.context.ScenarioContext;
import org.netdata.automationtesting.rest.dto.AlarmDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.netdata.automationtesting.cucumber.context.StorageKey.ALARMS_COUNT;
import static org.netdata.automationtesting.cucumber.context.StorageKey.ALARMS_REST;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssertionSteps {

    ScenarioContext scenarioContext;
    SoftAssert softAssertions;
    HomePage homePage;

    @Then.Thens({@Then("expecting {} warning alarms count"), @Then("expecting {} error alarms count")})
    @SneakyThrows
    public void assertCount(String alarmsCount) {
        String actualValue = scenarioContext.getFromStorage(ALARMS_COUNT, String.class);
        softAssertions.assertThat(alarmsCount)
                .describedAs("Unexpected alarms count")
                .isEqualTo(actualValue);
    }

    @Then("expecting {int} alarms")
    public void expectingAlarms(int alarmsCount) {
        AlarmDto alarmFromRest = scenarioContext.getFromStorage(ALARMS_REST, AlarmDto.class);
        softAssertions.assertThat(alarmFromRest)
                .extracting(AlarmDto::getAlarms)
                .extracting(Map::size)
                .isEqualTo(alarmsCount);
    }

    @Then("user is on home page")
    public void userIsOnHomePage() {
        softAssertions.assertThat(homePage.getTitle())
                .describedAs("Unexpecting page title")
                .contains("netdata dashboard");
    }
}
