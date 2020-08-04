package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./Features/Login.feature",
                 glue= {"stepDefinations"},
                 dryRun=false,
                 plugin= {"pretty","html:test-output.html"},
                // tags= {"@sanity"},
                 monochrome=true
                 
                   )
public class TestRun {

}
