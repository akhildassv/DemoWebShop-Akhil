package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LogInPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements**/
    private final String _loginMenu="li>a[class='ico-login'";
    @FindBy(css=_loginMenu) WebElement loginMenu;

    private final String _username="Email";
    @FindBy(id=_username) WebElement username;

    private final String _password="Password";
    @FindBy(id=_password) WebElement password;

    private final String _loginbutton="div>input[type='submit'";
    @FindBy(css=_loginbutton) WebElement loginbutton;

    /** User Actions **/
    public void enterUserName(String uName){
        page.enterText(username,uName);
    }

    public void enterPassword(String pName){
        page.enterText(password,pName);
    }

    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(loginbutton);
        return new MyAccountPage(driver);
    }

    public List<String> getExcelData() throws IOException {
        List<String> data = excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "LoginPage");
        return data;
    }

    public String getLoginPageTitle(){
        String logintitle=page.getPageTitle(driver);
        return logintitle;
    }
}
