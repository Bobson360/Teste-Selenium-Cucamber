package test.atomic.tAutomation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.TestCase;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features", glue = "test.atomic.tAutomation.Steps")
public class Test extends TestCase {
}
