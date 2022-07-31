import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Stack;

public class HomePage extends BasePage{
    SearchBox searchBox;
    By cartCountLocator = new By.ByCssSelector(".fl[id=\"cart-items\"]");
    By goToCartLocator =new By.ByCssSelector(".button[id=\"js-cart\"]");
    By cartLocator = By.id("cart-items");
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountIncreased() {
       return getCartCount() > 0 ;

    }

    public void goToCart() {
        click(cartLocator);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("mini-cart-info")));
        click(goToCartLocator);

    }
    private int getCartCount(){
        WebDriverWait waitForAdding = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForAdding.until(ExpectedConditions.presenceOfElementLocated(By.id("swal2-title")));
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
