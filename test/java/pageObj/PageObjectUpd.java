package pageObj;

import com.codeborne.selenide.*;
import org.bouncycastle.crypto.kems.ECIESKeyEncapsulation;
import org.openqa.selenium.By;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by alexeya on 01.12.2017.
 */
public class PageObjectUpd {

    static SelenideElement header = $(new Selectors.ByText("Новый документ: УПД"));
    static SelenideElement functionChoose = $(".x-form-trigger.x-form-arrow-trigger.arrow-n-combo-invalid");
    static ElementsCollection functionList = $$(".x-combo-list-inner div");
    static SelenideElement naimPervDoc = $(By.name("document.nameFirstDoc"));
    static SelenideElement osnEconSub = $(By.name("document.senderTrust"));
    static SelenideElement documNumb = $(By.name("document.documentInfo.numberDoc"));
    static SelenideElement korrektirovka = $(By.name("CORRECT"));
    static SelenideElement ispravlenieNum = $(By.name("document.documentInfo.correctSf.numberCorSf"));
    static SelenideElement selectOnZhe = $(By.name("document.documentInfo.cargoSender.cargoAsSeller"));
    static ElementsCollection chooseMassive = $$(new Selectors.ByText("Выбрать.."));
    static SelenideElement deselectGruzopol = $(By.name("isReceiver"));
    static ElementsCollection platDoc = $$(".x-grid3-row.x-grid3-row-first.x-grid3-row-last");
    static SelenideElement idGosKontr1 = $(By.name("document.documentInfo.dopInfoHozLive.idGOSContract"));
    static SelenideElement currencyFirst = $(By.name("document.documentInfo.dopInfoHozLive.nameCurrent"));
    static SelenideElement currencyCourceFirst = $(By.name("document.documentInfo.dopInfoHozLive.courseCurrent"));
    static SelenideElement infoPoleFhzOne = $(new Selectors.ByText("Информационное поле факта хозяйственной жизни 1"));
    static SelenideElement idFileInfoPole = $(By.name("document.documentInfo.infoFieldHozLive.idFileInfoField"));
    static SelenideElement currencyReqvire = $(By.id("comboCurrencyId"));
    static SelenideElement mainTable = $(new Selectors.ByText("18%"));
    static SelenideElement soderzhFhz3 = $(By.name("isInfoHoz3Panel"));
    static SelenideElement soderzhOperation = $(By.name("document.infoHozLive.infoHoz.infoOper"));
    static SelenideElement vidOperation = $(By.name("document.infoHozLive.infoHoz.typeOper"));
    static SelenideElement dateOtgrTovarov = $(By.name("document.infoHozLive.infoHoz.date"));
    static SelenideElement svedTransAndCargo = $(By.name("document.infoHozLive.infoHoz.transportCargo.infoCargo"));
    static SelenideElement datePeredachiVeschi = $(By.name("document.infoHozLive.infoHoz.infoTransferItem.dateTransfer"));
    static SelenideElement svedeniaPeredachi = $(By.name("document.infoHozLive.infoHoz.infoTransferItem.infoTransfer"));
    static SelenideElement getInfoPoleFhzThree = $(new Selectors.ByText("Информационное поле факта хозяйственной жизни 3"));
    static SelenideElement idInfoFhz3 = $(By.name("document.infoHozLive.infoFieldHozLive.idFileInfoField"));
    //таблица для ФХЖ3 бла-бла-бла
    static ElementsCollection plusSymbol = $$(By.xpath("//img[@src='icons/famfam/add.png']"));
    static SelenideElement podpisant = $(new Selectors.ByText("Тестов"));
    static SelenideElement podpisantChoose = $(new Selectors.ByText("Выбрать"));
    static SelenideElement textAreaInput = $(".x-form-textarea.x-form-field.textarea-n-style.x-form-focus");
    static SelenideElement textFieldInput = $(".x-form-text.textfield-n-style.x-form-focus");

