package pageOject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    @FindBy(css = "input[type=email]")
    public WebElement email;
    @FindBy(css = "button[class^=next-btn]")
    public WebElement registerBtn;
    @FindBy(css = "div[style=\"clear:both;\"] span")
    public WebElement errorLabel;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }
    public void open(){
        this.driver.get("http://testmaster.vn/");
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(this.driver, this);
    }
    By popupLocator = By.cssSelector("div.alert");
    By popupTextLocator = By.cssSelector("div.body-message");
    By popupAgreeBtn = By.cssSelector("button#allow-button");
    By extraPopupLocator = By.cssSelector("div.extra-subscription-form");
    By defaultGenderLocator = By.cssSelector("button#ddlGender span");
    By defaultNewstypeLocator = By.cssSelector("button#ddlNewsType span");
    By fullnameLocator = By.cssSelector("input#fullname");
    By extraPopupAgreeBtn = By.cssSelector("button#allow-button");
    By popupErrorLabel = By.cssSelector("div.error");
    public WebElement getPopup(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 30);
        WebElement popupEl = waiter.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
        return popupEl;
    }
    public String getPopupText(){
        WebElement popupEl = this.getPopup();
        return popupEl.findElement(popupTextLocator).getText();

    }
    public void agreePopup(){
        this.getPopup().findElement(popupAgreeBtn).click();

    }
    public WebElement getActiveEl(){
        WebElement activeEl = this.driver.switchTo().activeElement();
        return activeEl;
    }
    public WebElement getExtraPopup(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 30);
        WebElement extraPopup = waiter.until(ExpectedConditions.visibilityOfElementLocated(extraPopupLocator));
        return extraPopup;


    }
    public WebElement getDefaultGender(){

        return this.getExtraPopup().findElement(defaultGenderLocator);
    }
    public WebElement getDefaultNewstype(){
        return this.getExtraPopup().findElement(defaultNewstypeLocator);

    }
    public WebElement getFullnameEl(){
        return this.getExtraPopup().findElement(fullnameLocator);
    }
    public void agreeExtraPopup(){
        this.getExtraPopup().findElement(extraPopupAgreeBtn).click();
    }
    public WebElement getErrorLabel(){
        return this.getExtraPopup().findElement(popupErrorLabel);
    }


}
