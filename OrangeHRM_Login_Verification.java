package task_17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Login_Verification {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Initialize the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to demoblaze website
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Enter a Valid User Name
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");

		// Enter a Valid User Password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");

		// Click login button
		WebElement loginButton = driver.findElement(By.xpath("//button[text()=\" Login \"]"));
		loginButton.click();

		// After logged in get user name
		WebElement visibleUserName = driver.findElement(By.className("oxd-userdropdown-name"));
		String loggedInUserName = visibleUserName.getText();
		System.out.println(loggedInUserName);

		// Verify user is logged in successfully

		if (visibleUserName.isDisplayed()) {
			System.out.println("Login Successful. UserName: " + loggedInUserName);
		} else {
			System.out.println("Login Failed.");
		}

		driver.quit();

	}
}