    //Теперь подтаблицы
    //Грузополучатель
    static SelenideElement waitingTablePoluch = $(new Selectors.ByText("Получатели"));
    static SelenideElement kontragentPoluch = $(new Selectors.ByText("576771279"));
    static SelenideElement buttonOk = $(new Selectors.ByText("ОК"));
    //Таблица грузополучателей-отправителей с фамилиями
    static SelenideElement waitingAnotherTable = $(new Selectors.ByText("Реквизиты грузоотправителей и грузополучателей"));
    static SelenideElement buttonChoise = $(new Selectors.ByText("Выбрать"));
    //Собсвенно товары
    static SelenideElement autoCount = $(new Selectors.ByText("Автоподсчет суммы"));
    static ElementsCollection upDownMenuClick = $$(By.cssSelector(".x-form-element div img"));
    static ElementsCollection upDownMenuElement = $$(By.cssSelector(".x-combo-list-inner"));
    static SelenideElement edinicaHand = $(By.name("dopInfoProduct.measure"));
    static SelenideElement priznakDopInfo = $(By.name("dopInfoProduct.dopInfoType"));
    static SelenideElement charaterCodeArticul = $(By.name("dopInfoProduct.codeTov"));
    static SelenideElement productName = $(By.name("nameProduct"));
    static SelenideElement countProduct = $(By.name("countProduct"));
    static SelenideElement priceWithNDS = $(By.name("priceWithNDS"));
    static SelenideElement akchizTax = $(By.name("excise.tax"));
    static SelenideElement kolichOtpustit = $(By.name("dopInfoProduct.contSend"));
    static SelenideElement korrDebet = $(By.name("dopInfoProduct.debet"));
    static SelenideElement korrKredit = $(By.name("dopInfoProduct.credit"));
    static SelenideElement savingCargo = $(new Selectors.ByText("Сохранить"));
    static ElementsCollection dateField = $$(".x-form-trigger.triger-date-n-style");
    static ElementsCollection dateDate = $$(".x-date-active.x-date-today.x-date-selected");
    static ElementsCollection unselectIdentif = $$(".x-grid3-cell-inner.x-grid3-col-CODE.x-unselectable");

    public static String nomerDocuma;


