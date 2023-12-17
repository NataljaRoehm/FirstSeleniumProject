package com.tests;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!isElementPresent(By.cssSelector("[href='/register']"))){
      driver.findElement(By.xpath("//button[.='Log out']")).click();
    }
  }
  @Test
  public void registerExistedNegativeTest() {
    //click on register link
    driver.findElement(By.cssSelector("[href='/register']")).click();
    //click  link gender point
    driver.findElement(By.cssSelector("#gender-female")).click();
     //enter firstname
    driver.findElement(By.name("FirstName")).click();
    driver.findElement(By.name("FirstName")).clear();
    driver.findElement(By.name("FirstName")).sendKeys("Moni");
    //enter lastname
    driver.findElement(By.name("LastName")).click();
    driver.findElement(By.name("LastName")).clear();
    driver.findElement(By.name("LastName")).sendKeys("Testi");
    //enter email
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).clear();
    driver.findElement(By.name("Email")).sendKeys("monites123@gm.com");
    //enter password
    driver.findElement(By.name("Password")).click();
    driver.findElement(By.name("Password")).clear();
    driver.findElement(By.name("Password")).sendKeys("Monitest123$");
    //enter confirm password
    driver.findElement(By.name("ConfirmPassword")).click();
    driver.findElement(By.name("ConfirmPassword")).clear();
    driver.findElement(By.name("ConfirmPassword")).sendKeys("Monitest123$");
    //click on register-button
    driver.findElement(By.name("register-button")).click();

    //assert: Alert is appeared
    Assert.assertTrue(isAlertAppears());
  }

  public boolean isAlertAppears() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());
    if (alert==null) {
      return false;
    }
    return true;
  }

}