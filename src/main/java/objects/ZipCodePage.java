package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.CommonActions;

public class ZipCodePage {

	public ZipCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="zipCode_overlay")
	WebElement zipCodeInputElement;
	@FindBy(id = "qsButton_overlay")
	WebElement getQuotElement;

	@FindBy(id = "zipCode_overlay_subproducts")
	WebElement altZipCodeElement;
	@FindBy(id = "qsButton_overlay_subproducts")
	WebElement altQuoteElement;

	private void inputZipCode(CommonActions commonActions, String zipcode) {
		 if(whichUrl(commonActions).equalsIgnoreCase("https://www.progressive.com/#s")) {
	  commonActions.inputtext(altZipCodeElement, zipcode); }
		   else {
		     commonActions.inputtext(zipCodeInputElement, zipcode);
			 }
		 }
		  
	private void getQuoteBtn(CommonActions commonActions) {
		if(whichUrl(commonActions).equalsIgnoreCase("https://www.progressive.com/#s")) {
		  commonActions.click(altQuoteElement);
	} else {
		 commonActions.click(getQuotElement);
	}

	}

	private String whichUrl (CommonActions commonActions)	{
		return commonActions.geturl();
	}
	public void zipcodeSteps (CommonActions commonActions, String zip) {
		inputZipCode(commonActions, zip);
		getQuoteBtn(commonActions);
		
	}
	
}


