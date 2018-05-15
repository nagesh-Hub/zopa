package com.zopa.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.zopa.qa.base.TestBase;

public class ZopaLoanPage extends TestBase {

	@FindBy(xpath="(//*[@id='amount'])[2]")
	WebElement loanAmountInput;
	
	@FindBy(xpath="//select[@name='term']")
	WebElement loanTermSelect;

	@FindBy(xpath="//*[@id='calculator']/div/div[1]/form/fieldset/div[2]/div/input")
	WebElement quoteInput;
	
	ZopaMembersSignUpPage zopaMembersSignUpPage;
	
	public ZopaLoanPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ZopaMembersSignUpPage getPersonalisedLoanRates(String loanAmount, String loanPeriod){	
		
		if (loanAmountInput.isDisplayed()){
			loanAmountInput.clear();
	    	loanAmountInput.sendKeys(loanAmount);
	    }
	    else{
	           Assert.fail("'I want to get a loan for' field is not displayed.");
	    }	
		
		if (loanTermSelect.isDisplayed()){
			Select loanTerms = new Select(loanTermSelect);
			loanTerms.selectByVisibleText(loanPeriod);		
	    }
	    else{
	           Assert.fail("'over a period of' field is not displayed.");
	    }		
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        if (quoteInput.isDisplayed() && quoteInput.isEnabled()){
        	quoteInput.click();
        }
        else{
            Assert.fail("'Get my personalised rates' button is either not enabled or not displayed");
        }	
		return new ZopaMembersSignUpPage();			
	}	
}
