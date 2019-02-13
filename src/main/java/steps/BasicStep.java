package steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FrontPage;
import pages.JobDetailPage;
import pages.JobListingsPage;
import pages.VacanciesPage;
import utilsX.BrowserDriver;

public class BasicStep extends BrowserDriver {

    public BasicStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private FrontPage frontPage = new FrontPage(driver);
    private VacanciesPage vacanciesPage = new VacanciesPage(driver);
    private JobListingsPage jobListingsPage = new JobListingsPage(driver);
    private JobDetailPage jobDetailPage = new JobDetailPage(driver);

    //BrowserDriver
    @Step
    public void loadTestPage(String url) {
        BrowserDriver.loadPage(url);
    }


    //FrontPage
    @Step
    public void pageIsLoaded() {
        frontPage.pageIsLoaded();
    }

    @Step
    public void selectRegionAtFrontPageDrp(String region) {
        frontPage.selectRegion(region);
    }

    //VacanciesPage
    @Step
    public void clickVacanciesBtnAtFrontPage() {
        vacanciesPage.headerVacanciesBtn.click();
    }

    @Step
    public void verifyCurrentURL(String currentTab) {
        vacanciesPage.verifyCurrentURL(currentTab);
    }

    @Step
    public void fillSearchFieldAtVacanciesPage(String field, String keyWord) {
        vacanciesPage.fillSearchField(field, keyWord);
    }

    @Step
    public void selectLocationAtVacanciesPageDrp(String location) {
        vacanciesPage.selectLocation(location);
    }

    @Step
    public void selectSkillAtVacanciesPageDrp(String jobTitle, String drpType){
        vacanciesPage.selectSkill(jobTitle, drpType);
    }

    @Step
    public void clickBtnOnVacanciesPage(String button) {
        vacanciesPage.clickBtn(button);
    }

    //JobListingPage
    @Step
    public void checkChosenCriteriaAtJobLPage(String skillType, String location, String jobId) {
        jobListingsPage.checkChosenCriteria(skillType, location, jobId);
    }

    @Step
    public void clickApplyBtnAtJobLPage(String button, int option) {
        jobListingsPage.clickApplyBtn(button, option);
    }

    //JobDetailPage
    @Step
    public void checkDescriptionAtJobDPage() {
        jobDetailPage.checkDescription();
    }

    @Step
    public void checkBlocksAtJobDPage(String description, String req, String niceToHave, String tech, String weOffer) {
        jobDetailPage.blocksPresentsCheck(description, req, niceToHave, tech, weOffer);
    }

    @Step
    public void checkOfferBlockItems(String item, int itemCount, String blockName) {
        jobDetailPage.offerBlockItems(item, itemCount, blockName);
    }
}
