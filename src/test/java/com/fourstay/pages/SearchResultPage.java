package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Base;

public class SearchResultPage extends Base{

	public SearchResultPage(){
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath=".//h3[@class='user-name ng-binding']")
	public WebElement userInfo; 
}
