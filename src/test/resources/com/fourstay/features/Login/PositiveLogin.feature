Feature: 4Stay login with valid credentials
  As a Guest, I should be able to log into the system with correct credentials
  As a Host, I should be able to log into the system with correct credentials
 
 
Background: 
Given I am on FourStayhomepage
Then I click LoginLink
 
 @Test2
 Scenario: Guest logs in with correct credentials
  And I enter "alitester@test.com" username and "password" password credentials
  Then I should see "Ali Tester" messages
  

  
