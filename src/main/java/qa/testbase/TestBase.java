package qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public TestBase(){
		
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationFrameworkBatchOct\\src\\main\\java\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void initilization() {
		String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else {
			System.out.println("Please select valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("website"));
	}
}
