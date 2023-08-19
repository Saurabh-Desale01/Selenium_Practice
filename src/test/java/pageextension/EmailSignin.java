package pageextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailSignin {
	@FindBy(id="identifierId")
    private WebElement txtemail;
	@FindBy(xpath="//span[contains(text(),'Next')]")
    private WebElement btnnext;
	
	public EmailSignin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void signInEmail(String email) {
		txtemail.sendKeys(email);
		btnnext.click();
	}
}
