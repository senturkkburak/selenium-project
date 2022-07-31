import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By listedItemsLocator = By.id("faceted-search-list-total");
    By productSelectLocator = By.className("pr-img-link");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    
    public void selectRandomProduct() {
        int random = (int) (Math.random()*(getAllProducts().size()-1));
        getAllProducts().get(random).click();
    }
    private List<WebElement> getAllProducts(){
        return findAll(productSelectLocator);
    }

    public boolean isOnProductsPage() {
        return isDisplayed(listedItemsLocator);

    }
}
