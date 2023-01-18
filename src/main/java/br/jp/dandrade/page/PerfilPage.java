package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class PerfilPage extends BasePage {
	
	public String obterNome() {
		MobileElement nameCard = getDriver().findElement(MobileBy.AccessibilityId("profile-card"));
		return nameCard.findElement(By.xpath("//android.widget.TextView[1]")).getText();
	}
	
	public String obterEmail() {
		MobileElement nameCard = getDriver().findElement(MobileBy.AccessibilityId("profile-card"));
		return  nameCard.findElement(By.xpath("//android.widget.TextView[2]")).getText();
	}

}
