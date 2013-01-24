package org.selenide.examples.gmail;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DOM.$;
import static com.codeborne.selenide.DOM.$$;
import static com.codeborne.selenide.Navigation.baseUrl;
import static com.codeborne.selenide.Navigation.open;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static org.junit.Assert.assertEquals;

public class InboxSpec {
  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    baseUrl = "http://gmail.com";
    open("/");
    login();

    $(byText("Inbox (11)")).shouldBe(visible);
  }

  @Test
  public void inboxShowsUnreadMessages() {
    assertEquals($$(byText("Google+ team")).size(), 5);
    assertEquals($$(byText("LastPass")).size(), 2);
    assertEquals($$(byText("Pivotal Tracker")).size(), 5);

    assertEquals($$(byText("Top 3 posts for you on Google+ this week")).size(), 4);
  }

  @Test
  public void googlePlusNotificationsAreShownInTopRightCorner() {
    $(byAttribute("title", "Notifications")).shouldHave(text("3"));
  }

  @Test
  public void userCanRefreshMessages() {
    $(byAttribute("title", "Refresh")).click();
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
