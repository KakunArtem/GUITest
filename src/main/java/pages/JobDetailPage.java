package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class JobDetailPage {
    private WebDriver driver;

    public JobDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForTextToAppear() {
        String textToAppear = "Apply For";
        WebElement titleText = driver.findElement(By.xpath("//div//h3[text()='Apply For']"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(titleText, textToAppear.toUpperCase()));
    }

    public void checkDescription() {
        WebElement descriptionText = driver.findElement(By.cssSelector(".recruiting-page__top-description"));
        Assert.assertEquals(true, descriptionText.isDisplayed());
    }

    public void blocksPresentsCheck(String description, String req, String niceToHave, String tech, String weOffer) {
        int count = 0;

        List<String> blocksList = new ArrayList<>();
        blocksList.add(description);
        blocksList.add(req);
        blocksList.add(niceToHave);
        blocksList.add(tech);
        blocksList.add(weOffer);

        List<WebElement> blocksWebElems = driver.findElements(By.xpath("//h4[contains(text(),'')]"));
        for (WebElement o : blocksWebElems) {
            for (String x : blocksList) {
                if (o.getText().equals(x.toUpperCase())) {
                    Assert.assertEquals(true, o.isDisplayed());
                    count++;
                }
            }
        }
        if (count < blocksList.size()) {
            throw new NotFoundException("Missing some blocks");
        }
    }

    public void offerBlockItem(String item, int itemCount, String blockName) {
        int count = 0;

        WebElement weOfferBlock = driver.findElement(By.xpath("//h4[contains(text(),'We offer')]/following-sibling::ul"));
        Assert.assertEquals(true, weOfferBlock.isDisplayed());

        List<WebElement> blockItems = driver.findElements(By.xpath("//h4[contains(text(),'We offer')]/following-sibling::ul/*"));
        for (WebElement o : blockItems) {
            if (o.getText().equals(item)) {
                Assert.assertEquals(true, o.isDisplayed());
                count++;
            }
        }
        if (count < itemCount) {
            throw new NotFoundException("Missing some items");
        }
    }
}

