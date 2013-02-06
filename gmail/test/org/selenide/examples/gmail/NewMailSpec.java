package org.selenide.examples.gmail;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DOM.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;

public class NewMailSpec extends GmailTests {
  @Test
  public void userCanComposeEmail() {
    $(byText("COMPOSE")).click();
    $(By.name("to")).val("andrei.solntsev@gmail.com");
    $(By.name("subject")).val("Agile Saturday test!");

    switchTo().frame($(".editable").toWebElement());

    $("body").val("Hello braza!").pressEnter();

    switchTo().defaultContent();
    $(byText("Send")).click();

    $(withText("Your message has been sent.")).shouldBe(visible);
    $(byText("Undo")).click();
    $(byText("Sending has been undone.")).should(appear);

    $(".editable").should(appear);
    switchTo().frame($(By.className("editable")).toWebElement());
    $("body").append("This is Agile Saturday").pressEnter();

    switchTo().defaultContent();
    $(byText("Send")).click();
    $(withText("Your message has been sent.")).should(appear);
    waitUntil(byText("Undo"), disappears, 12000);

    assertUserCanSeeSentEmails();
  }

  private void assertUserCanSeeSentEmails() {
    $(byText("Sent Mail")).click();
    $(byText("Agile Saturday test!")).shouldBe(visible);
  }
}
