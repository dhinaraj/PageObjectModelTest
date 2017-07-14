package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private By signInButton = By.linkText("Sign in");
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public SignInPage clickSignInBtn() {
		System.out.println("clicking on sign in button");
		try {
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    WebElement signInBtnElement = wait.until(ExpectedConditions.visibilityOf((WebElement) signInButton));
			if(signInBtnElement.isDisplayed()||signInBtnElement.isEnabled())
			{
				signInBtnElement.click();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Element not found");
		}
		return new SignInPage(driver);
	}
	
	public void clickImagesLink() {
		//It should have a logic to click on images link
		//And it should navigate to google images page
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle="Google";
		return getPageTitle().contains(expectedPageTitle);
	}
}
