
Feature: GUI test.

Scenario:go through EPAM site to available Software Test Engineering vacancies.

Given User is not an EPAM employee.
When User go to website "https://www.epam.com/".
And User select region "Ukraine/English" at location dropdown.

And User go to "Vacancies" tab.

And User fill the search field "Keyword or job id" with value "Java".
And User select location "Kyiv" from location dropdown.
And User tick "Software Test Engineering" in "Skills" dropdown.
And User click "Find" button.

Then User sees list of job openings related to above criteria: "Software Test Engineering" in "Kyiv, Ukraine", "Java".
When User select first vacancy and click "Apply" "1" button.

Then User sees description of selected vacancy.
And User sees next blocks: "Description", "Requirements", "Nice to have", "Technologies", "We offer".
And User sees item "Flexible work hours" "1" at "We offer" block.

