package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements**/
    private final String _loginMenu="li>a[class='ico-login'";
    @FindBy(css=_loginMenu) WebElement loginMenu;

    private final String _registermenu="li>a[class='ico-register']";
    @FindBy(css=_registermenu) WebElement registermenu;

    /**User Actions Methods**/

    public String getHomePageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }

    public LogInPage clickOnLoginMenu(){
        page.clickOnElement(loginMenu);
        return new LogInPage(driver);
    }
    public RegisterPage clickOnRegisterButton(){
        page.clickOnElement(registermenu);
        return new RegisterPage(driver);
    }
}
