package e2end.steps;

import com.codeborne.selenide.logevents.SelenideLogger;
import e2end.pageObjects.AddToCart;
import e2end.pageObjects.BestSeller;
import e2end.pageObjects.HomePage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import e2end.pageObjects.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class commonsStepsDefinitions {

    @Given("Entro a Amazon")
    public void entroAAmazon () {
        open("https://www.amazon.com.mx/");
    }

    @Given("entro a los mas vendidos")
    public void entroALosMasVendidos() {
        HomePage.enterBestSeller();
    }

    @When("agrego el producto y lo valido")
    public void agregoElProductoYLovalido(List<List<String>> bestSeller){
        BestSeller.addProduct(bestSeller.get(0).get(0));
        BestSeller.validatePrice(bestSeller.get(0).get(1));
        BestSeller.addToCart();
        String pngFileName = screenshot("Agregar al carrito");
    }

    @And("valido el carrito")
    public void validoElCarrito(List<List<String>> addToCart){
        AddToCart.enterCart();
        AddToCart.cartValidate(addToCart.get(0).get(0));
        AddToCart.cartValidateNotHave(addToCart.get(0).get(1));
        AddToCart.goCheckout();
        String pngFileName = screenshot("Checokut Amazon");
    }

}


