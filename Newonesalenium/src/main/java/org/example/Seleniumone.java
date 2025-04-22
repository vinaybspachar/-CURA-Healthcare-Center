package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Seleniumone {


     public void bookAppointment() {


        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement Makeapp = driver.findElement(By.id("btn-make-appointment"));
        Makeapp.click();

        WebElement Username = driver.findElement(By.xpath("//input[@id='txt-username']"));
                Username.sendKeys("John Doe");

        WebElement Pass = driver.findElement(By.xpath("//input[@id='txt-password']"));
         Pass.sendKeys("ThisIsNotAPassword");


         WebElement Button = driver.findElement(By.id("btn-login"));
         Button.click();


        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException | TimeoutException e) {
            System.out.println("No alert was present.");
        }


        WebElement dropdown = driver.findElement(By.id("combo_facility"));

        Select select = new Select(dropdown);
        select.selectByValue("Hongkong CURA Healthcare Center");

        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();

        WebElement checkbox1 = driver.findElement(By.id("radio_program_medicaid"));
        checkbox1.click();
        WebElement cal = driver.findElement(By.xpath("//div[@class='input-group-addon']"));
        cal.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("tbody tr:nth-child(5) td:nth-child(4)")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("headache and back pain");

        driver.findElement(By.id("btn-book-appointment")).click();

         driver.findElement(By.id("menu-toggle")).click();
         driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(4) > a")).click();

         TakesScreenshot ts = (TakesScreenshot) driver;

         File src = ts.getScreenshotAs(OutputType.FILE);

         String hospital = "Apollo"; // Or pass as method parameter

         File dest = new File("src/main/resources/" + hospital + ".png");

         try {
             FileHandler.copy(src, dest);
             System.out.println("Screenshot saved to: " + dest.getAbsolutePath());
         } catch (IOException e) {
             e.printStackTrace();
         }



         //driver.quit();
    }
}
