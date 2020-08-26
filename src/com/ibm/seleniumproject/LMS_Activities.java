package com.ibm.seleniumproject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.common.BaseTest;

public class LMS_Activities extends BaseTest {

	
	/* Activity 1 : Verify the web site title */
	@Test(priority = 0)
	public void verifyTitle() {
		String actualtitle = this.getDriver().getTitle();
		System.out.println("Title: " + actualtitle);
		Reporter.log("Title: " + actualtitle);
		Assert.assertEquals(actualtitle, "Alchemy LMS – An LMS Application");
		Reporter.log("Tiltle '" + actualtitle + "' matched with expected title");
	}

	/* Activity 2 : Verify the website heading */
	@Test(priority = 1)
	public void verifyHeading() {
		WebElement heading = this.getDriver().findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
		this.getWait().until(ExpectedConditions.visibilityOf(heading));
		String actualHeading = heading.getText();
		System.out.println("Heading: " + actualHeading);
		Reporter.log("Heading: " + actualHeading);
		Assert.assertEquals(actualHeading, "Learn from Industry Experts");
		Reporter.log("Heading '" + actualHeading + "' matched with expected heading");
	}

	/* Activity 3 : Verify the title of the first info box */
	@Test(priority = 2)
	public void verifyFirstInforboxTiltle() {
		WebElement FirstInfoboxTiltle = this.getDriver().findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]"));
		this.getWait().until(ExpectedConditions.visibilityOf(FirstInfoboxTiltle));
		String actualFirstInforboxTiltle = FirstInfoboxTiltle.getText();
		System.out.println("First Info box Tiltle: " + actualFirstInforboxTiltle);
		Reporter.log("First Info box title: " + actualFirstInforboxTiltle);
		Assert.assertEquals(actualFirstInforboxTiltle, "Actionable Training");
		Reporter.log(
				"First Info box title '" + actualFirstInforboxTiltle + "' matched with expected First Info box title");
	}

	/* Activity 4 : Verify the title of the second most popular course */
	@Test(priority = 3)
	public void verifySecondPopularCourseTiltle() {
		WebElement SecondPopularCourseTiltle = this.getDriver().findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[2]"));
		this.getWait().until(ExpectedConditions.visibilityOf(SecondPopularCourseTiltle));
		String actualSecondPopularCourseTiltle = SecondPopularCourseTiltle.getText();
		System.out.println("Second Popular Course Tiltle: " + actualSecondPopularCourseTiltle);
		Reporter.log("Second Popular Course Title: " + actualSecondPopularCourseTiltle);
		Assert.assertEquals(actualSecondPopularCourseTiltle, "Interesting Quizzes");
		Reporter.log("Second Popular Course Title '" + actualSecondPopularCourseTiltle
				+ "' matched with expected Second Popular Course Title");
	}

	/* Activity 5 : Navigate to another page */
	@Test(priority = 4)
	public void verifyMyAccountPage() {
		WebElement myAccount = this.getDriver().findElement(By.linkText("My Account"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(myAccount));
		myAccount.click();
		Reporter.log("My Account clicked");
		String actualMyAccountpageTiltle = this.getDriver().getTitle();
		System.out.println("MyAccount Page Tiltle: " + actualMyAccountpageTiltle);
		Reporter.log("My account page title: " + actualMyAccountpageTiltle);
		Assert.assertEquals(actualMyAccountpageTiltle, "My Account – Alchemy LMS");
		Reporter.log("My account page title '" + actualMyAccountpageTiltle
				+ "' matched with expected My account page title");
	}

	/* Activity 6 : Logging into the site */
	@Test(priority = 5)
	@Parameters({ "Username", "Password" })
	public void Login(String username, String password) {
		WebElement myAccount = this.getDriver().findElement(By.linkText("My Account"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(myAccount));
		myAccount.click();
		Reporter.log("My Account clicked");
		WebElement login = this.getDriver().findElement(By.xpath("//a[contains(@class,'ld-login')]"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		Reporter.log("Login button clicked");
		this.getDriver().findElement(By.id("user_login")).sendKeys(username);
		Reporter.log("'" + username + "' entered in login text box");
		this.getDriver().findElement(By.id("user_pass")).sendKeys(password);
		Reporter.log("'" + password + "' entered in password text box");
		this.getDriver().findElement(By.id("wp-submit")).click();
		Reporter.log("Login button clicked clicked");
		WebElement username_element = this.getDriver().findElement(By.xpath("//a[contains(text(),'Howdy')]"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(username_element));
		String userName = username_element.getText();
		System.out.println("userName: " + userName);
		Reporter.log("Username: " + userName);
		Assert.assertEquals(userName, "Howdy, root");
		Reporter.log("User logged in");
	}

	/* Activity 7 : Count the number of courses */
	@Test(priority = 6)
	public void allCoursesCount() {
		WebElement allCourses = this.getDriver().findElement(By.linkText("All Courses"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(allCourses));
		allCourses.click();
		List<WebElement> coursesList = this.getDriver().findElements(By.xpath("//a[contains(text(),'See more')]"));
		System.out.println("Courses Count: " + coursesList.size());
		Reporter.log("Courses Count: " + coursesList.size());
	}

	/* Activity 8 : Contact the admin */
	@Test(priority = 7)
	public void contactUs() {
		WebElement Contact = this.getDriver().findElement(By.linkText("Contact"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(Contact));
		Contact.click();
		Reporter.log("Contact clicked");
		this.getDriver().findElement(By.xpath("//label[contains(text(),'Full Name')]//following::input[1]")).sendKeys("Test");
		Reporter.log("Test entered in Full Name text box");
		this.getDriver().findElement(By.xpath("//label[contains(text(),'Email')]//following::input[1]"))
				.sendKeys("test@yopmail.com");
		Reporter.log("test@yopmail.com entered in Email text box");
		this.getDriver().findElement(By.xpath("//label[contains(text(),'Subject')]//following::input[1]")).sendKeys("Test");
		Reporter.log("Test entered in Subject text box");
		this.getDriver().findElement(By.xpath("//label[contains(text(),'Comment or Message')]//following::textarea[1]"))
				.sendKeys("Test");
		Reporter.log("test entered in Comment or Message text area");
		this.getDriver().findElement(By.xpath("//button[contains(text(),'Send Message')]")).click();
		Reporter.log("Send Message button clicked");
		WebElement messageText = this.getDriver().findElement(By.xpath("//div[contains(@id,'wpforms-confirmation')]/p"));
		this.getWait().until(ExpectedConditions.visibilityOf(messageText));
		String message = messageText.getText();
		System.out.println("Message: " + message);
		Reporter.log("Message: " + message);
		Assert.assertEquals(message, "Thanks for contacting us! We will be in touch with you shortly.");
		Reporter.log("Message '" + message + "' matched with expected Message");
	}

	/* Activity 9 : Complete a simple lesson */
	@Test(priority = 8)
	public void courseTitle() {
		WebElement allCourses = this.getDriver().findElement(By.linkText("All Courses"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(allCourses));
		allCourses.click();
		Reporter.log("All Courses clicked");
		this.getDriver().findElement(By.xpath("//a[contains(text(),'See more')]")).click();
		Reporter.log("First Course clicked");
		WebElement expand = this.getDriver().findElement(By.xpath("(//span[text()='Expand'])[1]"));
		this.getWait().until(ExpectedConditions.elementToBeClickable(expand));
		expand.click();
		Reporter.log("Clicked on Expand for first lession");
		WebElement lession = this.getDriver().findElement(By.xpath("(//span[@class='ld-topic-title'])[1]"));
		this.getWait().until(ExpectedConditions.visibilityOf(lession));
		String actualLession = lession.getText();
		System.out.println("Lession: " + actualLession);
		Reporter.log("Lession: " + actualLession);
		Assert.assertEquals(actualLession, "This is the First Topic");
		Reporter.log("Lession '" + actualLession + "' matched with expected Lession");
	}

}
