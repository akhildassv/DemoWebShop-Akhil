package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends ObjectUtility {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    /** Page Elements**/
    private final String _selectGender="//label[contains(@for,'gender')]";
    @FindBy(css=_selectGender) WebElement genderselection;

    private final String _fname="//input[@id='FirstName']";
    @FindBy(xpath=_fname) WebElement fname;

    private final String _lastname="//input[@id='LastName']";
    @FindBy(xpath=_lastname) WebElement lasttname;

    private final String _email="//input[@id='Email']";
    @FindBy(xpath=_email) WebElement email;

    private final String _password="//input[@id='Password']";
    @FindBy(xpath=_password) WebElement password;

    private final String _Confpassword="//input[@id='ConfirmPassword']";
    @FindBy(xpath=_Confpassword) WebElement confPassword;

    private final String _registerbutton="//input[@id='register-button']";
    @FindBy(xpath=_registerbutton) WebElement registerbutton;

    /** User Actions **/
    public void selectGender(String gender) {
        List<WebElement> options = driver.findElements(By.xpath("//label[contains(@for,'gender')]"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase(gender)) {
                options.get(i).click();
            }
        }
    }

    public void enterfirstName(String uName) {
        page.enterText(fname, uName);
    }

    public void enterLastName(String uName) {
        page.enterText(lasttname, uName);
    }

    public void enteremail(String uName) {
        page.enterText(email, uName);
    }

    public void enterPassword(String uName) {
        page.enterText(password, uName);
    }

    public void enterConfPassword(String uName) {
        page.enterText(confPassword, uName);
    }

    public MyAccountPage clickOnRegisterButton() {
        page.clickOnElement(registerbutton);
        return new MyAccountPage(driver);
    }

    public String getRegisterPageTitle() {
        String registertitle = page.getPageTitle(driver);
        return registertitle;
    }

}
