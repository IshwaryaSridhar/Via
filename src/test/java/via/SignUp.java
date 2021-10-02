package via;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class SignUp extends Base {
	
	Excel_Import ex= new Excel_Import("src/test/resources/data/Data.xlsx");
	Properties p =new Properties();

	public void getData(String email, String name, String pwd, String mobile) throws Exception {
	  
	  p.load(new FileInputStream("settings.property"));
	  driver.get(p.getProperty("url"));
	  driver.findElement(By.id("SignIn")).click();
	  driver.findElement(By.xpath("//span[normalize-space()='SIGN UP']")).click();
	  driver.findElement(By.xpath("//input[@id='emailIdSignUp']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='nameSignUp']")).sendKeys(name);
	  driver.findElement(By.xpath("//input[@id='passwordSignUp']")).sendKeys(pwd);
	  driver.findElement(By.xpath("//input[@id='mobileNoSignUp']")).sendKeys(mobile);
	  driver.findElement(By.xpath("//input[@id='signUpValidate']")).click(); 
	}
	
  @Test(enabled=true, description="Testing with valid credentials")
  public void tc_13() throws Exception {

	  getData(ex.getData("Sheet1", 1, 0),ex.getData("Sheet1", 1, 1),ex.getData("Sheet1", 1, 2),ex.getData("Sheet1", 1, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("valid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath(p.getProperty("valid"))).getText());
  }
  
  @Test(enabled=true, description="Testing with existing email and mobile")
  public void tc_14() throws Exception {
	  
	  getData(ex.getData("Sheet1", 2, 0),ex.getData("Sheet1", 2, 1),ex.getData("Sheet1", 2, 2),ex.getData("Sheet1", 2, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
  }
  
  @Test(enabled=true, description="Testing with existing email")
  public void tc_15() throws Exception {
	  
	  getData(ex.getData("Sheet1", 3, 0),ex.getData("Sheet1", 3, 1),ex.getData("Sheet1", 3, 2),ex.getData("Sheet1", 3, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
  }
  
  @Test(enabled=true, description="Testing with existing mobile")
  public void tc_16() throws Exception {
	 
	  getData(ex.getData("Sheet1", 4, 0),ex.getData("Sheet1", 4, 1),ex.getData("Sheet1", 4, 2),ex.getData("Sheet1", 4, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
  }
  
  @Test(enabled=true, description="Testing with invalid email")
  public void tc_17() throws Exception {
	  
	  getData(ex.getData("Sheet1", 5, 0),ex.getData("Sheet1", 5, 1),ex.getData("Sheet1", 5, 2),ex.getData("Sheet1", 5, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Email");
  }
  
  @Test(enabled=true, description="Testing with invalid mobile")
  public void tc_18() throws Exception {
	  
	  getData(ex.getData("Sheet1", 6, 0),ex.getData("Sheet1", 6, 1),ex.getData("Sheet1", 6, 2),ex.getData("Sheet1", 6, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Mobile");
  }
  
  @Test(enabled=true, description="Testing with invalid password")
  public void tc_19() throws Exception {
	  
	  getData(ex.getData("Sheet1", 7, 0),ex.getData("Sheet1", 7, 1),ex.getData("Sheet1", 7, 2),ex.getData("Sheet1", 7, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Password must be atleast 8 characters long");
  }
 
  @Test(enabled=true, description="Testing with invalid name")
  public void tc_20() throws Exception {
	 
	  getData(ex.getData("Sheet1", 8, 0),ex.getData("Sheet1", 8, 1),ex.getData("Sheet1", 8, 2),ex.getData("Sheet1", 8, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Name");
  }
  
  @Test(enabled=true, description="Testing with null credentials")
  public void tc_21() throws Exception {
	  
	  getData(ex.getData("Sheet1", 9, 0),ex.getData("Sheet1", 9, 1),ex.getData("Sheet1", 9, 2),ex.getData("Sheet1", 9, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid email");
  }
  
  @Test(enabled=true, description="Testing without email")
  public void tc_22() throws Exception {
	  
	  getData(ex.getData("Sheet1", 10, 0),ex.getData("Sheet1", 10, 1),ex.getData("Sheet1", 10, 2),ex.getData("Sheet1", 10, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid email");
  }
  
  @Test(enabled=true, description="Testing without name")
  public void tc_23() throws Exception {
	  
	  getData(ex.getData("Sheet1", 11, 0),ex.getData("Sheet1", 11, 1),ex.getData("Sheet1", 11, 2),ex.getData("Sheet1", 11, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid name");
  }
  
  @Test(enabled=true, description="Testing without password")
  public void tc_24() throws Exception {
	 
	  getData(ex.getData("Sheet1", 12, 0),ex.getData("Sheet1", 12, 1),ex.getData("Sheet1", 12, 2),ex.getData("Sheet1", 12, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Password must be atleast 8 characters long");
  }
  
  @Test(enabled=true, description="Testing without mobile")
  public void tc_25() throws Exception {
	  
	  getData(ex.getData("Sheet1", 13, 0),ex.getData("Sheet1", 13, 1),ex.getData("Sheet1", 13, 2),ex.getData("Sheet1", 13, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Mobile Required");
  }
  
  
}