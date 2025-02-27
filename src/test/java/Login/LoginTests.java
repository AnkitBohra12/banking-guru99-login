/*
 * SS1 - Verify the login Section 
 * Test Case - Enter valid Userid & password
 * Test Steps - 1) Go to http://www.demo.guru99.com/V4/
 * 				2) Enter the valid UserId ( mngr614020 )
 * 				3) Enter the valid Password ( AgAbAsu )
 * 				4) Click Login
 * 				5) verify the output
 * Test Data - UserId Password
 * Expected Result - Login successful 
 * 
 */


package Login;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

	public static void main(String[] args) throws Exception {
		
// Path to the Excel file
        String filePath = "C:\\Users\\Ankit\\Documents\\My WorkSpace\\Banking_Guru99\\TestLoginData.xlsx";
		
        // Load Excel file
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1"); // Get sheet by name
        
		WebDriver driver = new ChromeDriver();
		String BaseURL = "http://www.demo.guru99.com/V4/";
		driver.get(BaseURL);
		driver.manage().window().maximize();
		
// Loop through Excel rows (starting from row 1, skipping headers)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            
//          down code is for String only it can only fatch String from the shit 
          String username = row.getCell(0).getStringCellValue();
          String password = row.getCell(1).getStringCellValue();	
            
            
//          down code can handle both integer and string value as cell value
//            String username = getCellValueAsString(row.getCell(0));
//            String password = getCellValueAsString(row.getCell(1));
            
		
// 		Perform login actions
		driver.findElement(By.name("uid"));	
		driver.findElement(By.xpath("//input[@name='password']"));
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
//		Valid Username and Password
//		userID.sendKeys("mngr614020");
//		pwd.sendKeys("AgAbAsu");
		
			
//		String actual_title = driver.getTitle();
//		
//		if(actual_title.equals("Guru99 Bank Manager HomePage")) {
//			System.out.println("Test Case has been Passed");	
//		}
//		else {
//			System.out.println("Test Case has been Failed");
//		}
		
		 // Close everything
      	
       }
        driver.quit();
        workbook.close();
        fis.close();
	}

}
