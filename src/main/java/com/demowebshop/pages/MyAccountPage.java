package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements**/
    private final String _account="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath=_account) WebElement accountEmail;

    /** User Actions **/
    public String getUserName(){
        String emailId=page.getElementText(accountEmail);
        return emailId;
    }


}
