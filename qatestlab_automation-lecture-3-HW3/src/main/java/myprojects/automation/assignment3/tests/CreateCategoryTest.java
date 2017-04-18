package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {

    private static String BASE_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static String login = "webinar.test@gmail.com";
    private static String passwd = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getConfiguredDriver();

        driver.get(BASE_URL);
        GeneralActions actions = new GeneralActions(driver);
        actions.login(login,passwd);
        actions.createCategory("Termos");
    }
}
