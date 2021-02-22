package com.accenture.steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FormEnterVehicleDataSteps {

	private WebDriver driver;

	@Given("^I am in Tricents web page$")
	public void iAmInTricentsWebPage() throws Throwable {

		WebElement tricentis = driver.findElement(By.id("tricentis_logo"));
		if (tricentis.isDisplayed()) {
			System.out.println("Tricents page has been loaded successfully.");
		}

	}

	@When("^I fulfill the entire tricents data form$")
	public void iFulfillTheEntireTricentsDataForm() throws Throwable {
		// filling Vehicle data
		System.out.println("Filling vehicle data...");
		driver.findElement(By.id("make")).click();
		driver.findElement(By.xpath("//*[@id='make']/option[@value='Honda']")).click();
		String make = driver.findElement(By.xpath("//*[@id='make']/option[@value='Honda']")).getText();
		System.out.println("Make: " + make);
		driver.findElement(By.xpath("//*[@id='model']/option[@value='Motorcycle']")).click();
		String model = driver.findElement(By.xpath("//*[@id='model']/option[@value='Motorcycle']")).getText();
		System.out.println("Model: " + model);
		driver.findElement(By.id("cylindercapacity")).sendKeys("471");
		driver.findElement(By.id("engineperformance")).sendKeys("35");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("10/01/2019");
		driver.findElement(By.xpath("//*[@id='numberofseats']/option[@value='2']")).click();
		String seats = driver.findElement(By.xpath("//*[@id='numberofseats']/option[@value='2']")).getText();
		System.out.println("Number of seats: " + seats);
		driver.findElement(By.xpath("//select[@id='numberofseatsmotorcycle']/option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='fuel']/option[@value='Gas']")).click();
		driver.findElement(By.id("payload")).sendKeys("176");
		driver.findElement(By.id("totalweight")).sendKeys("184");
		driver.findElement(By.id("listprice")).sendKeys("20000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("ABC-123");
		driver.findElement(By.id("annualmileage")).sendKeys("6213");
		driver.findElement(By.id("nextenterinsurantdata")).click();

		// filling Enter Insurant Data
		System.out.println("Filling insurant data...");
		driver.findElement(By.id("firstname")).sendKeys("Tom");
		driver.findElement(By.id("lastname")).sendKeys("Jobim");
		driver.findElement(By.id("birthdate")).sendKeys("02/10/1981");
		driver.findElement(By.xpath("//*[@id='country']/option[@value='Brazil']")).click();
		driver.findElement(By.id("zipcode")).sendKeys("12246021");
		driver.findElement(By.id("city")).sendKeys("São José dos Campos");
		driver.findElement(By.xpath("//*[@id='occupation']/option[@value='Employee']")).click();

		WebElement checkBox1;
		checkBox1 = driver.findElement(By.id("speeding"));
		Actions act = new Actions(driver);
		act.moveToElement(checkBox1).click().perform();

		driver.findElement(By.id("nextenterproductdata")).click();

		// Enter Product Data
		System.out.println("Filling product data...");
		driver.findElement(By.id("startdate")).sendKeys("04/05/2021");
		driver.findElement(By.xpath("//*[@id=\'insurancesum\']/option[3]")).click();
		driver.findElement(By.xpath("//*[@id=\'meritrating\']/option[6]")).click();
		driver.findElement(By.xpath("//*[@id=\"damageinsurance\"]/option[4]")).click();

		WebElement checkBox2;
		checkBox2 = driver.findElement(By.id("LegalDefenseInsurance"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(checkBox2).click().perform();

		driver.findElement(By.xpath("//*[@id=\'courtesycar\']/option[3]")).click();
		driver.findElement(By.id("nextselectpriceoption")).click();

		// Select Price Option
		System.out.println("Selecting price option...");
		WebElement checkBox3;
		checkBox3 = driver.findElement(By.id("selectgold"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(checkBox3).click().perform();

		WebElement element = driver.findElement(By.id("nextsendquote"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));

		driver.findElement(By.id("nextsendquote")).click();

	}

	// Send Quote
	@And("^send the fullfiled data form$")
	public void sendTheFullfiledDataForm() throws Throwable {
		System.out.println("Sending quote...");
		Faker faker = new Faker();
		String emailFake = faker.internet().emailAddress();
		driver.findElement(By.id("email")).sendKeys(emailFake);
		driver.findElement(By.id("phone")).sendKeys("4244471677");
		System.out.println("The fake email was: " + emailFake);

		String fakeName = faker.name().username();
		driver.findElement(By.id("username")).sendKeys(fakeName);
		System.out.println("The fake username was: " + fakeName);

		driver.findElement(By.id("password")).sendKeys("Teste123");
		driver.findElement(By.id("confirmpassword")).sendKeys("Teste123");
		driver.findElement(By.id("Comments")).sendKeys(
				"This is a automate test fullfilment form. The entire informatation provided till here is just for this purpose.");
		driver.findElement(By.id("sendemail")).click();

	}

	@Then("^I should receive the success pop-pup \"([^\"]*)\"$")
	public void iShouldReceiveTheSuccessPopPup(String arg1) throws Throwable {
		Thread.sleep(10000);
		String successMsg = driver.findElement(By.xpath("//div[4]/h2")).getText();
		Assert.assertEquals(arg1, successMsg);	}

		
	

	@Before
	public void startTest() {
		driver = new ChromeDriver();
		System.out.println("Starting the test...");
		driver.manage().window().maximize();
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}

	@After
	public void closeBrowser() {
		driver.quit();
		System.out.println("Test scenario done!");
	}

}
