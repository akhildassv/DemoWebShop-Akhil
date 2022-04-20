package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LogInPage;
import com.demowebshop.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInPageTest extends Base {
    HomePage home;
    LogInPage login;
    MyAccountPage account;

    @Test(priority = 2,enabled = true,description = "TC_001_Verify valid User Login")
    public void verifyLogin(){
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        login.enterUserName("akhildas710@gmail.com");
        login.enterPassword("akhildas");
        account=login.clickOnLoginButton();
        String actual_mailId=account.getUserName();
        String expected_mailId="akhildas710@gmail.com";
        Assert.assertEquals(actual_mailId,expected_mailId,"LogIn Failed");

    }


}
