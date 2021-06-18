package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageToSelectSystem {

    WebDriver driver;
    WebDriverWait wait;
    public PageToSelectSystem(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(xpath = "//a[text() = 'ППК КГР КО']")
    private WebElement KGR;

    public void goToKGR(){
        KGR.click();
    }
}
