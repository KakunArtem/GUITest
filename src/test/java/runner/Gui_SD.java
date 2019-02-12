package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.BasicStep;
import utilsX.BrowserDriver;

public class Gui_SD extends BrowserDriver {


    BasicStep basicStep = new BasicStep(driver);

    @Given("^User is not an EPAM employee\\.$")
    public void userIsNotAnEpamEmployee() {
        //skip
    }

    @When("^User go to website \"([^\"]*)\"\\.$")
    public void userGoToWebsiteEpamCom(String arg1) {
        basicStep.loadTestPage(arg1);
    }

    @And("^User select region \"([^\"]*)\" at location dropdown\\.$")
    public void userSelectRegionAtLocationDropdown(String arg1) {
        basicStep.waitForAppearFrontPage();
        basicStep.selectRegionAtFrontPage(arg1);
    }

    @And("^User go to \"([^\"]*)\" tab\\.$")
    public void userGoToTab(String arg1) {
        basicStep.clickVacanciesBtnAtFrontPage();
        basicStep.verifyCurrentURL(arg1);
    }

    @And("^User fill the search field \"([^\"]*)\" with value \"([^\"]*)\"\\.$")
    public void userFillTheSearchFieldWithValue(String arg1, String arg2) {
        basicStep.waitForAppearFrontPage();                                                                                  //////1111111111
        basicStep.fillSearchFieldAtVacanciesPage(arg1, arg2);
    }

    @And("^User select location \"([^\"]*)\" from location dropdown\\.$")
    public void user_select_location_from_location_dropdown(String arg1) throws Throwable {
       basicStep.selectLocationAtVacanciesPageDrp(arg1);
    }

    @And("^User tick \"([^\"]*)\" in \"([^\"]*)\" dropdown\\.$")
    public void user_tick_in_dropdown(String arg1, String arg2) throws Throwable {
        basicStep.selectSkillAtVacanciesPageDrp(arg1, arg2);
    }

    @When("^User click \"([^\"]*)\" button\\.$")
    public void user_click_button(String arg1) {
        basicStep.clickBtnOnVacanciesPage(arg1);
    }

    @Then("^User sees list of job openings related to above criteria: \"([^\"]*)\" in \"([^\"]*)\", \"([^\"]*)\"\\.$")
    public void user_sees_list_of_job_openings_related_to_above_criteria(String arg1, String arg2, String arg3) {
        basicStep.waitForAppearFrontPage();                                                                                         //////11111111111
        basicStep.checkChosenCriteriaAtJobLPage(arg1, arg2, arg3);
    }

    @When("^User select first vacancy and click \"([^\"]*)\" \"([^\"]*)\" button\\.$")
    public void user_select_first_vacancy_and_click_button(String arg1, int arg2) throws Exception {
        basicStep.clickApplyBtnAtJobLPage(arg1, arg2);
    }

    @Then("^User sees description of selected vacancy\\.$")
    public void user_sees_description_of_selected_vacancy() {
        basicStep.waitForAppearFrontPage();                                                                                     ////111111111
        basicStep.checkDescriptionAtJobDPage();
    }

    @Then("^User sees next blocks: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"\\.$")
    public void user_sees_next_blocks(String arg1, String arg2, String arg3, String arg4, String arg5) {
        basicStep.checkBlocksAtJobDPage(arg1, arg2, arg3, arg4, arg5);
    }

    @Then("^User sees item \"([^\"]*)\" \"([^\"]*)\" at \"([^\"]*)\" block\\.$")
    public void user_sees_item_at_block(String arg1, int arg2, String arg3) {
        basicStep.offerBlockItems(arg1, arg2, arg3);
    }
}
