package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.BasicStep;
import utilsX.BrowserDriver;

public class Gui_StepDefs extends BrowserDriver {

    private BasicStep basicStep = new BasicStep(driver);

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
        basicStep.pageIsLoaded();
        basicStep.selectRegionAtFrontPageDrp(arg1);
    }

    @And("^User go to \"([^\"]*)\" tab\\.$")
    public void userGoToTab(String arg1) {
        basicStep.clickVacanciesBtnAtFrontPage();
        basicStep.verifyCurrentURL(arg1);
    }

    @And("^User fill the search field \"([^\"]*)\" with value \"([^\"]*)\"\\.$")
    public void userFillTheSearchFieldWithValue(String arg1, String arg2) {
        basicStep.pageIsLoaded();
        basicStep.fillSearchFieldAtVacanciesPage(arg1, arg2);
    }

    @And("^User select location \"([^\"]*)\" from location dropdown\\.$")
    public void userSelectLocationFromLocationDropdown(String arg1) throws Throwable {
       basicStep.selectLocationAtVacanciesPageDrp(arg1);
    }

    @And("^User tick \"([^\"]*)\" in \"([^\"]*)\" dropdown\\.$")
    public void userTickInDropdown(String arg1, String arg2) throws Throwable {
        basicStep.selectSkillAtVacanciesPageDrp(arg1, arg2);
    }

    @When("^User click \"([^\"]*)\" button\\.$")
    public void userClickButton(String arg1) {
        basicStep.clickBtnOnVacanciesPage(arg1);
    }

    @Then("^User sees list of job openings related to above criteria: \"([^\"]*)\" in \"([^\"]*)\", \"([^\"]*)\"\\.$")
    public void userSeesListOfJobOpeningsRelatedToAboveCriteria(String arg1, String arg2, String arg3) {
        basicStep.pageIsLoaded();
        basicStep.checkChosenCriteriaAtJobLPage(arg1, arg2, arg3);
    }

    @When("^User select first vacancy and click \"([^\"]*)\" \"([^\"]*)\" button\\.$")
    public void userSelectFirstVacancyAndClickButton(String arg1, int arg2){
        basicStep.clickApplyBtnAtJobLPage(arg1, arg2);
    }

    @Then("^User sees description of selected vacancy\\.$")
    public void userSeesDescriptionOfSelectedVacancy() {
        basicStep.pageIsLoaded();
        basicStep.checkDescriptionAtJobDPage();
    }

    @Then("^User sees next blocks: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"\\.$")
    public void userSeesNextBlocks(String arg1, String arg2, String arg3, String arg4, String arg5) {
        basicStep.checkBlocksAtJobDPage(arg1, arg2, arg3, arg4, arg5);
    }

    @Then("^User sees item \"([^\"]*)\" \"([^\"]*)\" at \"([^\"]*)\" block\\.$")
    public void userSeesItemAtBlock(String arg1, int arg2, String arg3) {
        basicStep.checkOfferBlockItems(arg1, arg2, arg3);
    }
}
