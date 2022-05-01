package com.cybertek.tests.day18_html_report;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ExtentReportExample {
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest test;

    @BeforeMethod
    public void setUp(){
        report = new ExtentReports();
        // i need to point to the location where report will be create
        // System.getProperty("user.dir") --> gets my current folder
        // + "/test-output/report.html" --> create folder test-output and in it create file report.html
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        // initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests");// this will be the whole report's name
        // attach the html reporter to the report object
        report.attachReporter(htmlReporter);
        // set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome"); }

    @Test
    public void test(){
        // we have to create a test for every test case
        test = report.createTest("Google Title verification test");
        test.info("Opening browser");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        test.info("going to website");
        String google = "https://google.com";
         driver.get(google);
        test.info("verifying title");
         Assert.assertEquals(driver.getTitle().toLowerCase(), "google");
        test.pass("VYT-123 Title verification test"); }

    @AfterMethod
    public void tearDown(){
// the report will be created when we call this line. If we don't call flush method, it will not be generated. // we do this at the end of everything.
        report.flush(); }}
