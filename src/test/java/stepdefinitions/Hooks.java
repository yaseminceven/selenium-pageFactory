package stepdefinitions;

import dataProviders.CapabilityFactory;
import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.util.Locale;

public class Hooks {
   public static WebDriver driver;
   private final CapabilityFactory capabilityFactory = new CapabilityFactory();

   @Before
   public void beforeScenario(){
      ConfigFileReader configFileReader = new ConfigFileReader();
      if(configFileReader.getBrowserType().toLowerCase(Locale.ROOT).equals("chrome")){
         driver = WebDriverManager.chromedriver().capabilities(capabilityFactory.getChromeOptions()).create();
      }else if(configFileReader.getBrowserType().toLowerCase(Locale.ROOT).equals("firefox")){
         driver = WebDriverManager.firefoxdriver().capabilities(capabilityFactory.getFirefoxOptions()).create();
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
