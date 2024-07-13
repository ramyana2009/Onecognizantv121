package pageObjects.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;


	@FindBy(xpath ="//h2[(text()='My Account')]")//MyAccountPage Heading
	WebElement MsgHeading;
	
	public boolean isMyAccountPageDisplayed()
	{
		try {
			return (MsgHeading.isDisplayed());	
		}
		
		catch(Exception e)
		{
			return false;
		}
		
	}
	public void clickLogout() {
		lnkLogout.click();

	}
}
