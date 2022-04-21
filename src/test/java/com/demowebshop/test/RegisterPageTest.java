package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterPageTest extends Base {
    RegisterPage register;
    HomePage home;
    MyAccountPage account;
    ExcelUtility excel=new ExcelUtility();


    @Test(priority = 4,enabled = true,description = "TC_001_Verify Registration")
    public void verifyRegister() throws IOException {
        home=new HomePage(driver);
        register=home.clickOnRegisterButton();
        List<String> datas=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "RegisterPage");
        register.selectGender(datas.get(6));
        register.enterfirstName(datas.get(7));
        register.enterLastName(datas.get(8));
        RandomDataUtility randomdata=new RandomDataUtility();
        String randomMail=randomdata.getRandomMail();
        register.enteremail(randomMail);
        System.out.println(randomMail);
        register.enterPassword(datas.get(9));
        register.enterConfPassword(datas.get(10));
        account=register.clickOnRegisterButton();
        String actual_mailId=account.getUserName();
        String expected_mailId=randomMail;
        Assert.assertEquals(actual_mailId,expected_mailId,"LogIn Failed");
    }
    @Test(priority = 5,enabled = true,description = "TC_001_Verify Register Page Title")
    public void verifyLoginPageTitle() throws IOException {
        home=new HomePage(driver);
        register=home.clickOnRegisterButton();
        List<String> datas=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "RegisterPage");
        String expectedTitle =datas.get(11);
        String actualTitle =register.getRegisterPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
