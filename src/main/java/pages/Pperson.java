package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pperson {

    private WebDriver driver;
    private WebDriverWait wait;

    public Pperson(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(id = "sb.lastName")
    private WebElement lastName;

    @FindBy(xpath = "//a[.//span[text() = 'Найти']]")
    private WebElement findButton;

    @FindBy(xpath = "//span[@class='person-link']")
    private WebElement personLink;

    public void findFl(){
        lastName.sendKeys("Абрамов");
        findButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(personLink));
    }
}
