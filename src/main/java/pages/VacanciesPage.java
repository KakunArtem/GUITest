package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VacanciesPage {
    private WebDriver driver;

    public VacanciesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span/a[contains(text(),'Vacancies')]")
    public WebElement vacanciesButton;

    @FindBy(css = "button[type = submit]")
    public WebElement findVcButton;

    public void waitForTextToAppear() {
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

    public void selectSkill(String jobType, String drpType) {
        WebElement skillSelectDrp = driver.findElement(By.xpath("//div[contains(text(),'All Skills')]"));
        skillSelectDrp.click();

        WebElement qaAutomation = driver.findElement(By.xpath("//span[contains(text(),'Software Test Engineering')]"));
        switch (jobType) {
            case "Software Test Engineering":
                qaAutomation.click();
                break;
            default:
                throw new IllegalArgumentException("Wrong job type.");
        }
    }

    public void selectLocation(String location) throws Exception {
        WebElement locationDrp = driver.findElement(By.xpath("//span/b[@role='presentation']"));
        locationDrp.click();
        Thread.sleep(5000);

        WebElement locationKyiv = driver.findElement(By.xpath("//li[contains(text(),\"Kyiv\")]"));
        switch (location) {
            case "Kyiv":
                locationKyiv.click();
                break;
            default:
                throw new IllegalArgumentException("Wrong location.");
        }
    }
}
