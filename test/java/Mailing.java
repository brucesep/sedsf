
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pageObj.PageObjectMain;
import pageObj.PageObjectUpd;
import pageObj.helpMeth;


public class Mailing {

    @BeforeTest
    public void setupTest() {
        Configuration.fastSetValue = true;
        helpMeth.logOn("http://sf2abukk.comita.lan:8080/ccwe/", "GreyKnights", "gfhjkmnhb");
    }

    @AfterTest
    public void tearDown() {
        helpMeth.logOut();
    }

    @Test
    public void createUpdScfMin() {
        PageObjectMain.newFormOpen("УПД");
        PageObjectUpd.chooseFunction("счет-фактура, применяемый при расчетах по налогу на добавленную стоимость");
        PageObjectUpd.fillSchfMinimum("АВТО СЧФ 1000/", 0);
        PageObjectUpd.podpisant();
        PageObjectUpd.fillTable();
        //PageObjectMain.savingDoc();
        PageObjectMain.sendingDoc();
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

