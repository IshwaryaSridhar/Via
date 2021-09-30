package via;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp extends Base {
	
	public boolean getData(String email, String name, String pwd, String mobile) {
	  driver.findElement(By.id("wzrk-cancel")).click();
	  driver.findElement(By.id("SignIn")).click();
	  driver.findElement(By.xpath("//span[normalize-space()='SIGN UP']")).click();
	  driver.findElement(By.xpath("//input[@id='emailIdSignUp']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='nameSignUp']")).sendKeys(name);
	  driver.findElement(By.xpath("//input[@id='passwordSignUp']")).sendKeys(pwd);
	  driver.findElement(By.xpath("//input[@id='mobileNoSignUp']")).sendKeys(mobile);
	  driver.findElement(By.xpath("//input[@id='signUpValidate']")).click();
	  boolean data=driver.findElement(By.xpath("//div[@class='elementPad menuLabel secNavIcon']")).isDisplayed();
	  return data;
	  
	  
	}
  @Test
  public void tc_13() {
	  driver.get("https://in.via.com/");
	  boolean d=getData("testingdemo111@gmail.com", "Demo", "testingdemo", "7689456734");
	  Assert.assertTrue(d);
  }
 
}