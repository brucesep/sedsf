package pageObj;

import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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
    static SelenideElement kvitantions2 = $$(new Selectors.ByText("Квитанции")).get(1);
    static ElementsCollection exitKvitWatch = $$(new Selectors.ByText("Закрыть"));
    static ElementsCollection listKvitations = $$(".x-panel-body.x-panel-body-noborder");
    static SelenideElement docuList = $("table.x-grid3-row-table");
    static ElementsCollection reloadList = $$(".x-btn-text.x-tbar-loading");
    static SelenideElement outBox = $(new Selectors.ByText("Отправленные"));


    public static void utochSend(String docNn){
        outBox.click();
        $$(reloadList).get(0).click();
        docuList.find(byText(docNn)).click();
        quitationCheck(4,3);
        docuList.find(byText(docNn)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Подписать и отправить...")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.disappear, 15000);
        $$(reloadList).get(0).click();
        docuList.find(byText(docNn)).click();
        quitationCheck(5, 4);
        docuList.find(byText(docNn)).closest("tr").find(byText("Сформировать уточнение")).click();
        String nameOfDoc = $$(".vb-br span").get(0).getText();
        Assert.assertEquals(docNn, nameOfDoc);
    }

    public static void utochZ(String docNn) {
        $$(reloadList).get(1).click();
        $(new Selectors.ByText(docNn)).closest("tr").find(byText("Запросить уточнение")).click();
        $(By.name("msg")).setValue("АВТО уточнение запрошено");
        $$(new Selectors.ByText("Подписать и Отправить")).last().click();
        $$(reloadList).get(1).click();
        $(new Selectors.ByText(docNn)).click();
        quittionChekInbox(6, 5);
    }

    public static void lastQuit(String doccNN) {
        outBox.click();
        $$(reloadList).get(0).click();
        docuList.find(byText(doccNN)).click();
        quitationCheck(3, 2);
    }

    public static void poluchQuitWork(String docN) {
        $(new Selectors.ByText(docN)).waitUntil(Condition.visible, 10000).click();
        $(new Selectors.ByText(docN)).click();
        quittionChekInbox(1, 0);
        $(new Selectors.ByText(docN)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.enabled, 2000).click();
        $(new Selectors.ByText(docN)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Подписать и отправить...")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.disappear, 15000);
        $$(reloadList).get(1).click();
        $(new Selectors.ByText(docN)).click();
        quittionChekInbox(4, 3);
        $$(reloadList).get(1).click();
        $(new Selectors.ByText(docN)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Подписать и отправить...")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.disappear, 15000);
        $$(reloadList).get(1).click();
        $(new Selectors.ByText(docN)).click();
        quittionChekInbox(5, 4);

    }

    public static void quittionChekInbox(int nuQ, int liQ) {
        for (int i = 0; i < 10; i++) {
            kvitantions2.click();
            if ($$(listKvitations).last().$$(By.xpath(".//div//table")).get(liQ).isDisplayed()) {
                $$(listKvitations).last().$$(By.xpath(".//div//table")).shouldHaveSize(nuQ);
                $$(exitKvitWatch).last().click();
                break;
            }
            $$(exitKvitWatch).last().click();
        }
    }

    public static void sendQvitSchf(String mainLink) {
        $$(reloadList).get(0).click();
        //слегка перепишем под универсальный запуск, ибо по удаленке - не срабатывает
        docuList.find(byText(mainLink)).click();
        //$(new Selectors.ByText(mainLink)).click();
        quitationCheck(1, 0);
        $$(reloadList).get(0).click();
        docuList.find(byText(mainLink)).closest("tr").find(byText("Отправить извещение о получении")).click();
        //$(new Selectors.ByText(mainLink)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.enabled, 2000).click();
        docuList.find(byText(mainLink)).closest("tr").find(byText("Отправить извещение о получении")).click();
        //$(new Selectors.ByText(mainLink)).closest("tr").find(byText("Отправить извещение о получении")).click();
        $(new Selectors.ByText("Подписать и отправить...")).click();
        $(new Selectors.ByText("Отмена")).waitUntil(Condition.disappear, 15000);
        $$(reloadList).get(0).click();
        docuList.find(byText(mainLink)).click();
        //$(new Selectors.ByText(mainLink)).click();
        quitationCheck(2, 1);
    }

    public static void quitationCheck(int numQ, int listQ) {
        for (int i = 0; i < 10; i++) {
            kvitantions.click();
            if ($$(listKvitations).last().$$(By.xpath(".//div//table")).get(listQ).isDisplayed()) {
                $$(listKvitations).last().$$(By.xpath(".//div//table")).shouldHaveSize(numQ);
                $$(exitKvitWatch).last().click();
                break;
            }
            $$(exitKvitWatch).last().click();
        }
    }

    public static void newFormOpen(String docName) {
        newDoc.click();
        $$(docList).findBy(Condition.text(docName)).click();
    }

    public static void savingDoc() {
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
