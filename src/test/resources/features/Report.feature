#Author: umar.mansoor1957@gmail.com
Feature: Reports

 Background:
   Given I logged into OrangeHRM
   When I click on PIM also I click on Reports

 Scenario Outline: Add report
   And I click add
   And I enter Report Name "<reportName>"
   And Select Selection Criteria to Sub Unit and Add Sub Unit
   And Select on SubUnit that matches one of the default employees "<subUnit>"
   And Select Selection Criteria to Job Title and Add Job Title
   And Select the Job Title that matches the default employee "<jobTitle>"
   And Select Selection Criteria to Employee Name and Add Employee Name
   And Enter Employee Name that matches the default employee "<employeeName>"
   Then Verify Display Field Groups Personal is selected
   And Select Display Fields to Employee Id and Add Employee Id
   And Check the box for Display Fields
   Then Click Save
   Then Validate Report Name appears

   Examples:
     | subUnit | jobTitle   | employeeName   |
     | IT      | IT Manager | Thomas Fleming |

 Scenario Outline: Validate report name appears
   And I click Edit on existing Report from the previous entry
   And Select Selection Criteria to Age Group and add Age Group
   And then specify the Age Group "<ageGroup>"
   And Select Selection Criteria to Location and add Location
   And Select the Job Title that matches a Different default employee "<jobTitle>"
   And Select Selection Criteria to Employee Name and Add Employee Name
   And Enter Employee Name that matches the Different default employee "<employeeName>"
   Then Verify Display Field Groups Personal is selected
   And Select Display Fields to Employee Id and Add Employee Id
   And Check the box for Display Fields
   Then Click Save
   Then Validate Report Name appears

   Examples:
     | subUnit | jobTitle      | employeeName |
     | Sales   | Sales Manager | Robert Craig |

 Scenario: Validate report name doesn't exist
   And Select the Check Box for the edited Report Name from
   Then Click Delete
   And click Ok
   Then Verify Report Name does not Exist