package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="D:\\MyStoreProject\\src\\test\\resources\\Features",glue= {"StepDefinations","applicationHooks"})
public class TestRunner {

}
