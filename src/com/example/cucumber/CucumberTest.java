package com.example.cucumber;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format="html:output")
@Ignore //Uncomment if you want to run this test.
public class CucumberTest {

}
