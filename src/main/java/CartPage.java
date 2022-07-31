import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{
    By cartCountLocator = new By.ByCssSelector(".fl[id=\"cart-items\"]");
    By updateButtonLocator = By.className("fa-refresh");
    By deleteButtonLocator = new By.ByCssSelector("i.red-icon");
    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void updateQuantity() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement quantity=driver.findElement(By.name("quantity"));
        quantity.clear();
        quantity.sendKeys("2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click(updateButtonLocator);

    }

    public boolean checkFeedback() {
        WebDriverWait feedbackWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        feedbackWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.swal2-header")));
        return true;
    }

    public void deleteItems() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriverWait deleteWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        deleteWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.red-icon")));
        click(deleteButtonLocator);

    }

    public boolean checkCartIfIsEmpty() {
        WebDriverWait deleteFeedback = new WebDriverWait(driver, Duration.ofSeconds(5));
        deleteFeedback.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.ky-swal-popup-success")));
        return isDisplayed(By.cssSelector("div.ky-swal-popup-success"));
    }
}
