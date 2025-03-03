package Login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BothInvalid {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		String BaseURL = "http://www.demo.guru99.com/V4/";
		driver.get(BaseURL);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("uid")).sendKeys("4651851");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
//		Handling alert 
		Alert alert = driver.switchTo().alert();
//		changing into string
		String alertText = alert.getText();
		alert.accept();
//		validating the alert text
		if(alertText.equals("User or Password is not valid")) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		driver.close();	

	}

}
