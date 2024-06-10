package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//SHIVESH//IdeaProjects//CucumberFramework//Features//OrangeHRM.feature",glue = "StepDefinitions")// giving the location of feature and step definition file









public class orangeHRM_TestRunner {
}
