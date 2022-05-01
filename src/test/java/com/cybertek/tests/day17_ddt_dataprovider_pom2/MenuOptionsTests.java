package com.cybertek.tests.day17_ddt_dataprovider_pom2;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuOptionsTests extends VytrackTestBase {

    @Test
    public void test() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                        ConfigurationReader.getProperty("driver_password"));
        dashboardPage.changeMenu("Activities", "Calendar Events");
        wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
        assertEquals(driver.getTitle(), "Calendar Events - Activities"); }

    // DDT test
    @Test(dataProvider = "test-data")
                        //st dropdown, 2nd dropdown, title of page
    public void ddtTest(String menu1, String menu2, String expectedTitle){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                        ConfigurationReader.getProperty("driver_password"));
        //this sentence below will change page from one dropdown to another
        dashboardPage.changeMenu(menu1, menu2);
        //getTitle is java method that gets title of page
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertTrue(driver.getTitle().contains(expectedTitle)); }

    @DataProvider(name = "test-data")
    public Object[][] getData(){
        return new Object[][]{
                //here 1st String is 1st dropdown, 2nd string is 2nd dropdown, 3rd string is page title in Vytrack website.
                //these String will be used by (String menu1, String menu2, String expectedTitle)
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                {"System", "System Calendars", "System Calendars - System"}}; }

    // login as driver
    // verify that driver can see menu options Fleet, Customers, Activities, System
    @Test
    public void testAllOptionsDriver(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                        ConfigurationReader.getProperty("driver_password"));
        List<String> expected = Arrays.asList("Fleet", "Customers", "Activities", "System");
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(actualList, expected); }}
