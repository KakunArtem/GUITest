package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JobListingsPage {
    private WebDriver driver;

    public JobListingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//a[text()='Apply'])[1]")
    public WebElement applyFirstVacancy;

    public void waitForTextToAppear() {
        String textToAppear = "Sort By:";
        WebElement titleText = driver.findElement(By.xpath("//span[contains(text(),'Sort By:')"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(titleText, textToAppear));
    }

    public void checkChosenCriteria() {
//        WebElement selectedJob = driver.findElement(By.xpath("(//li[@data-value='Software Test Engineering'])[2]"));          //оставить пока
//        Assert.assertEquals(true,selectedJob.isDisplayed());

        WebElement selectedLocation = driver.findElement(By.xpath("(//strong[contains(text(),'Kyiv, Ukraine')])[1]"));
        Assert.assertEquals(true, selectedLocation.isDisplayed());
    }
}
