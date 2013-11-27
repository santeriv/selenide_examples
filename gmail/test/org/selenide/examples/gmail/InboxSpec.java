package org.selenide.examples.gmail;

import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InboxSpec extends GmailTests {
  @Test
  public void inboxShowsUnreadMessages() {
    $$(byText("Gmail Team")).shouldHave(size(1));
    $$(byText("LastPass")).shouldHave(size(1));
    $$(byText("Pivotal Tracker")).shouldHave(size(3));
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
