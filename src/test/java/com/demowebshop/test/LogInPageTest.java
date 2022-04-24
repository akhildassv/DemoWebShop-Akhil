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
    ExcelUtility excel=new ExcelUtility();

    //@Test(groups = {"sanity"},priority = 2,enabled = true,description = "TC_001_Verify valid User Login")
    @Test(groups = {"sanity"})
    public void verifyLogin() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> datas=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "LoginPage");
        login.enterUserName(datas.get(3));
        login.enterPassword(datas.get(4));
        account=login.clickOnLoginButton();
        String actual_mailId=account.getUserName();
        String expected_mailId=datas.get(3);
        Assert.assertEquals(actual_mailId,expected_mailId,"LogIn Failed");
    }
   // @Test(priority = 3,enabled = true,description = "TC_001_Verify Login Page Title")
    @Test(groups = {"smoke"})
    public void verifyLoginPageTitle() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> datas=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "LoginPage");
        String expectedTitle =datas.get(5);
        String actualTitle =login.getLoginPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }

}
