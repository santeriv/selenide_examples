package org.selenide.examples.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RepositoryPage {
  public void openSource(String path) {
//    $(By.xpath("//td[contains(@class,'content')]//a[text()='" + path + "']")).click();

    $$("td.content").findBy(text(path)).find("a").followLink();
  }

  public SelenideElement getSourceLines() {
    return $(".file-code");
  }
}
