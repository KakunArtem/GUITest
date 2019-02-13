package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsX.BrowserDriver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class VacanciesPage {
    private WebDriver driver;

    public VacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span/a[contains(text(),'Vacancies')]")
    public WebElement headerVacanciesBtn;

    public void verifyCurrentURL(String currentTab) {
        String url = "https://careers.epam.ua/vacancies";
        String currentURL = driver.getCurrentUrl();
        if (currentTab.equals("Vacancies")) {
            Assert.assertEquals(currentURL, url);
        } else {
            System.out.println("Wrong tab.");
        }
    }

    public void fillSearchField(String field, String keyWord) {
        WebElement formTitle = driver.findElement(By.xpath("//div/*[text()='Keyword or job ID']"));
        WebElement jobId = driver.findElement(By.xpath("//input[@placeholder='Keyword or job ID']"));

        Assert.assertEquals(formTitle.getText(), field.toUpperCase());
        jobId.sendKeys(keyWord);
    }

    public void selectLocation(String location) {
        WebElement locationDrpBtn = driver.findElement(By.xpath("//span/b[@role='presentation']"));
        locationDrpBtn.click();

        WebElement locationDrp = driver.findElement(By.cssSelector(".select2-results"));
        BrowserDriver.waitX().until(ExpectedConditions.visibilityOf(locationDrp));

        List<WebElement> locations = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement o : locations) {
            if (o.getText().equals(location)) {
                o.click();
                break;
            }
        }
    }

    public void selectSkill(String jobTitle, String drpType) {
        WebElement skillSelectDrp = driver.findElement(By.xpath("//div[contains(text(),'All Skills')]"));
        skillSelectDrp.click();

        WebElement skillsDrp = driver.findElement(By.cssSelector(".multi-select-dropdown"));
        BrowserDriver.waitX().until(ExpectedConditions.visibilityOf(skillsDrp));

        List<WebElement> skills = driver.findElements(By.xpath("//div/div/ul//span[contains(text(),'')]"));
        for (WebElement o : skills) {
            if (o.getText().equals(jobTitle)) {
                o.click();
                break;
            }
        }
    }

    public void clickBtn(String button) {
        List<WebElement> topButtons = driver.findElements(By.xpath("//button"));
        List<WebElement> allButtons = driver.findElements(By.xpath("//span[contains(@class, 'button__content')]"));
        allButtons.addAll(topButtons);

        for (WebElement o : allButtons) {
            if (o.getText().equals(button.toUpperCase())) {
                o.click();
                break;
            }
        }
    }
}
