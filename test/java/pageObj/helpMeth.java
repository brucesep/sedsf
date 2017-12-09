package pageObj;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by alexeya on 23.11.2017.
 */
public class helpMeth {

    public static void logOn(String link, String login, String pass) {
        open(link);
        $(By.id("login")).setValue(login);
        $(By.id("password")).setValue(pass);
        $(By.id("loginBtn")).click();
        //на случай, если не было корректного разлогина
        if ($(By.id("pushOutMessage")).isDisplayed()) {
            $(By.name("pushOutMessage")).setValue("Sorry! Automation is trying to work around here!");
            $(By.id("loginBtn")).click();
        }
        $(By.id("comboSelectorId")).should(Condition.visible).click();
        $(new Selectors.ByText("5003106773 Тестов Тест Тестович")).click();
        //$$(".x-combo-list-inner").get(1).click();
        $(new Selectors.ByText("Выбрать")).click();

    }

    public static void logOut() {
        $(new Selectors.ByText("Выход")).click();
        $(new Selectors.ByText("OK")).click();
        $(By.id("login")).isDisplayed();
    }

    public static int randomCount() {
        int max = 999;
        int min = 100;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
