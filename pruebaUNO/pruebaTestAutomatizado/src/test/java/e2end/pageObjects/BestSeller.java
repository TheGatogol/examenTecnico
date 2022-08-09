package e2end.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestSeller {

    public static final SelenideElement priceInput = $(byXpath("(//span[@class='a-price-whole'])[1]"));
    public static final SelenideElement addToCartButton = $(byId("add-to-cart-button"));

    public static void addProduct(String nameProduct){
        $(byText(nameProduct)).click();
    }

    public static void validatePrice(String price){
        priceInput.shouldHave(Condition.text(price));
    }

    public static void addToCart(){
        String pngFileName = screenshot("Agrego al carrito");
        addToCartButton.click();
    }
}
