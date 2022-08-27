package stepdefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Locale;

public class Hooks {
   public static WebDriver driver;

   @Before
   public void beforeScenario(){
      ConfigFileReader configFileReader = new ConfigFileReader();
      if(configFileReader.getBrowserType().toLowerCase(Locale.ROOT).equals("chrome")){
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--incognito");
         options.addArguments("start-maximized");
         driver = new ChromeDriver(options);
      }else if(configFileReader.getBrowserType().toLowerCase(Locale.ROOT).equals("firefox")){
         WebDriverManager.firefoxdriver().setup();
         FirefoxOptions options = new FirefoxOptions();
         options.addArguments("-private");
         driver = new FirefoxDriver(options);
         driver.manage().window().maximize();
      }
      driver.get(configFileReader.getApplicationUrl());
   }

   @After
   public void afterScenario(){
      driver.close();
      driver.quit();
   }
}
