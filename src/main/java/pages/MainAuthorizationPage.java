package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.ConfProperties;

public class MainAuthorizationPage {

    WebDriver driver;
    WebDriverWait wait;
    public MainAuthorizationPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(xpath = "//a[text()='Вход в систему']")
    private WebElement loginLink;

    @FindBy(id = "userID")
    private WebElement userID;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Вход в систему']")
    private WebElement enterButton;

    public void sendUserIdAndPassword(){
        loginLink.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(userID,password, enterButton));
        userID.sendKeys(ConfProperties.getProperty("kgr_operator"));
        password.sendKeys(ConfProperties.getProperty("password"));
        enterButton.click();
    }
}