package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.cssSelector("[data-submenu='11']");
    private By sort = By.cssSelector("[name='categoryFilter_name']");
    private By category = By.cssSelector("#page-header-desc-category-new_category");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        driver.navigate().to(Properties.getBaseAdminUrl());
        WebElement loginInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("passwd"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        passwordInput.submit();
    }

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) throws InterruptedException {

        WebElement catalog = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        WebElement categories = driver.findElement(By.cssSelector("[data-submenu='11']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLink));

        Actions actions = new Actions(driver);
        actions.moveToElement(catalog).perform();
        actions.moveToElement(categories).perform();
        categories.click();
//        actions.moveToElement(catalog).moveToElement(categories).click().build().perform();

//        catalog.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesLink));
//
//        categories.click();

        WebElement addCategory = driver.findElement(By.cssSelector("#page-header-desc-category-new_category"));
        addCategory.click();
        WebElement nameInput = driver.findElement(By.cssSelector("#name_1"));
        nameInput.sendKeys(categoryName);
        WebElement chpuInput = driver.findElement(By.cssSelector("#link_rewrite_1"));
        chpuInput.sendKeys("Termos-test");
        WebElement saveInput = driver.findElement(By.cssSelector("#category_form_submit_btn"));
        saveInput.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(sort));
        WebElement nameSort = driver.findElement(By.cssSelector("[name='categoryFilter_name']"));
        nameSort.sendKeys(categoryName);
        WebElement searchInput = driver.findElement(By.cssSelector("#submitFilterButtoncategory"));
        searchInput.click();

    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // TODO implement generic method to wait until page content is loaded

        // wait.until(...);
        // ...
    }

}
