package pageextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailRegistration {
	@FindBy(id="firstName")
    private WebElement txtfname;
	@FindBy(id="lastName")
    private WebElement txtlname;
	@FindBy(id="username")
    private WebElement txtemail;
	@FindBy(name="Passwd")
    private WebElement txtpassword;
	@FindBy(name="ConfirmPasswd")
    private WebElement txtcpassword;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	private WebElement btnnext;
	@FindBy(xpath="//span[contains(text(),'Sign in instead')]")
	private WebElement lnksignin;
	
	public EmailRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createAccount(String fname, String lname, String email, String pass, String cpass)
	{
		txtfname.sendKeys(fname);
		txtlname.sendKeys(lname);
		txtemail.sendKeys(email);
		txtpassword.sendKeys(pass);
		txtcpassword.sendKeys(cpass);
		btnnext.click();
	}
	public void navigateTOSignIn() {
		lnksignin.click();
	}
}
