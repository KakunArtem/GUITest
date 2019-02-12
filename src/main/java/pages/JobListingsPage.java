package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobListingsPage {
    private WebDriver driver;

    public JobListingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkChosenCriteria(String skillType, String location, String jobId) {
        WebElement selectedItems = driver.findElement(By.xpath("//ul[@class='selected-items']/li[contains(text(), '')]"));
        Assert.assertEquals(selectedItems.getText(), skillType.toUpperCase());

        WebElement selectedLocation = driver.findElement(By.xpath("(//header/strong)[1]"));
        Assert.assertEquals(selectedLocation.getText(), location.toUpperCase());

        WebElement selectedJobId = driver.findElement(By.xpath("//*[contains(text(),'We found 9 job openings related to \"Java\"')]"));
        Assert.assertTrue(selectedJobId.getText().contains(jobId.toUpperCase()));
    }

    public void clickApplyBtn(String button, int option) {
        List<WebElement> applyButtons = driver.findElements(By.xpath("//a[@class='search-result__item-apply' and contains(text(),'Apply')]"));
        for (WebElement o : applyButtons) {
            if (option > 0 && option <= applyButtons.size() && o.getText().equals(button.toUpperCase())) {
                applyButtons.get(option - 1).click();
                break;
            } else {
                throw new NotFoundException("option " + option + " not found");
            }
        }
    }
}

