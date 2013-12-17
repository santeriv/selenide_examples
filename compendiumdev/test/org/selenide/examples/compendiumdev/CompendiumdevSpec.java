package org.selenide.examples.compendiumdev;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CompendiumdevSpec extends AbstractTest {
  private static final By categoryDrpdwn = By.name("id");
  private static final By languageDrpdwn = By.name("language_id");

  @Test
  public void chooseJava(){
    $(categoryDrpdwn).selectOption("Server");
//    System.out.println($(languageDrpdwn).find(withText("Java")));
    $(languageDrpdwn).shouldHave(text("Java")).selectOption("Java");
  }

  @Override
  protected String getUrl() {
    return "/basic_ajax.html";
  }
}
