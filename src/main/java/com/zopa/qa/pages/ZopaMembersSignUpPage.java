package com.zopa.qa.pages;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.zopa.qa.base.TestBase;

public class ZopaMembersSignUpPage extends TestBase {
	
	@FindBy(xpath ="//*[@id='member_email']")
	WebElement emailAddressInput;
	
	@FindBy(xpath ="//*[@type='radio' and @name='applications_loan_apply[title]']")
	List<WebElement> titleOptions;

	@FindBy(xpath ="//*[@id='applications_loan_apply_first_name']")
	WebElement fNameInput;
	
	@FindBy(xpath ="//*[@id='applications_loan_apply_last_name']")
	WebElement lNameInput;

	@FindBy(xpath ="//*[@id='applications_loan_apply_home_phone']")
	WebElement phoneNumberInput;

	@FindBy(xpath ="//*[@id='date_of_birth_day']")
	WebElement dayInput;
	
	@FindBy(xpath ="//*[@id='date_of_birth_month']")
	WebElement monthInput;
	
	@FindBy(xpath ="//*[@id='date_of_birth_year']")
	WebElement yearInput;
	
	@FindBy(xpath ="//*[@type='radio' and @name='applications_loan_apply[loan_purpose]']")
	List<WebElement> loanReasonOptions;

	@FindBy(xpath ="//*[@id='content']/div/div[1]/div/form/fieldset[1]/div[5]/p[2]/a")
	WebElement showMoreReasonsLink;
	
	@FindBy(xpath ="//*[@id='address_postcode']")
	WebElement addressPostcodeInput;
	
	@FindBy(xpath ="//*[@id='address-lookup']/p[2]/input")
	WebElement addressLookupButton;
	
	@FindBy(xpath ="//*[@id='content']/div/div[1]/div/form/fieldset[2]/div/div/p[3]/input[1]")
	WebElement useAddressButton;
	
	@FindBy(xpath ="//*[@type='radio' and @name='applications_loan_apply[employment_status]']")
	List<WebElement> employmentStausOptions;

	@FindBy(xpath ="//*[@id='applications_loan_apply_salary']")
	WebElement annualSalaryInput;
	
	@FindBy(xpath ="//*[@type='radio' and @name='applications_loan_apply[residential_status]']")
	List<WebElement> dataResidentialStatusOptions;
	
	@FindBy(xpath ="//*[@id='applications_loan_apply_rent']")
	WebElement applicationsLoanApplyRentInput;
	
	@FindBy(xpath ="//*[@id='member_password']")
	WebElement passwordInput;
	
	
	public ZopaMembersSignUpPage() {
		PageFactory.initElements(driver, this);
	}
		
