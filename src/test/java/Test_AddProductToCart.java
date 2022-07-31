import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_AddProductToCart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    @Test
    @Order(1)
    public void search_product(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search();
        Assertions.assertTrue(productsPage.isOnProductsPage() ,
                "Not on products page");
    }
    @Test
    @Order(2)
    public void select_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectRandomProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page");
    }
    @Test
    @Order(3)
    public void addToCart(){
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountIncreased(),
                "Product count did not go up");
    }
    @Test
    @Order(4)
    public void goToCart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();

    }
    @Test
    @Order(5)
    public void updateQuantity(){
        cartPage.updateQuantity();
        Assertions.assertTrue(cartPage.checkFeedback(),
                "Page did not give feedback");

    }
    @Test
    @Order(6)
    public void checkIsCartEmpty(){
        cartPage.deleteItems();
      Assertions.assertTrue(cartPage.checkCartIfIsEmpty(),
                "Product could not deleted");
    }

}
