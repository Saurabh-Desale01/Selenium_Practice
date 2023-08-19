package pageextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPasswordPage {
   @FindBy(css="input[name='password']")
   private WebElement txtpassword;
   @FindBy(xpath="//span[contains(text(),'Next')]")
   private WebElement btnnext;
   
	public EmailPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void signInPassword(String password) {
		txtpassword.sendKeys(password);
		btnnext.click();
	}
}
