package org.selenide.examples.gmail;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DOM.$;
import static com.codeborne.selenide.Navigation.baseUrl;
import static com.codeborne.selenide.Navigation.open;
import static com.codeborne.selenide.Selectors.byText;

public abstract class GmailTests {
  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    baseUrl = "http://gmail.com";
    open("/");
    login();

    $(byText("Inbox (11)")).shouldBe(visible);
  }

  @AfterClass
  public static void logout() {
    $(byText("Sign out")).click();
  }

  private static void login() {
    $("#Email").type("drusha49@gmail.com");
    $("#Passwd").type(System.getProperty("password"));
    $("#signIn").click();
  }
}
