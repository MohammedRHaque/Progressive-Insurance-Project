
package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class StartPage {
	public StartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_FirstName")
	WebElement firstNameElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MiddleInitial")
	WebElement middleNameElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_LastName")
	WebElement lastNameElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_Suffix")
	WebElement suffixElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_DateOfBirth")
	WebElement doBElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_MailingAddress")
	WebElement mailingaddressElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_ApartmentUnit")
	WebElement aptElement;

	@FindBy(id = "NameAndAddressEdit_embedded_questions_list_City")
	WebElement cityElement;

	@FindBy(tagName = "checkbox-input")
	WebElement checkBoxElement;

	@FindBy(xpath = "//button[text()='Okay, start my quote.']")
	WebElement getqoutebtnElement;

	By requiredErrorMsgAddressBy = By.xpath("(//div[contains(.,'Required to continue')])[4]");
	By requiredErrorMsgCityBy = By.xpath("(//div[contains(.,'Reqpuired to continue')])[5]");

	private void fName(CommonActions commonActions, String value) {
		commonActions.inputtext(firstNameElement, value);
	}

	private void mName(CommonActions commonActions, char middlename) {
		commonActions.charValue(middleNameElement, middlename);
	}

	private void lName(CommonActions commonActions, String lastName) {
		commonActions.inputtext(lastNameElement, lastName);
	}

	private void selectSuffix(CommonActions commonActions, String suffix) {
		commonActions.selectValue(suffixElement, suffix);
	}

	private void dateofBirth(CommonActions commonActions, String value) {
		commonActions.inputtext(doBElement, value);

	}

	private void mailAddress(CommonActions commonActions, String value) {
		commonActions.inputtext(mailingaddressElement, value);
	}

	private void apt(CommonActions commonActions, String value) {
		commonActions.inputtext(aptElement, value);
	}

	private void city(CommonActions commonActions, String value) {
		commonActions.inputtext(cityElement, value);
	}

	private void checkPoBoxMilitary(CommonActions commonActions, boolean isboxselected) {
		boolean statusOfElement = commonActions.isSelected(checkBoxElement);
		if (!statusOfElement && isboxselected) {
			commonActions.click(checkBoxElement);
		} else if (statusOfElement && !isboxselected)
			commonActions.click(checkBoxElement);
	}

	private void getqtButton(CommonActions commonActions) {
		commonActions.click(getqoutebtnElement);
	}

	private void fixError(CommonActions commonActions, String address, String city) {
		boolean isErrorPresent = commonActions.isPresent(requiredErrorMsgAddressBy);
		if (isErrorPresent && commonActions.geturl()
				.equalsIgnoreCase("https://autoinsurance1.progressivedirect.com/0/UQA/Quote/NameAndAddressEdit")) {
			mailAddress(commonActions, address);

			
			  boolean isCityErrorPresent = commonActions.isPresent(requiredErrorMsgCityBy);
			  if(isCityErrorPresent) { city(commonActions, city); }
			 
			getqtButton(commonActions);
		}
	}
	public void startpageSteps (CommonActions commonActions, String fname, char mName, String lName, String Suffix,
			String dob, String address, String aptno, String city, boolean ispo ) {
		fName(commonActions, fname);
		mName(commonActions, mName);
		lName(commonActions, lName);
		selectSuffix(commonActions, Suffix);
		dateofBirth(commonActions, dob );
		mailAddress(commonActions, address );
		apt(commonActions,  aptno);
		city(commonActions,  city);
		checkPoBoxMilitary(commonActions, ispo);
		getqtButton(commonActions);
		fixError(commonActions, address, city );
		
	}

}
