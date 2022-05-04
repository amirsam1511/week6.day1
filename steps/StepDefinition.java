package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {

	public ChromeDriver driver;
	
	public String deletedId;

	@Given("Launch the chrome browser")
	public void launch_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Given("Load the application url")
	public void load_the_application_url() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
	@Given("Enter the username as {string}")
	public void enter_the_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@Given("Enter the password as {string}")
	public void enter_the_password_(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@When("I click Login button")
	public void click_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then("I should be navigated to homepage without any issues")
	public void should_be_navigated_to_homepage_without_any_issues() {
		WebElement element = driver.findElement(By.linkText("CRM/SFA"));
		if(element.isDisplayed()) {
			System.out.println("Homepage is displayed");
		}
		else {
			System.out.println("Homepage is not displayed");
		}
	}
	@Then("I should see Error message in it")
	public void should_see_error_message() {
		String text = driver.findElement(By.xpath("//p[contains(text(),'User not found.')]")).getText();
		if(text.contains("User not found")) {
			System.out.println("The Following Errors Occurred:\r\n"
					+ "\r\n"
					+ "following error occurred during login: User not found.");
		}
		else {
			System.out.println("Credentials are valid");
		}
	}
	@When("I click CRMSFA link")
	public void clickCRMSFALink(){
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@Then("I should navigate to leaftaps application main page")
	public void leaftapsApplication() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@Given("I click Create Lead under Shortcuts")
	public void clickCreateLeadLink() {
		driver.findElement(By.xpath("//a[contains(text() ,'Create')]")).click();
	}
	@Given("I should see Create Lead inputs page")
	public void createLeadInputPage() {
		System.out.println("Navigated to "+driver.getTitle());
	}
	@Given("I enter the mandatory fields in create lead")
	public void enterMandatoryFieldsInCreateLead() {
		driver.findElement(By.xpath("//input[contains(@id,'company') ]")).sendKeys("IBM");
		driver.findElement(By.xpath("//input[contains(@id,'firstName') ]")).sendKeys("Hari");
		driver.findElement(By.xpath("//input[contains(@id,'lastName') ]")).sendKeys("R");
	}

	@Given("I enter the mandatory fields in create lead as follows {string},{string}and{string}")
	public void enterMandatoryFields(String companyName,String firstName, String lastName) {
		driver.findElement(By.xpath("//input[contains(@id,'company') ]")).sendKeys(companyName);
		driver.findElement(By.xpath("//input[contains(@id,'firstName') ]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[contains(@id,'lastName') ]")).sendKeys(lastName);
	}
	@When("I click Create Lead button")
	public void clickCreateLead() {
		driver.findElement(By.xpath("//input[contains(@class,'Submit') ]")).click();
	}
	@Then("I should navigate to View Lead page without any issues")
	public void verifyViewLeadPage() {
		System.out.println("Navigated to" + driver.getTitle());
	}
	@Then("I close the browser")
	public void closeBrowser() {
		driver.close();
	}
	@Given("I click Find Leads under shortcuts menu")
	public void clickFindLeadLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}
	@Given("I navigate to Phone tab")
	public void navigateToPhone() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}
	@Given("I enter Phone number")
	public void enterPhoneNumber() {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
	}
	@Given("I enter Phone number as {string}")
	public void enterPhoneNumberUsingDynamicValues(String phoneNumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
	}
	@When("I click Find Leads button")
	public void findLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@Then("I should see corresponding search results based on search criteria")
	public void searchCriteria() throws InterruptedException {
		Thread.sleep(2000);
		String phoneNumber = driver.findElement(By.xpath("//td[contains(@class,'formatedPrimaryPhone')]/following::div[contains(@class,'formatedPrimaryPhone')][2]")).getText();
		System.out.println(phoneNumber);
		if(phoneNumber.contains("9")) {
			System.out.println("Search results are based on corresponding search criteria");
		}
		else {
			System.out.println("Search results are not based on corresponding search criteria");
		}
	}
	@Then("I click the first resulting Id in the grid")
	public void firstResultingId() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@When("I click the first resulting Id")
	public void clickFirstResultingId() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Given("I click the Edit button")
	public void EditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@Given("I update the company Name")
	public void updateCompanyName() {
		WebElement updateCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		updateCompanyName.clear();
		updateCompanyName.sendKeys("Infosys");
	}
	@Given("I update the company Name as {string}")
	public void updateCompanyNameUsingDynamic(String companyName) {
		WebElement updateCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		updateCompanyName.clear();
		updateCompanyName.sendKeys(companyName);
	}
	@Given("I select the update button")
	public void selectUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("I should see the company name is updated without any issues")
	public void verifyCompanyName() {
		WebElement updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		if(updatedCompanyName.isDisplayed()==true) {
			System.out.println("Company Name is Updated");
		}
		else {
			System.out.println("Company Name is not Updated");
		}
	}
	@Given("I click Merge Leads under shortcuts menu")
	public void clickMergeLeads() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@When("I click the image icon of From Lead")
	public void imageIconOfFromLead() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	}
	@Then("I should navigate to Find Leads page of From Lead")
	public void navigateFromFindLeads() {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		System.out.println(driver.getTitle());
	}
	@Given("I enter the first name of From Lead")
	public void firstNameFromLead() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Hari");
	}
	@Given("I click Find Leads From Lead")
	public void findLeadsFromLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@When("I select the first resulting Id From Lead")
	public void resultingIdFromLead() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	@Then("I should see the corresponding Id fetched to From Lead field")
	public void IdFetchedFromLead() throws InterruptedException {
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
	}
	@When("I click the image icon of To Lead")
	public void imageIconOfToLead() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	}
	@Then("I should navigate to Find Leads page")
	public void navigateFromToLeads() {
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}
	@Given("I enter the first name of To Lead")
	public void firstNameToLead() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
	}
	@Given("I click Find Leads")
	public void findLeadsToLead() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	@When("I select the first resulting Id To Lead")
	public void resultingIdToLead() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
	}
	@Then("I should see the corresponding Id fetched from To Lead field")
	public void IdFetchedFromToLead() throws InterruptedException {
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(0));
	}
	@When("I select Merge button")
	public void clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
	@Then("I should see a alert message in the page")
	public void alertMessage() {
		driver.switchTo().alert();
	}
	@When("I dismiss the alert")
	public void dismissAlert() {
		driver.switchTo().alert().accept();
	}
	@Then("The screen is navigated to View Lead page")
	public void navigateToViewLead() {
		System.out.println("Screen is navigated to"+driver.getTitle());
	}
	@Given("I enter the first name of From Lead as {string}")
	public void firstNameFromLead(String fNameFromLead) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fNameFromLead);
	}
	@Given("I enter the first name of To Lead as {string}")
	public void firstNameToLead(String fNameToLead) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fNameToLead);
	}
	@When("I click Find Leads button and store the first resulting Id")
	public void findLeadsButtonAndStoreId() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		deletedId = driver.findElement(By.xpath("//td[contains(@class,'first ')]/div/a[1]")).getText();
		System.out.println(deletedId);
	}
	@Given("I click the Duplicate Lead button")
	public void duplicateLeadButton() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@When("I click the Delete button")
	public void deleteLeadButton() {
		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();
	}
	@Then("I should navigated to My Leads page")
	public void myLeadsPage() {
		System.out.println(driver.getTitle());
	}
	@Then("I verify the if the record is deleted without any issues")
	public void verifyDeleteLead() throws InterruptedException {
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("id")).sendKeys(deletedId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(3000);
		String recordDeleted = driver.findElement(By.xpath("//div[@class = 'x-paging-info']")).getText();
		if(recordDeleted.equals("No records to display")) {
			System.out.println("Record has been deleted");
		}
		else {
			System.out.println("Record has not been deleted");
		}	
	}
}
