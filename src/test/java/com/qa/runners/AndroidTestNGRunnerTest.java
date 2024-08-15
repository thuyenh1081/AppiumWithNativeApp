package com.qa.runners;

import io.cucumber.testng.CucumberOptions;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(
        plugin = {"pretty"
        , "html:target/Pixel4/cucumber"
        , "summary"
        , "me.jvt.cucumber.report.PrettyReports:target/Android/cucumber-html-reports"}
        ,features = {"src/test/resources/"}
        ,glue = {"com.qa.stepdef"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@Pre_CFD"
        )
public class AndroidTestNGRunnerTest extends RunnerBase {

}