import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.KgrMainPage;
import pages.MainAuthorizationPage;
import pages.PageToSelectSystem;
import pages.Pperson;
import settings.ConfProperties;
import settings.SetUp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PpersonCheckTest extends SetUp {

    private MainAuthorizationPage mainAuthorizationPage = new MainAuthorizationPage(driver, wait);
    private PageToSelectSystem pageToSelectSystem = new PageToSelectSystem(driver, wait);
    private KgrMainPage kgrMainPage = new KgrMainPage(driver, wait);
    private Pperson pperson = new Pperson(driver, wait);

    @Test
    @DisplayName("Проверка PPERSON")
    public void test(){
        openPage();
        authorization();
        goToKGR();
        goToPperson();
        findFl();
    }

    private void openPage(){
        driver.get(ConfProperties.getProperty("pageUrl"));
    }

    @Step("0. Авторизация под ролью оператор ППК КГР")
    private void authorization(){
        mainAuthorizationPage.sendUserIdAndPassword();
    }

    @Step("1. Переход в ППК КГР КО")
    private void goToKGR(){
        pageToSelectSystem.goToKGR();
    }

    @Step("2. Переход в справочник физических лиц")
    private void goToPperson(){
        kgrMainPage.goToPperson();
    }

    @Step("3. Проверка поиска по фамилии")
    private void findFl(){
        pperson.findFl();
    }
}
