
Feature: end to end test.

Scenario:go through EPAM site to available Software Test Engineering vacancies.

Given User is not an EPAM employee.
When User go to website 'epam.com'.
And User select region 'Ukraine/English' at location dropdown.

And User go to "Vacancies" tab.

And User fill the search field "Keyword or job id" with value "Java".
And User select location "Kyiv" from location dropdown.
And User tick "Software Test Engineering" in "Skills" dropdown.
And User click "Find" button.

Then User sees list of job openings related to above criteria.
When User select first vacancy and click "Apply" button.

Then User sees description of selected vacancy.
And User sees next blocks: "Description", "Requirements", "Nice to have", "Technologies", "We offer".
And User sees item "Flexible work hours." at "We offer" block.

