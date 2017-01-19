package com.fourstay.step_definitions;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;
import com.fourstay.utilities.Base;
import com.fourstay.utilities.TestInputs;
import com.fourstay.utilities.Verification;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps extends Base{

	HomePage homePage = new HomePage();
	SearchResultPage searchResultPage = new SearchResultPage();
	
	@Given("^I am on FourStayhomepage$")
	public void i_am_on_FourStayhomepage() throws Throwable {
		driver.get(TestInputs.BASE_URL);
		assertTrue(homePage.fourStayLogo.isDisplayed());
	}

	@Then("^I click LoginLink$")
	public void i_click_LoginLink() throws Throwable {
		homePage.loginLink.click();
	}

	@Then("^I enter \"([^\"]*)\" username and \"([^\"]*)\" password credentials$")
	public void i_enter_username_and_password_credentials(String userName, String password) throws Throwable {
			homePage.userNameBox.sendKeys(userName);
			homePage.passwordBox.sendKeys(password);
			homePage.loginButton.click();
	}

	@Then("^I should see \"([^\"]*)\" messages$")
		public void i_should_see_messages(String text) {
		Verification.verifyPartialText(text);
		
//		Verification.waitFor(By.xpath(".//h3[@class='user-name ng-binding']"));	
//		assertEquals(userInformation, searchResultPage.userInfo.getText());
	}


@Then("^I click on Forgot Password Button$")
public void i_click_on_Forgot_Password_Button() throws Throwable {
	homePage.forgotPasswordButton.click();
}

@Then("^Then I should see Reset Password button$")
public void then_I_should_see_Reset_Password_button() throws Throwable {
	assertTrue(homePage.resetPasswordButton.isDisplayed());
  
}


}
