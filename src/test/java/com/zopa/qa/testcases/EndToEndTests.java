package com.zopa.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zopa.qa.base.TestBase;
import com.zopa.qa.pages.ZopaHomePage;
import com.zopa.qa.pages.ZopaLoanPage;
import com.zopa.qa.pages.ZopaMembersSignUpPage;
import com.zopa.qa.util.TestUtil;

public class EndToEndTests extends TestBase {
	ZopaHomePage zopaHomePage;
	ZopaLoanPage zopaLoanPage;
	ZopaMembersSignUpPage zopaMembersSignUpPage;

	TestUtil testUtil;

	public EndToEndTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		zopaHomePage = new ZopaHomePage();
	}
	
	@Test(priority=1)
	public void loanQuoteTest(){
		zopaLoanPage = zopaHomePage.selectZopaLoan();			
		zopaMembersSignUpPage = zopaLoanPage.getPersonalisedLoanRates("2000", "2 years");
		zopaMembersSignUpPage.signUpNewMember();		
	}
	
	@AfterMethod
	public void tearDown(){
    	driver.quit();
	}
}
