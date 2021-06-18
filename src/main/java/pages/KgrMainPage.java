package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class KgrMainPage {
    WebDriver driver;
    WebDriverWait wait;
    public KgrMainPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    @FindBy(xpath = "//a[text() = 'Справочник физ. лиц']")
    private WebElement ppersonLink;

    @FindBy(xpath = "//h1[text()='Физические лица']")
    private WebElement ppersonHeading;

    public void goToPperson(){
        ppersonLink.click();

        //После открытия новой вкладки необходимо сделать ее активной
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //Убеждаемся, что pperson запущен и заголовок отобразился
        wait.until(ExpectedConditions.visibilityOf(ppersonHeading));
    }
}
