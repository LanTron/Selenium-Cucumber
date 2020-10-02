package lanNewTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageOject.HomePage;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void initTest(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\WebDriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(this.driver);

    }
    @Given("^The testmaster homepage has been shown$")
    public void the_testmaster_homepage_has_been_shown(){
        this.homePage.open();


    }

    @When("^The user subscribe with an invalid email (.+)$")
    public void the_user_subscribe_with_an_invalid_email(String email){
        this.homePage.email.sendKeys(email);
        this.homePage.registerBtn.click();

    }

    @Then("^The error message \"([^\"]*)\" is shown in red color$")
    public void the_error_message_something_is_shown_in_red_color(String message){

        Assert.assertEquals(message, this.homePage.errorLabel.getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)",this.homePage.errorLabel.getCssValue("color"));

    }

    @And("^The border of email field is changed to red color$")
    public void the_border_of_email_field_is_changed_to_red_color(){
        Assert.assertEquals("rgb(255, 0, 0)",this.homePage.email.getCssValue("border-color"));

    }

    //Scenario 2
    @Given("^The testmaster hompage has been shown$")
    public void the_testmaster_hompage_has_been_shown() {
        this.homePage.open();

    }

    @When("^The user subscribe with an email \"([^\"]*)\" in used$")
    public void the_user_subscribe_with_an_email_something_in_used(String email) {
        this.homePage.email.sendKeys(email);
        this.homePage.registerBtn.click();

    }

    @Then("^The message \"([^\"]*)\" is shown$")
    public void the_message_something_is_shown(String message) {
        Assert.assertTrue(this.homePage.getPopup()!=null);
        System.out.println(this.homePage.getPopupText());
        Assert.assertEquals(message, this.homePage.getPopupText());


    }

    @And("^The focus is set back Email field after the user agree with the message$")
    public void the_focus_is_set_back_email_field_after_the_user_agree_with_the_message() {
        this.homePage.agreePopup();
        WebElement focusEl = this.homePage.getActiveEl();
        Assert.assertEquals("email", focusEl.getAttribute("type"));

    }

    @And("^The content of Email field is cleared$")
    public void the_content_of_email_field_is_cleared() {
        Assert.assertTrue(this.homePage.email.getText().isEmpty());

    }
    //Scenario 3
    @Given("^The testmaster homepage is shown$")
    public void the_testmaster_homepage_is_shown() {
        this.homePage.open();

    }

    @When("^The user subscribes with email\"([^\"]*)\" not in used$")
    public void the_user_subscribes_with_emailsomething_not_in_used(String email)  {
        this.homePage.email.sendKeys(email);
        this.homePage.registerBtn.click();

    }

    @Then("^The extra information popup is shown with default value of gender and news type$")
    public void the_extra_information_popup_is_shown_with_default_value_of_gender_and_news_type() {
        Assert.assertTrue(this.homePage.getExtraPopup()!=null);
        Assert.assertEquals("Không xác định", this.homePage.getDefaultGender().getText());
        Assert.assertEquals("Nhận tất cả các loại tin", this.homePage.getDefaultNewstype().getText());


    }

    @And("^The focus is set on Fullname field$")
    public void the_focus_is_set_on_fullname_field() {

        Assert.assertEquals("true", this.homePage.getFullnameEl().getAttribute("autofocus"));

    }
    //scenario 4
    /*@Given("^The testmaster homepage is shown$")
    public void the_testmaster_homepage_is_shown(){
    }*/

    @When("^The user subscribe with fullname blank on the extra popup$")
    public void the_user_subscribe_with_fullname_blank_on_the_extra_popup(){
        this.homePage.email.sendKeys("lan1.pc.hbt@gmail.com");
        this.homePage.registerBtn.click();
        this.homePage.agreeExtraPopup();

    }

    @Then("^The require message \"([^\"]*)\" is shown with red color$")
    public void the_require_message_something_is_shown_with_red_color(String message) {
        WebElement popupErrorLabel = this.homePage.getErrorLabel();
        Assert.assertEquals(message, popupErrorLabel.getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", popupErrorLabel.getCssValue("color"));

    }

    @And("^The border of fullname field is changed to red and the background is yellow$")
    public void the_border_of_fullname_field_is_changed_to_red_and_the_background_is_yellow() {
        WebElement fullname = this.homePage.getFullnameEl();
        Assert.assertEquals("rgb(243, 47, 47)", fullname.getCssValue("border-color"));
        Assert.assertEquals("rgba(255, 255, 0, 1)", fullname.getCssValue("background-color"));

    }

    @After
    public void finishTest(){
        this.driver.quit();

    }

}
