package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage {
    private WebDriver driver;

    public FrontPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".location-selector__button")
    public WebElement locationDrp;

    @FindBy(xpath = "(//a[contains(text(),'Ukraine/English')])[1]")
    public WebElement SelectUaRegion;

    @FindBy(xpath = "//span[contains(text(),'Accept')]")                                            //1 step
    private WebElement cookieDisclaimer;

    public void waitForTextToAppear() {
        String textToAppear = "Engineering the Future";
        WebElement titleText = driver.findElement(By.xpath("//h1[@class='background-video__title title--bold']"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(titleText, textToAppear));
    }

    public String goToHomePage() {
        return "https://www.epam.com/";
    }

    public boolean epamEmployee() {                                                                 //1 step
        String cookieText = "Accept".toUpperCase();
        if (cookieDisclaimer.getText().equals(cookieText)) {
            return false;
        } else {
            return true;
        }
    }
}
