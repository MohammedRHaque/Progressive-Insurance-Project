package pncbank.com.qa.test;

import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTestRobust extends BaseClass {

	@Test(enabled =  true, priority = 2)
	public void jeeptest () {
		landingPage.landingpageSteps(commonActions);
		zipCodePage.zipcodeSteps(commonActions, "10462");
		startPage.startpageSteps(commonActions, "Jamil", 'M', "Hasan", "SR", "12/30/1978", "2230 Manning ST", "3B", "Bronx", true);
		vehicalePage.vehicalepageSteps(commonActions, "2016", "JEEP", "WRANGLER", "", "2TNC", "1", "E", "9" );
	}
	

	@Test (enabled = true, priority = 1)
	public void BMWtest () {
		landingPage.landingpageSteps(commonActions);
		zipCodePage.zipcodeSteps(commonActions, "10029");
		startPage.startpageSteps(commonActions, "Dravid", 'M', "Chowdhury", "SR", "12/30/1978", "35E 106th ST", "6k", "Manhatton", true);
		vehicalePage.vehicalepageSteps(commonActions, "2016", "BMW", "228", "2DR 4CYL","2TNC", "1", "E", "9" );
	}
	
}
