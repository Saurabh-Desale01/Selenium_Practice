package pageextension;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffRegistration {
	@FindBy(css="input[name^='name']")
   private WebElement txtname;
	@FindBy(css="input[name^='login']")
   private WebElement txtemail;
	@FindBy(css="input[name^='pass']")
   private WebElement txtpassword;
	@FindBy(css="input[name^='gender']")
   private List<WebElement> rbgender;
	@FindBy(id="country")
   private WebElement ddcountry;
	
	public RediffRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createAccount(String name, String email, String password, String gender, String country )
	{
		txtname.sendKeys(name);
		txtemail.sendKeys(email);
		txtpassword.sendKeys(password);
		for(WebElement rb: rbgender)
		{
			if(rb.getAttribute("value").equals(gender))
			{
				rb.click();
				break;
			}
		}
		Select countrydd=new Select(ddcountry);
		countrydd.selectByVisibleText(country);
	}
}
