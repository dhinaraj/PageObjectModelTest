package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;

import pageobjects.BasePage;
import pageobjects.CreateAccountPage;
import pageobjects.SignInPage;

public class CreateAnAccountTest extends TestBaseSetup {
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	private CreateAccountPage createAccountPage;
		
		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
		
		@Test
		public void verifyCreateAnAccounPage() throws InterruptedException {
			System.out.println("Create An Account page test...");
			basePage = new BasePage(driver);
			signInPage = basePage.clickSignInBtn();
			createAccountPage = signInPage.clickonCreateAnAccount();
			Assert.assertTrue(createAccountPage.verifyPageTitle(), "Create your Google Account");
			Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Create your Google Account");
		}
		
		public void verifySignInFunction() {
			
		}

}
