package pageextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLogin {
	@FindBy(id="login1")
 private WebElement txtusername;
	@FindBy(id="password")
 private WebElement txtpassword;
	@FindBy(name="proceed")
 private WebElement btnlogin;
	@FindBy(linkText = "Create a new account")
 private WebElement inkcreateaccount;
	@FindBy(css="div#div_login_error>b")
 private WebElement lblerror;
	//constructor
	public RediffLogin(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
    //method declaration
	public void login(String username, String password)
	{
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnlogin.click();
	}
	public String getError()
	{
		return lblerror.getText();
	}
	public void navigateToRegistration()
	{
		inkcreateaccount.click();
	}
	public void clearData()
	{
	     txtusername.clear();
	     txtpassword.clear();
	}
}
