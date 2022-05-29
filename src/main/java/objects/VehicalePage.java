package objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import commons.CommonActions;

public class VehicalePage {
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(5));

	public VehicalePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "VehiclesNew_embedded_questions_list_Year")
	WebElement yearElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_Make")
	WebElement makeBrandElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_Model")
	WebElement modNoElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_BodyStyle")
	WebElement bodyTypeElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_VehicleUse")
	WebElement primaryElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_OwnOrLease")
	WebElement ownorleasElement;

	@FindBy(id = "VehiclesNew_embedded_questions_list_LengthOfOwnership")
	WebElement howlongElement;
	@FindBy(id = "VehiclesNew_embedded_questions_list_AntitheftDevice")
	WebElement findbySecurityElement;
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	WebElement doneElement;
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continuElement;

	private void vehicaleYear(CommonActions commonActions, String value) {
		commonActions.selectValue(yearElement, value);
	}
	private void chooseBrand(CommonActions commonActions, String value) {
		commonActions.selectValue(makeBrandElement, value);
	}
	private void modelNo(CommonActions commonActions, String value) {
		commonActions.selectValue(modNoElement, value);
	}
	private void bodyType(CommonActions commonActions, String bodytype) {
		if (bodytype != null) {
			commonActions.selectValue(bodyTypeElement, bodytype);
		}
	}
	private void primaryUse(CommonActions commonActions, String Value) {
		commonActions.selectValue(primaryElement, Value);
	}
	private void ownorlease(CommonActions commonActions, String value) {
		commonActions.selectValue(ownorleasElement, value);
	}

	private void howlong(CommonActions commonActions, String value) {
		commonActions.selectValue(howlongElement, value);
	}

	private void findbySecurity(CommonActions commonActions, String value) {
		commonActions.selectValue(findbySecurityElement, value);
	}

	private void done(CommonActions commonActions) {
		commonActions.click(doneElement);
	}

	private void continueBtn(CommonActions commonActions){
		commonActions.click(continuElement);
		
	}

	public void vehicalepageSteps (CommonActions commonActions, String year, String brand, 
			String model, String body,  String primary, String own, String how, String find ) {
		vehicaleYear(commonActions, year);
		chooseBrand(commonActions, brand);
		modelNo(commonActions, model);
		bodyType(commonActions, body);
		primaryUse(commonActions, primary);
		ownorlease(commonActions, own);
		howlong(commonActions, how);
		findbySecurity(commonActions, find);
		done(commonActions);
		continueBtn(commonActions);
		
	}
	
}
