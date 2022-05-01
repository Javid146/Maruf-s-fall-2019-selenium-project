package com.cybertek.tests.office_hours4;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertNotEquals;

public class ChangeMenuSoftAssertTest extends VytrackTestBase {

    @Test
    public void testMenuOptions() throws InterruptedException {
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login", "URL did not match");

        dashboardPage.changeMenu("Fleet", "Vehicles");
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getTitle().contains("Car - Entities"), "Vehicles page title did not match");

        Thread.sleep(8000);

        dashboardPage.changeMenu("Customers", "Contacts");
        Thread.sleep(8000);
        softAssert.assertTrue(driver.getTitle().contains("Contacts"), "Accounts page title did not match"); }}