	public void signUpNewMember(){	
		Random generator = new Random();
		int randomNum1;
		int randomNum2;
		randomNum1 = generator.nextInt(300) + 100;
		randomNum2 = generator.nextInt(719171) + 100000;

		// Email address 
		if (emailAddressInput.isDisplayed() && emailAddressInput.isEnabled()){
			emailAddressInput.sendKeys("signuptest" + randomNum1 + "@test.com");
	        stepInfo("Email address:signuptest" + randomNum1 + "@test.com");
	    }
	    else{
            Assert.fail("'Email address' field is either not enabled or not displayed");
	    }	
		
	    // Title		
		Random random = new Random();
	    int index = random.nextInt(titleOptions.size());
	    String label= titleOptions.get(index).getAttribute("id");
        stepInfo("Title:" + label);
	    WebElement titleOptionLabel = driver.findElement(By.xpath("//label[@for='"+label+"']"));		    
		if (titleOptionLabel.isDisplayed()){
		    titleOptionLabel.click(); 
	    }
	    else{
            Assert.fail("'Title Label' field is either not enabled or not displayed");
	    }	
		
	    // FirstName
		if (fNameInput.isDisplayed() && fNameInput.isEnabled()){
		    fNameInput.sendKeys("fName" + randomNum1);
	        stepInfo("First Name:fName" + randomNum1);
	    }
	    else{
            Assert.fail("'First Name' field is either not enabled or not displayed");
	    }	
		    
	    // LastName
		if (lNameInput.isDisplayed() && lNameInput.isEnabled()){
			lNameInput.sendKeys("lName" + randomNum1);
	        stepInfo("Last Name:lName" + randomNum1);			
	    }
	    else{
            Assert.fail("'Last Name' field is either not enabled or not displayed");
	    }	
	    
	    // Phone Number
		if (phoneNumberInput.isDisplayed() && phoneNumberInput.isEnabled()){
			phoneNumberInput.sendKeys("07532-" + randomNum2);
	        stepInfo("Phone Number:07532-" + randomNum2);						
	    }
	    else{
            Assert.fail("'Phone Number' field is either not enabled or not displayed");
	    }	
		
	    // Date of Birth - Day
		if (dayInput.isDisplayed() && dayInput.isEnabled()){
			dayInput.sendKeys(String.valueOf(1 + (int)(Math.random() * 31)));
	        stepInfo("Date of Birth - Day:"+ String.valueOf(1 + (int)(Math.random() * 31)));						
	    }
	    else{
            Assert.fail("'Date of Birth - Day' field is either not enabled or not displayed");
	    }		
		
	    // Date of Birth - Month
		if (monthInput.isDisplayed() && monthInput.isEnabled()){
			monthInput.sendKeys(String.valueOf(1 + (int)(Math.random() * 12)));
	        stepInfo("Date of Birth - Month:"+ String.valueOf(1 + (int)(Math.random() * 12)));									
	    }
	    else{
            Assert.fail("'Date of Birth - Month' field is either not enabled or not displayed");
	    }		
				
	    // Date of Birth - Year
		if (yearInput.isDisplayed() && yearInput.isEnabled()){
			 int yearBegin=1970;
		     int yearEnd=1997-yearBegin;
		     yearInput.sendKeys(String.valueOf(yearBegin+ (int)(Math.random() * yearEnd)));
		     stepInfo("Date of Birth - Year:"+ String.valueOf(yearBegin+ (int)(Math.random() * yearEnd)));											     
	    }
	    else{
            Assert.fail("'Date of Birth - Year' field is either not enabled or not displayed");
	    }				
		
	    // Show More Reasons
		if (showMoreReasonsLink.isDisplayed() && showMoreReasonsLink.isEnabled()){
			showMoreReasonsLink.click();
	    }
	    else{
            Assert.fail("'Show More Reasons' field is either not enabled or not displayed");
	    }	
		
	    // Loan Reason		
	    int loanReasonOptionsIndex = generator.nextInt(loanReasonOptions.size());
	    String loanReasonOption= loanReasonOptions.get(loanReasonOptionsIndex).getAttribute("id");
	    stepInfo("Loan Reason - Option:" + loanReasonOption);											     
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement loanReasonOptionLabel = wait.until(
	           ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='"+loanReasonOption+"']")));
		if (loanReasonOptionLabel.isDisplayed()){
			loanReasonOptionLabel.click(); 
	    }
	    else{
            Assert.fail("'Loan Reason Option' field is either not enabled or not displayed");
	    }	
		
	    // Address Postcode
		if (addressPostcodeInput.isDisplayed() && addressPostcodeInput.isEnabled()){
			addressPostcodeInput.sendKeys("EC2V 5AE");
		    stepInfo("Postcode:EC2V 5AE");											     			
	    }
	    else{
            Assert.fail("'Address Postcode' field is either not enabled or not displayed");
	    }	
		
	    // Address Lookup
		if (addressLookupButton.isDisplayed() && addressLookupButton.isEnabled()){
			addressLookupButton.click();
	    }
	    else{
            Assert.fail("'Address Lookup' field is either not enabled or not displayed");
	    }	
		
		// Address History - Move In Month
	    WebElement moveInMonthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='address_from_2i']")));
	    if (moveInMonthInput.isDisplayed()){
			Select drpMonth = new Select(moveInMonthInput);
			drpMonth.selectByIndex(new Random().nextInt(drpMonth.getOptions().size()));
		    stepInfo("Address History - Move In Month:" + drpMonth.getFirstSelectedOption().getText());											     			
		}
		else{
	         Assert.fail("'Address History - Move In Month' field is either not enabled or not displayed");
		 }	
		
