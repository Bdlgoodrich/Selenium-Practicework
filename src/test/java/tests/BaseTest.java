package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

	private WebDriver driver;
	protected final String contactDataLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\jsonData\\contactDetails.json";
	protected final String existingUserLoginInfoLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\jsonData\\existingUserLoginData.json";
	protected final String newUserLoginDataLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\jsonData\\newUserLoginData.json";
	protected final String incorrectUserLoginDataLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\jsonData\\incorrectUserLoginData.json";

	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-notifications");
//		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap (String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//testcasename.png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//testcasename.png";
	}

}
