package org.selenide.examples.compendiumdev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.BrowserPerClass;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ScreenShooter.class, BrowserPerClass.class})
public class AbstractTest {
  private WebDriver driver;

  public WebDriver getWebdriver() {
    if (driver == null) {
      driver = new FirefoxDriver();
    }
    return driver;
  }

  @BeforeMethod
  public void SetUp() {

    WebDriverRunner.setWebDriver(getWebdriver());
    Configuration.timeout = 4000;
    getWebdriver().get("http://compendiumdev.co.uk/selenium" + getUrl());
  }

  protected String getUrl() {
    return "/";
  }
}