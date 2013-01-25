package org.selenide.examples.gmail;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DOM.$;
import static com.codeborne.selenide.DOM.$$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static org.junit.Assert.assertEquals;

public class InboxSpec extends GmailTests {
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
}
