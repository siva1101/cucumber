package cucucasestudy;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\training_c2a.05.01\\Documents\\CucumberCaseStudy\\src\\resources\\java\\registration.feature",
		plugin= {"html:target/Reports"} 
)

public class TestRunner {

}
