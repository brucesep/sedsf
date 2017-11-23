import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;

import org.testng.annotations.*;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


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
    public void createUPD() {

        $(new Selectors.ByText("Новый документ")).click();
        $(By.xpath("//a[span='УПД (ИНФОРМАЦИЯ ПРОДАВЦА)']")).click();
        $(new Selectors.ByText("Новый документ: УПД (ИНФОРМАЦИЯ ПРОДАВЦА)")).isDisplayed();
        $(".x-form-trigger.x-form-arrow-trigger.arrow-n-combo-invalid").click();

    }

}
