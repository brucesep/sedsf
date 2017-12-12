package pageObj;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alexeya on 01.12.2017.
 */
public class PageObjectMain {

    static SelenideElement newDoc = $(new Selectors.ByText("Новый документ"));
    static ElementsCollection docList = $$(".x-menu-list .x-menu-item-text");

    //общее для документов
    static SelenideElement saveAndExit = $(new Selectors.ByText("Сохранить и закрыть"));
    static SelenideElement submit = $(new Selectors.ByText("OK"));
    static SelenideElement sendDoc = $$(new Selectors.ByText("Отправить")).get(2);
    static SelenideElement sendRepeat = $(new Selectors.ByText("Подписать и Отправить"));
    static SelenideElement closeSending = $(new Selectors.ByText("Закрыть"));
    static SelenideElement sendingStatus = $(new Selectors.ByText("обработка завершена"));
    static SelenideElement kvitantions = $(new Selectors.ByText("Квитанции"));
    static SelenideElement exitKvitWatch = $(new Selectors.ByText("Закрыть"));
    static ElementsCollection listKvitations = $$(".x-panel-body.x-panel-body-noborder");

    public static void sendQvitSchf(String mainLink) {
        //$(new Selectors.ByText("Отправленные")).click();
        $("table.x-grid3-row-table").find(byText(mainLink)).click();
        quitationCheck(1);
        $("table.x-grid3-row-table").find(byText(mainLink)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Подписать и отправить...")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.disappear, 10000);
        $("table.x-grid3-row-table").find(byText(mainLink)).click();
        quitationCheck(3);
    }
    public static void  quitationCheck(int numQ) {
        kvitantions.click();
        $(".x-btn-text.silk-disk").waitUntil(Condition.enabled, 10000);
        $$(listKvitations).last().$$(By.xpath(".//div//table")).shouldHaveSize(numQ);
        exitKvitWatch.click();
    }
    public static void newFormOpen (String docName) {
        newDoc.click();
        $$(docList).findBy(Condition.text(docName)).click();
    }
    public static void savingDoc(){
        saveAndExit.click();
        submit.isDisplayed();
        submit.click();
    }
    public static void sendingDoc() {
        sendDoc.click();
        sendRepeat.isDisplayed();
        sendRepeat.click();
        sendingStatus.waitUntil(Condition.enabled, 100000);
        //sendingStatus.waitUntil(Condition.appear, 10000);
        closeSending.click();
        closeSending.waitUntil(Condition.disappear, 10000);
    }
  }
