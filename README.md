# Netdata automation framework solution

Automation framework is execution test cases in gherkin format for both ui and api sides.

##Used Tools:
* java >= 11
* maven - 3.6
* spring boot - 2.6.3
* cucumber - 7.2.3
* lombok - 1.18.22
* vavr - 0.10.4
* webdrivermanager - 5.0.3
* selenium - 3.141.59

##Instructions
Before proceeding to test you need to install netdata, do it by running `mvn compile` command that will trigger a bash script provided in netdata installation instructions.

Run tests via IDE
Open the project in any ide and run org.netdata.automationtesting.cucumber.CucumberRunner class to start the tests.

Run tests via maven command
Execute `mvn verify -P=cucumber` to start test from CLI.

##Choice of frameworks
**Spring boot** - is one of the most popular framework used with Java, it provides a lot of advantages. 
I choosed it because:
* it provides dependency injection mechanism;
* it has embedded property reading and injection mechanism;
* it has embedded web client used in rest tests.

**Cucumber** - is one of the most used tools to write business scenarios that may be verified and approved by a non technical person like business analyst or a junior tester that is familiarizing with the system under test.

**Maven** - I am more familiar with this dependency management tool, so I chose it instead of gradle. 

**Lombok** - this tool is generating a lot of code like setters, getter, acces modifiers and so on, so I included it.

**Vavr** - it wasn't used that much in the current project, but it's a useful tool that reduces amount of code and also it's making code more readable.

**Selenium** - is one of the most popular frameworks to run ui tests.

**webdrivermanager** - this is a small tool that is downloading and installing browser driver to be used by selenium in order to execute actions.

##Smoke suite test plan
If there is no time for a full regression I would prefer to have a smoke pack that includes test that will verify basic flows: 
* opening web client;
* navigating through some categories to verify that statistics are fetched;
* refreshing few times web page to see that statistics are reloading.