		// Address History - Move In Year
	    WebElement moveInYearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='address_from_1i']")));
	    if (moveInYearInput.isDisplayed()){
			int yearBegin=1904;
		    int yearEnd=(Calendar.getInstance().get(Calendar.YEAR)-4)-yearBegin;
			Select drpYear = new Select(moveInYearInput);
			drpYear.selectByValue(String.valueOf(yearBegin+ (int)(Math.random() * yearEnd)));	
		    stepInfo("Address History - Move In Year:" + drpYear.getFirstSelectedOption().getText());											     						
	    }
		else{
	         Assert.fail("'Address History - Move In Year' field is either not enabled or not displayed");
		 }	
	    
	    // Use Address
		if (useAddressButton.isDisplayed() && useAddressButton.isEnabled()){
			useAddressButton.click();
	    }
	    else{
            Assert.fail("'Use Address' field is either not enabled or not displayed");
	    }	
			    
	    // Employment Staus Option		
	    int employmentStausOptionsIndex = generator.nextInt(employmentStausOptions.size());
	    String employmentStausOption= employmentStausOptions.get(employmentStausOptionsIndex).getAttribute("id");
	    stepInfo("Employment Staus Option:" + employmentStausOption);											     						
	    WebElement employmentStausOptionLabel = wait.until(
	           ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='"+employmentStausOption+"']")));
		if (employmentStausOptionLabel.isDisplayed()){
			employmentStausOptionLabel.click(); 
	    }
	    else{
            Assert.fail("'Employment Status Option' field is either not enabled or not displayed");
	    }	
	    
	    // Annual Salary
		if (annualSalaryInput.isDisplayed() && annualSalaryInput.isEnabled()){	
			String salary = String.valueOf(10000 + (int)(Math.random() * 500)); 
			annualSalaryInput.sendKeys(salary);
		    stepInfo("Annual Salary:" + salary);											     						
	    }
	    else{
            Assert.fail("'Annual Salary' field is either not enabled or not displayed");
	    }	
		
		// Data Residential Status
	    int dataResidentialStatusOptionsIndex = generator.nextInt(dataResidentialStatusOptions.size());
	    String dataResidentialStatusOption= dataResidentialStatusOptions.get(dataResidentialStatusOptionsIndex).getAttribute("id");
	    stepInfo("Data Residential Status Option:" + dataResidentialStatusOption);											     						
	    WebElement dataResidentialStatusOptionLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='"+dataResidentialStatusOption+"']")));
		if (dataResidentialStatusOptionLabel.isDisplayed()){
			dataResidentialStatusOptionLabel.click(); 
	    }
	    else{
            Assert.fail("'Data Residential Status Option' field is either not enabled or not displayed");
	    }			
		
	    // Your monthly contribution to rent/mortgage
		if (applicationsLoanApplyRentInput.isDisplayed() && applicationsLoanApplyRentInput.isEnabled()){	
			String salary = String.valueOf(generator.nextInt(1000) + 1000);
			applicationsLoanApplyRentInput.sendKeys(salary);
		    stepInfo("Annual Salary:" + salary);											     						
	    }

	    // Password
	    if (passwordInput.isDisplayed() && passwordInput.isEnabled()){
				passwordInput.sendKeys("Aa" + randomNum2);
			    stepInfo("Password:Aa" + randomNum2);											     						

		}
		else{
			Assert.fail("'Password' field is either not enabled or not displayed");
		}	 
	}
}
