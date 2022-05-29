package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commons.CommonActions;

public class LandingPage {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[@class='txt'])[1]")
	WebElement autoElement;

	@FindBy(xpath = "(//span[contains(text(),'Auto')])[1]")
	WebElement altautoElement;

	private void clickAuto(CommonActions commonActions) {
		if (commonActions.isDisplayed(autoElement)) {
			commonActions.click(autoElement);

		} else if (commonActions.isDisplayed(altautoElement)) {
			commonActions.click(altautoElement);
		}
	}

	public void landingpageSteps(CommonActions commonActions) {
		clickAuto(commonActions);
	}

}
