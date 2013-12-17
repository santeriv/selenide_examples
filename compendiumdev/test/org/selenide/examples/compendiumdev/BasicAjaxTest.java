package org.selenide.examples.compendiumdev;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ ScreenShooter.class})
public class BasicAjaxTest extends AbstractTest {
  @Test
  public void verifyBasicAjax() {
    BasicAjaxPage basicAjaxPage = new BasicAjaxPage(getWebdriver());

    basicAjaxPage.chooseJava();

  }
  @Override
  protected String getUrl(){
    return "/basic_ajax.html";
  }

}