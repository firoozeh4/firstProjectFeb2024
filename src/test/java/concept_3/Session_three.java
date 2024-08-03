package concept_3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Session_three {
	
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@After
	public void teardown() {
		driver.close();
	}
	@Test
	public void Login_test() {
	WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//*[@id=\"login_submit\"]"));
	
	By USER_NAME_FIELD = By.xpath("//*[@id=\"user_name\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id=\"login_submit\"]");
	By DASHBOARD_FIELD = By.xpath("//strong[text()='Dashboard']");
	
//	USER_NAME_ELEMENT.sendKeys("demo@codefios.com");
//	USER_NAME_ELEMENT.clear();
	driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
	
	
//	PASSWORD_ELEMENT.sendKeys("abc1234");
//	PASSWORD_ELEMENT.clear();
//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
	driver.findElement(SIGNIN_BUTTON_FIELD).click();
	
	WebDriverWait wait = new WebDriverWait(driver , 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_FIELD));
	
//	driver.findElement(By.xpath("//*[@id=\"user_name\"]")).sendKeys("demo@codefios.com");	
	WebElement DASHBOARD_ELEMENT = driver.findElement(By.xpath("//strong[text()='Dashboard']"));
	//Assert.assertTrue("Dashboard page not found", driver.findElement(DASHBOARD_FIELD).isDisplayed());
	System.out.println("Driver");
	Assert.assertEquals("Dashboard not Found", "Dashboard",driver.findElement(DASHBOARD_FIELD).getText());
	
		
	}
}
