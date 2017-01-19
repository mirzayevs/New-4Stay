Feature: 4Stay login with Invalid credentials


Background: 
Given I am on FourStayhomepage
Then I click LoginLink


@Test1
Scenario: As a Guest, I should be able to see an error message when I try to login with a wrong password
And I enter "alitester@test.com" username and "blahblahblah" password credentials
Then I should see "Incorrect password" messages

@Test3
Scenario: As a Guest, I should be able to Reset/Recover my password in case of login failure
And I enter "alitester@test.com" username and "blahblahblah" password credentials
Then I click on Forgot Password Button
Then Then I should see Reset Password button


 

