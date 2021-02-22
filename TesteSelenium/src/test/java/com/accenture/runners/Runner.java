package com.accenture.runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/browse_page.feature",
		glue = "com.accenture.steps",
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class Runner {
	
//	@Before
//	public static void reset() {
//	System.setProperty("webdriver.chrome.driver",
//		"C:\\Windows\\chromedriver.exe");
//	
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.get("http://sampleapp.tricentis.com/101/app.php");
//	
//	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//	WebDriver driver = new ChromeDriver();
//	
	
//	driver.get("http://sampleapp.tricentis.com/101/app.php");
//		
//	driver.findElement(By.id("email")).sendKeys("eu@bandeira.io");
//	driver.findElement(By.name("senha")).sendKeys("123");
//	driver.findElement(By.cssSelector("button[type='submit']")).click();
//	driver.findElement(By.cssSelector("a[href='/reset']")).click();
//	driver.quit();
//		
//	}
	
}