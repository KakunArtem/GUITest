package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.FrontPage;
import pages.JobDetailPage;
import pages.JobListingsPage;
import pages.VacanciesPage;
import utils.BrowserDriver;

public class EndToEndStep extends BrowserDriver {
    private FrontPage frontPage = new FrontPage(driver);
    private VacanciesPage vacanciesPage = new VacanciesPage(driver);
    private JobListingsPage jobListingsPage = new JobListingsPage(driver);
    private JobDetailPage jobDetailPage = new JobDetailPage(driver);

    @Given("^User is not an EPAM employee\\.$")
    public void user_is_not_an_EPAM_employee() {
//        Assert.assertEquals(false, frontPage.epamEmployee());
    }

    @When("^User go to website 'epam\\.com'\\.$")
    public void user_go_to_website_epam_com() {
        BrowserDriver.loadPage(frontPage.goToHomePage());
    }

    @And("^User select region 'Ukraine/English' at location dropdown\\.$")
    public void user_select_region_Ukraine_English_at_location_dropdown() {
        frontPage.waitForTextToAppear();
        frontPage.locationDrp.click();
        frontPage.SelectUaRegion.click();
    }

    @And("^User go to \"([^\"]*)\" tab\\.$")
    public void user_go_to_tab(String arg1) {
        vacanciesPage.vacanciesButton.click();
        vacanciesPage.verifyCurrentURL(arg1);
    }

    @And("^User fill the search field \"([^\"]*)\" with value \"([^\"]*)\"\\.$")
    public void user_fill_the_search_field_with_value(String arg1, String arg2) {
        vacanciesPage.waitForTextToAppear();
        vacanciesPage.fillSearchField(arg1, arg2);
    }

    @And("^User select location \"([^\"]*)\" from location dropdown\\.$")
    public void user_select_location_from_location_dropdown(String arg1) throws Throwable {
        vacanciesPage.selectLocation(arg1);
    }

    @And("^User tick \"([^\"]*)\" in \"([^\"]*)\" dropdown\\.$")
    public void user_tick_in_dropdown(String arg1, String arg2) {
        vacanciesPage.selectSkill(arg1, arg2);
    }

    @When("^User click \"([^\"]*)\" button\\.$")
    public void user_click_button(String arg1) {
        vacanciesPage.findVcButton.click();
    }

    @Then("^User sees list of job openings related to above criteria\\.$")
    public void user_sees_list_of_job_openings_related_to_above_criteria() {
        jobListingsPage.waitForTextToAppear();
        jobListingsPage.checkChosenCriteria();
    }

    @When("^User select first vacancy and click \"([^\"]*)\" button\\.$")
    public void user_select_first_vacancy_and_click_button(String arg1) {
        jobListingsPage.applyFirstVacancy.click();
    }

    @Then("^User sees description of selected vacancy\\.$")
    public void user_sees_description_of_selected_vacancy() {
        jobDetailPage.waitForTextToAppear();
        jobDetailPage.checkDescription();
    }

    @Then("^User sees next blocks: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"\\.$")
    public void user_sees_next_blocks(String arg1, String arg2, String arg3, String arg4, String arg5) {
        jobDetailPage.blocksPresentsCheck(arg1, arg2, arg3, arg4, arg5);
    }

    @Then("^User sees item \"([^\"]*)\" at \"([^\"]*)\" block\\.$")
    public void user_sees_item_at_block(String arg1, String arg2) {
        jobDetailPage.offerBlockItem();
    }
}
