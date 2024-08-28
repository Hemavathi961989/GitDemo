package UGO;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Internetplans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rajiv\\Downloads\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://portal-ugo-360.ife.ugo.aero/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Switch language to French
		WebElement staticdropdown = driver
				.findElement(By.xpath("//select[contains(@data-testid,'eula-lang-selector')]"));
		Select language = new Select(staticdropdown);
		language.selectByValue("fr");

		// Navigating to the Home page of the UGO portal
		driver.findElement(By.xpath("//button[contains(@class,'btn-accept')]")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@data-testid,'internet-connectivity-link')]")));

		// To verify whether the main menu is translated to French
		String firstLinkOnHome = driver.findElement(By.xpath("//span[contains(text(),'Activités à destination')]"))
				.getText();
		System.out.println(firstLinkOnHome);

		try {
			Assert.assertEquals(firstLinkOnHome, "ACTIVITÉS À DESTINATION");

		} catch (AssertionError e) {
			System.out.println("Main menu is not translated in French");
			throw e;
		}
		System.out.println("Main menu is translated in French");

		// Navigating to User profile and verify whether the content in the user profile
		// page is translated to French
		driver.findElement(By.xpath("//img[contains(@alt,'User Profile')]")).click();
		String translatedText = driver.findElement(By.className("form-title")).getText();
		System.out.println(translatedText);

		if (translatedText.contentEquals("Langue")) {
			System.out.println("User Profile is translated in French");
		} else {
			System.out.println("User Profile is not translated in French");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigating to home page and verify whether the content in the home page is
		// translated to French

		driver.findElement(By.className("airline-company-logo")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='airline-hotnews-text']/h2")));
		String homePageContent = driver.findElement(By.xpath("//div[@class='airline-hotnews-text']/h2")).getText();
		System.out.println(homePageContent);

		if (homePageContent.contentEquals("Correspondance en vol")) {
			System.out.println("Home Page is translated in French");
		} else {
			System.out.println("Home Page is not translated in French");
		}

		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigating to the Internet Plans section, click on "see all" link, click on
		// "Voucher" feature
		// Enter "TEST" code in the pop-up window to validate the error message.

		js.executeScript("window.scrollBy(0,1050)");

		driver.findElement(By.linkText("Voir tout")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Connectez-vous')]")));

		driver.findElement(By.xpath("//div[@class=\"links-container\"]/button")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter your code']")).sendKeys("TEST");
		driver.findElement(By.xpath(
				"//div[@class=\"content-pop-up\"]/section[@class=\"VoucherPopup\"]/button[contains(text(),'Envoyer')]"))
				.click();
		String error = driver.findElement(By.xpath("//div[@class='error ']/span")).getText();
		System.out.println(error);

		// Close the voucher pop-up
		driver.findElement(By.xpath("//button[contains(@class,'VoucherPopup-closeWindow')]")).click();

		// End the session
		driver.close();

	}

}
