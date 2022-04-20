package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LogInPage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LogInPageTest extends Base {
    HomePage home;
    LogInPage login;
    MyAccountPage account;
    ExcelUtility excel;
    public String actualTitle;
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

    @Test
    public void verifyLogin1() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> datas=login.getExcelData();
        login.enterUserName(datas.get(3));
        login.enterPassword(datas.get(4));
        account=login.clickOnLoginButton();
        String actual_mailId=account.getUserName();
        String expected_mailId=datas.get(3);
        Assert.assertEquals(actual_mailId,expected_mailId,"LogIn Failed");
    }
    @Test
    public void verifyLoginPageTitle() {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        String expectedTitle = "Demo Web Shop. Login";
        String actualTitle =login.getLoginPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
