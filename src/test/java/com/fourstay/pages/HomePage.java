package com.fourstay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fourstay.utilities.Base;

public class HomePage extends Base {

	
	public HomePage(){
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//img[@alt='HStay Logo']")
	public WebElement fourStayLogo;
	
	@FindBy(xpath="//li[@data-target='#modal-login']")
	public WebElement loginLink;
	
	@FindBy(id="email")
	public WebElement userNameBox;
	
	@FindBy(name="Password")
	public WebElement passwordBox;
	
	@FindBy(id="btn-login")
	public WebElement loginButton;
	
	@FindBy(xpath="//button[@class = 'btn btn-custom1 text-uppercase btn-c']")
	public WebElement forgotPasswordButton;
	
	@FindBy(id="forgot-btn")
	public WebElement resetPasswordButton;
	
}
