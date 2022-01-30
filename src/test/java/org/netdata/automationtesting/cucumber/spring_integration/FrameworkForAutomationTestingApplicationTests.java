package org.netdata.automationtesting.cucumber.spring_integration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.netdata.automationtesting.FrameworkForAutomationTestingApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@CucumberContextConfiguration
@SpringBootTest(classes = FrameworkForAutomationTestingApplication.class)
public class FrameworkForAutomationTestingApplicationTests {}
