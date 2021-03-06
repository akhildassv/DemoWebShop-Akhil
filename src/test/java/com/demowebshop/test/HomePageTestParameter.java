package com.demowebshop.test;

import com.demowebshop.automationcore.BaseParameter;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTestParameter extends BaseParameter {
    HomePage home;

    @Test(priority = 1,enabled = true,description = "TC_001_Verify Home Page Title")
    public void verifyHomePageTitle() {
        home = new HomePage(driver);
        String expectedTitle = "Demo Web Shop";
        String actualTitle = home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
