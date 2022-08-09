package e2end.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

public class HomePage {

    public static final SelenideElement bestSellerOption = $(byXpath("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']"));

    public static void enterBestSeller(){
        String pngFileName = screenshot("Ingreso a lo más vendido");
        bestSellerOption.click();
    }

}


