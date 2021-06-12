package br.ce.wcaquino.taskbackend.runners;


import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "br/ce/wcaquino/taskbackend/steps",
        snippets = CAMELCASE,
        dryRun = false,
        plugin = {
                "pretty",
                "junit:target/cucumber-reports/cucumber_junit.xml",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"
        },
        stepNotifications = true
)
public class DataUtilRunnerTest {
}
