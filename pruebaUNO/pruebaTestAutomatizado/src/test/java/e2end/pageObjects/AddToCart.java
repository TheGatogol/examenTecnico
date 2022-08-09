package e2end.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AddToCart {

    public static final SelenideElement cartButton = $(byXpath("(//span[@class='nav-line-2'])[2]"));
    public static final SelenideElement priceTotalInput = $(By.cssSelector("body.a-m-mx.a-aui_72554-c.a-aui_accordion_a11y_role_354025-c.a-aui_killswitch_csa_logger_372963-c.a-aui_launch_2021_ally_fixes_392482-c.a-aui_pci_risk_banner_210084-c.a-aui_preload_261698-c.a-aui_rel_noreferrer_noopener_309527-c.a-aui_template_weblab_cache_333406-c.a-aui_tnr_v2_180836-c.a-meter-animate:nth-child(2) div.a-container.sc-background-dark:nth-child(30) div.a-section.a-spacing-none:nth-child(4) div.a-fixed-right-flipped-grid:nth-child(4) div.a-fixed-right-grid-inner div.a-fixed-right-grid-col.a-col-right:nth-child(1) div.a-cardui.sc-card-style.sc-java-remote-feature.celwidget.sc-card-spacing-top-none div.a-cardui-body.a-scroller-none div.a-box-group.sc-buy-box-group:nth-child(1) div.a-section.sc-buy-box-inner-box:nth-child(3) div.a-row.a-spacing-mini.sc-subtotal.sc-subtotal-buybox.sc-java-remote-feature:nth-child(1) span.a-color-price.sc-price-container.a-text-bold > span.a-size-medium.a-color-base.sc-price.sc-white-space-nowrap"));

    public static final SelenideElement checkoutButton = $(By.xpath("//input[contains(@data-feature-id,'proceed-to-checkout-action')]"));

    public static void enterCart(){
        cartButton.click();
    }
    public static void cartValidate(String priceTotal){
        priceTotalInput.shouldHave(Condition.text(priceTotal));
    }
    public static void cartValidateNotHave(String priceTotalNotHave){
        priceTotalInput.shouldNotHave(Condition.text(priceTotalNotHave));
        String pngFileName = screenshot("Valido carrito");
    }
    public static void goCheckout(){
        checkoutButton.click();
        String pngFileName = screenshot("Finalizo proceso");
    }
}
