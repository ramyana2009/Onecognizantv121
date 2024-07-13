package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.pageObjects.HomePage;
import pageObjects.pageObjects.LoginPage;
import pageObjects.pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass
{
@Test
	public void verifyLogin() throws IOException
	{
		logger.info("**************************** Starting TC002_LoginTest *********************************");
		try {
		//Homepgae
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		//loading properties file
		
				FileReader file=new FileReader(".//src//test//resources//config.properties");
				Properties p=new Properties();
				p.load(file);
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage mp=new MyAccountPage(driver);
		boolean TargetPage = mp.isMyAccountPageDisplayed();
		Assert.assertTrue(TargetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}

		
		logger.info("***************************** Ending TC002_Login Test *****************************");
		
	
	}
}
