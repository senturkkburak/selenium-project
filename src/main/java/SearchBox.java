import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SearchBox extends BasePage{
    By searchBoxLocator=By.id("search-input");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search() {
        File file = new File("src/csvfile/testinium.csv");
        String s="";
        try {
            Scanner sc = new Scanner(file);
            s=sc.next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("search-input")).sendKeys(s,Keys.ENTER);

    }
}
