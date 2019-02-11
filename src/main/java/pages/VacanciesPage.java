package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VacanciesPage {
    private WebDriver driver;

    public VacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span/a[contains(text(),'Vacancies')]")
    public WebElement headerVacanciesBtn;

    public void waitForAppear() {
        String textToAppear = "Work with Us";
        WebElement titleText = driver.findElement(By.xpath("//h1[contains(text(),'Work with Us')]"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(titleText, textToAppear));
    }

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

    public void selectLocation(String location) throws Exception {
        WebElement locationDrpBtn = driver.findElement(By.xpath("//span/b[@role='presentation']"));
        locationDrpBtn.click();
        Thread.sleep(5000);

        WebElement locationDrp = driver.findElement(By.cssSelector(".select2-results"));
        Assert.assertEquals(true, locationDrp.isDisplayed());

        List<WebElement> locations = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        for (WebElement o : locations) {
            if (o.getText().equals(location)) {
                o.click();
                break;
            }
        }
    }

    public void selectSkill(String jobTitle, String drpType) throws Exception {
        WebElement skillSelectDrp = driver.findElement(By.xpath("//div[contains(text(),'All Skills')]"));
        skillSelectDrp.click();
        Thread.sleep(5000);

        WebElement skillsDrp = driver.findElement(By.cssSelector(".multi-select-dropdown"));
        Assert.assertEquals(true, skillsDrp.isDisplayed());

        List<WebElement> skills = driver.findElements(By.xpath("//div/div/ul//span[contains(text(),'')]"));
        for (WebElement o : skills) {
            if (o.getText().equals(jobTitle)) {
                o.click();
                break;
            }
        }
    }

    public void clickBtn(String button) {
        List<WebElement> buttonsTop = driver.findElements(By.xpath("//button"));
        List<WebElement> allButtons = driver.findElements(By.xpath("//span[contains(@class, 'button__content')]"));
        allButtons.addAll(buttonsTop);

        for (WebElement o : allButtons) {
            if (o.getText().equals(button.toUpperCase())) {
                o.click();
                break;
            }
        }
    }
}