    //пошли методы для заполнения полей.
    public static void fillAnotherPoles() {
        korrektirovka.click();
        ispravlenieNum.setValue("12");
        $$(dateField).get(1).click();
        $$(dateDate).get(0).click();
        selectOnZhe.click();
        deselectGruzopol.click();
        $$(chooseMassive).get(1).click();
        waitingAnotherTable.isDisplayed();
        $(new Selectors.ByText("Тестовое")).click();
        buttonChoise.click();
        $$(chooseMassive).get(2).click();
        waitingAnotherTable.isDisplayed();
        $(new Selectors.ByText("АОЗТ \"Никодим и сыновья\"")).click();
        buttonChoise.click();
        $$(platDoc).get(0).$(".x-grid3-cell-inner.x-grid3-col-1.x-unselectable").click();
        $(".x-form-text.x-form-field.x-form-invalid.x-form-focus").setValue("АВТО пладт.док № 11");
        $(".x-grid3-col.x-grid3-cell.x-grid3-td-2.x-grid3-cell-last").doubleClick();
        $$(dateField).get(2).click();
        $$(dateDate).get(1).click();
        idGosKontr1.setValue("АВТО 123 госконтр");
        $(By.cssSelector(".x-form-element.no-margin-left div img")).click();
        $$(upDownMenuElement).get(2).$$(By.cssSelector("div")).get(0).click();
        currencyCourceFirst.setValue("33.12");
        infoPoleFhzOne.click();
        idFileInfoPole.setValue("111112222222333333333333444444444444");
        $$(unselectIdentif).get(0).click();
        $$(".x-layer.x-editor.x-small-editor.x-grid-editor").get(2).$(".x-form-text.x-form-field.x-form-focus").setValue("АВТО идентификатор ФХЖ1");
        $$(".x-grid3-cell-inner.x-grid3-col-VALUE.x-unselectable").get(0).doubleClick();
        textAreaInput.setValue("АВТО значение идентификатора ФХЖ 1");
        //Для СЧФ заполняем, для СЧФДОП и ДИС заполняем сразу
        soderzhFhz3.click();
        soderzhOperation.setValue("АВТО Содержание операции");
        vidOperation.setValue("АВТО вид операции ");
        $$(dateField).get(3).click();
        $$(dateDate).get(2).click();
        $(".x-grid3-cell-inner.x-grid3-col-name.x-unselectable").hover().doubleClick();
        textFieldInput.setValue("АВТО наим.док.осн.");
        $(".x-grid3-cell-inner.x-grid3-col-number.x-unselectable").doubleClick();
        textFieldInput.setValue("АВТО 001/10");
        $(".x-grid3-cell-inner.x-grid3-col-date.x-unselectable").doubleClick();
        $$(dateField).get(4).click();
        $$(dateDate).get(3).click();
        $(".x-grid3-cell-inner.x-grid3-col-info.x-unselectable").doubleClick();
        textAreaInput.setValue("АВТО доп. сведения");
        $$(chooseMassive).get(3).click();
        $(new Selectors.ByText("Довереннов")).click();
        buttonChoise.click();
        $(".x-grid3-cell-inner.x-grid3-col-numberInvoice.x-unselectable").hover().doubleClick();
        textFieldInput.setValue("АВТО номтранснакл");
        $(".x-grid3-col.x-grid3-cell.x-grid3-td-dateInvoice.x-grid3-cell-last").doubleClick();
        $$(dateField).get(5).click();
        $$(dateDate).get(4).click();
        $$(chooseMassive).get(4).click();
        $(new Selectors.ByText("Фамилиев")).click();
        buttonChoise.click();
        svedTransAndCargo.setValue("АВТО транспортировка и груз");
        $$(dateField).get(6).click();
        $$(dateDate).get(5).click();
        svedeniaPeredachi.setValue("АВТО сведения о передаче");
        getInfoPoleFhzThree.click();
        idInfoFhz3.setValue("111112222222333333333333444444444444");
        $$(unselectIdentif).get(1).hover().doubleClick();
        $(".x-form-text.x-form-field.x-form-focus").setValue("АВТО идентификатор ФХЖ3");
        $$(".x-grid3-cell-inner.x-grid3-col-VALUE.x-unselectable").get(1).doubleClick();
        textAreaInput.setValue("АВТО значение ФХЗ3");
    }
    public static void fillTableFull(){
        mainTable.doubleClick();
        autoCount.click();
        $$(upDownMenuClick).get(7).click();
        $$(upDownMenuElement).get(3).$$(By.cssSelector("div")).get(26).click();
        edinicaHand.click();
        edinicaHand.setValue("АВТО установлено вручную");
        $$(upDownMenuClick).get(6).click();
        $$(upDownMenuElement).get(4).$$(By.cssSelector("div")).get(0).click();
        priznakDopInfo.setValue("1010");
        charaterCodeArticul.setValue("АВТО характеристика/код");
        productName.setValue("АВТО. Наименование продукта.");
        countProduct.clear();
        countProduct.setValue("124");
        priceWithNDS.clear();
        priceWithNDS.setValue("25000");
        countProduct.click();
        akchizTax.clear();
        akchizTax.setValue("125");
        kolichOtpustit.setValue("11");
        korrDebet.setValue("123456789");
        korrKredit.setValue("987654321");
        $(".x-grid3-cell-inner.x-grid3-col-codeCountry.x-unselectable").click();
        Configuration.fastSetValue = false;
        $(".x-form-text.combo-n-style.x-form-focus").setValue("рос").click();
        $(new Selectors.ByText("643 РОССИЯ")).isDisplayed();
        $(new Selectors.ByText("643 РОССИЯ")).click();
        Configuration.fastSetValue = true;
        $(".x-grid3-cell-inner.x-grid3-col-numberTamozhDeclaration.x-unselectable").doubleClick();
        //$$(".x-form-text.x-form-field").get(8).setValue("АВТО РНТД");
        $(".x-form-text.x-form-field.x-form-focus").setValue("АВТО РНТД");
        $$(unselectIdentif).get(2).click();
        $$(unselectIdentif).get(2).click();
        $(".x-form-text.x-form-field.x-form-focus").setValue("АВТО идентиф ФХЖ2");
        $$(".x-grid3-cell-inner.x-grid3-col-VALUE.x-unselectable").get(2).click();
        $(".x-form-textarea.x-form-field.textarea-n-style.x-form-focus").setValue("АВТО значение идентификатора ФХЖ 2");
        savingCargo.click();
    }
    public static void fillTable(){
        mainTable.doubleClick();
        autoCount.click();
        productName.setValue("АВТО. Наименование продукта.");
        $$(upDownMenuClick).get(7).click();
        $$(upDownMenuElement).get(2).$$(By.cssSelector("div")).get(34).click();
        countProduct.clear();
        countProduct.setValue("124");
        priceWithNDS.clear();
        priceWithNDS.setValue("25000");
        countProduct.click();
        savingCargo.click();
    }
    public static String fillSchfMinimum(String nomer, int val) {
        osnEconSub.setValue("АВТО ПРОВЕРКА основания составителя");
        nomerDocuma = nomer + " " + helpMeth.randomCount();
        documNumb.setValue(nomerDocuma);
        selectOnZhe.click();
        $$(chooseMassive).get(0).click();
        waitingTablePoluch.isDisplayed();
        kontragentPoluch.click();
        buttonOk.click();
        $$(upDownMenuClick).get(3).click();
        $$(upDownMenuElement).get(1).$$(By.cssSelector("div")).get(0).click();
        if (val != 0){
            soderzhOperation.setValue("АВТО Содержание операции");
        }
        return nomerDocuma;
    }
    public static void podpisant(){
        $$(plusSymbol).get(6).click();
        podpisant.click();
        podpisantChoose.click();
    }

    public static void chooseFunction (String function){
        header.isDisplayed();
        functionChoose.click();
        $$(functionList).findBy(Condition.text(function)).click();
    }

}
