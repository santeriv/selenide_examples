package org.selenide.examples.gmail;

import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InboxSpec extends GmailTests {
  @Test
  public void inboxShowsUnreadMessages() {
    $$(byText("Google+ team")).shouldHaveSize(6);
    $$(byText("LastPass")).shouldHaveSize(2);
    $$(byText("Pivotal Tracker")).shouldHaveSize(5);

    $$(byText("Top 3 posts for you on Google+ this week")).shouldHaveSize(4);
  }

  @Test @Ignore  // seems that it was removed in latest Gmail UI
  public void googlePlusNotificationsAreShownInTopRightCorner() {
    $(by("title", "Notifications")).shouldHave(text("3"));
  }

  @Test
  public void userCanRefreshMessages() {
    $(by("title", "Refresh")).click();
  }
}
