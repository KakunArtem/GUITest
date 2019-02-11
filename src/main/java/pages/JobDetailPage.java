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
        WebElement descriptionBlock = driver.findElement(By.xpath ("//div/h4[contains(text(),'DESCRIPTION')]"));
        Assert.assertEquals(descriptionBlock.getText(), description.toUpperCase());
        Assert.assertEquals(true, descriptionBlock.isDisplayed());

        List<WebElement> blocks = driver.findElements(By.xpath("//ul[@class='bullet-list']/preceding-sibling::h4"));
        Assert.assertEquals(blocks.get(0).getText(), req.toUpperCase());
        Assert.assertEquals(true, blocks.get(0).isDisplayed());

        Assert.assertEquals(blocks.get(1).getText(), niceToHave.toUpperCase());
        Assert.assertEquals(true, blocks.get(1).isDisplayed());

        Assert.assertEquals(blocks.get(2).getText(), tech.toUpperCase());
        Assert.assertEquals(true, blocks.get(2).isDisplayed());

        Assert.assertEquals(blocks.get(3).getText(), weOffer.toUpperCase());
        Assert.assertEquals(true, blocks.get(3).isDisplayed());
    }

    public void offerBlockItem() {
        WebElement item = driver.findElement(By.xpath("//h4[contains(text(),'We offer')]/..//li[contains(text(),'Flexible work hours')]"));
        Assert.assertEquals(true, item.isDisplayed());
    }
}

