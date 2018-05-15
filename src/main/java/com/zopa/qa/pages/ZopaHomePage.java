package com.zopa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.zopa.qa.base.TestBase;

public class ZopaHomePage extends TestBase {
	
	@FindBy(linkText = "Get a Zopa loan")
	WebElement zopaLoanLink;
	
	ZopaLoanPage zopaLoanPage;
	
	public ZopaHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
		
	public ZopaLoanPage selectZopaLoan(){			
		zopaLoanLink.click();
	    return new ZopaLoanPage();
	}
}
