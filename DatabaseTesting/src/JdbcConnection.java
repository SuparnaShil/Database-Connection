import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium file\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=eu");
		
		String host="localhost";
		String port="3306";
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/qadb", "root", "root");
		Statement s= con.createStatement();
		ResultSet res =s.executeQuery("select * from employee where id='1'");
		
		while(res.next())
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(res.getString("name")); 
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(res.getString("location"));
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			//System.out.println(res.getString("name"));
			//System.out.println(res.getString("location"));
		}
	}

}
