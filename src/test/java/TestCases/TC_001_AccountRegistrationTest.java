package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.pageObjects.*;
import pageObjects.pageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
	    logger.debug("This is a debug log message");
	    try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating expected message..");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);;
		}
		else {
			
		logger.error("test failed-----");
		logger.debug("Debug logs -----");
		Assert.assertTrue(false);
		
		}
		
	    } 
	    catch(Exception e)
	    {
	    logger.error("Test failed :"+ e.getMessage());
	    Assert.fail("Test failed :"+ e.getMessage());
	    }
	    
finally {
	 logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
}
  
	
	}}
	









