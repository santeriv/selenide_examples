package org.selenide.examples.compendiumdev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
  protected WebDriver webDriver;

  public BasePage(WebDriver driver) {
    this.webDriver = driver;
    PageFactory.initElements(webDriver, this);
  }
}