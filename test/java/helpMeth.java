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
        //$(By.id("login")).setValue("LittleCreator");
        $(By.id("password")).setValue(pass);
        $(By.id("loginBtn")).click();

        if ($(By.id("pushOutMessage")).isDisplayed()) {
            $(By.id("loginBtn")).click();
        }

        $(By.id("comboSelectorId")).should(Condition.visible).click();
        $(new Selectors.ByText("5003106773 Тестов Тест Тестович")).click();
        $(new Selectors.ByText("Выбрать")).click();
    }

    public static void logOut(){
        $(By.xpath("//button[span='Выход']")).click();
        $(new Selectors.ByText("OK")).click();
        $(By.id("login")).isDisplayed();
    }
}
