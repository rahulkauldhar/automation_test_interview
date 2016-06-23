import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * Requirement:
 * 
 *  1. please fix all the bug in this file 
 *  2. please run it
 *  3. sent your test result and the fixed the file to us
 * ***
 * 
 * */
// Added dependencies and resolved issues for testing
// Prodigy test for automation testing 

@Test(groups={"localTest"})
public class GoogleExampleIT {
	private static final Logger LOGGER = LogManager.getLogger(GoogleExampleIT.class.getName());
	private WebDriver driver;
	@FindBy(css = "[name='q']")
	private WebElement searchBar;

	@Test
	public void googleCheeseExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Cheese!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}

	@Test(enabled = true)
	public void googleMilkExample() throws Exception {
		searchBar.clear();
		searchBar.sendKeys("Milk!");
		searchBar.sendKeys(Keys.ENTER);
		LOGGER.info("Page title is: {}"+driver.getTitle());
		Assert.assertTrue(driver.getTitle().equals("Google"));
	}

	@BeforeMethod
	public void setUp() {
		
		driver = new  FirefoxDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		driver.get("http://www.google.com");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
