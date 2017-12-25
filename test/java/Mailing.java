
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pageObj.PageObjectMain;
import pageObj.PageObjectUpd;
import pageObj.helpMeth;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Mailing {

    @BeforeTest
    public void setupTest() {
        Configuration.fastSetValue = true;
        helpMeth.logOn(2, "http://sf2abukk.comita.lan:8080/ccwe/", "GreyKnights", "gfhjkmnhb");
        //helpMeth.logOn(1, "http://sf2abukk.comita.lan:8080/ccwe/", "Ultramar", "gfhjkmnhb");
    }

    @AfterTest
    public void tearDown() {
        helpMeth.logOut();
    }

    @Test(enabled = true)
    public void createUpdScfMin() {
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("счет-фактура, применяемый при расчетах по налогу на добавленную стоимость");
        PageObjectUpd.fillSchfMinimum("АВТО СЧФ 1000/", 0);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillTable();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
        SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
        String docNumer = "СЧФ (информация продавца) №" + PageObjectUpd.nomerDocuma + " от " + dF.format(new Date());
        //проверка квитанций у отправителя
        PageObjectMain.sendQvitSchf(docNumer);
        helpMeth.logOut();
        helpMeth.logOn(1, "http://sf2abukk.comita.lan:8080/ccwe/", "Ultramar", "gfhjkmnhb");
        //проверка квитанций у получателя
        PageObjectMain.poluchQuitWork(docNumer);
        helpMeth.logOut();
        helpMeth.logOn(2, "http://sf2abukk.comita.lan:8080/ccwe/", "GreyKnights", "gfhjkmnhb");
        //последняя проверка квитанций
        PageObjectMain.lastQuit(docNumer);
        helpMeth.logOut();
        //сюда засунем создание уточнялки
        helpMeth.logOn(1, "http://sf2abukk.comita.lan:8080/ccwe/", "Ultramar", "gfhjkmnhb");
        PageObjectMain.utochZ(docNumer);
        helpMeth.logOut();
        helpMeth.logOn(2, "http://sf2abukk.comita.lan:8080/ccwe/", "GreyKnights", "gfhjkmnhb");
        PageObjectMain.utochSend(docNumer);

    }
    @Test(enabled = false)
    public void helping() {
        PageObjectMain.poluchQuitWork("СЧФ (информация продавца) №АВТО СЧФ 1000/ 832 от 14-12-2017");
    }

    @Test(enabled = false)
    public void createUpdSchfMax() {
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("счет-фактура, применяемый при расчетах по налогу на добавленную стоимость");
        PageObjectUpd.fillSchfMinimum("АВТО СЧФ 1000/", 0);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillAnotherPoles();
        PageObjectUpd.fillTableFull();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
    }

    @Test(enabled = false)
    public void createSchfDopMin() {
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("счет-фактура, применяемый при расчетах по налогу на добавленную стоимость, и документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)");
        PageObjectUpd.fillSchfMinimum("АВТО СЧФДОП 2000/", 1);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillTable();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
    }

    @Test(enabled = false)
    public void createSchfDopMax(){
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("счет-фактура, применяемый при расчетах по налогу на добавленную стоимость, и документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)");
        PageObjectUpd.fillSchfMinimum("АВТО СЧФДОП 2000/", 1);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillAnotherPoles();
        PageObjectUpd.podpisant();
        //PageObjectUpd.fillTableFull();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
    }

    @Test(enabled = false)
    public void createDisMin() {
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)");
        PageObjectUpd.fillSchfMinimum("АВТО ДИС 3000/", 1);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillTable();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
    }
    @Test(enabled = false)
    public void createDisMax(){
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)");
        PageObjectUpd.fillSchfMinimum("АВТО ДИС 3000/", 1);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillAnotherPoles();
        PageObjectUpd.podpisant();
        //PageObjectUpd.fillTableFull();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
    }
}

