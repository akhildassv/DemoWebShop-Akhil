package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage home;

   // @Test(priority = 1,enabled = true,description = "TC_001_Verify Home Page Title")
    @Test(groups = {"sanity"})
    public void verifyHomePageTitle() {
        home = new HomePage(driver);
        String expectedTitle = "Demo Web Shop";
        String actualTitle = home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
