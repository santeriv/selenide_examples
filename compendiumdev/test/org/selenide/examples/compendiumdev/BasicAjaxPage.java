package org.selenide.examples.compendiumdev;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class BasicAjaxPage extends BasePage {
  @FindBy(id = "combo")
  private WebElement categoryDrpdwn;
  @FindBy(id = "combo2")
  private WebElement languageDrpdwn;
  @FindBy(id = "lteq30")
  private WebElement values;
  @FindBy(name = "submitbutton")
  private WebElement codeInItBtn;

  public void chooseJava() {
//    $(categoryDrpdwn).click(); //selectOption("Serv");
    $(categoryDrpdwn).selectOption("Serv");
    $(languageDrpdwn).shouldHave(Condition.hasText("Cobol")).selectOption("Cobol");
    $(values).setValue("1");
    $(codeInItBtn).click();
  }

  public BasicAjaxPage(WebDriver driver) {
    super(driver);
  }
}