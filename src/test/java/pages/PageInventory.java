package pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageInventory {
    private final WebDriver driver;

    public PageInventory(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Убедиться, что открылась страница Inventory")
    public void verifyOnInventoryPage() {
        Assertions.assertTrue(
                driver.getCurrentUrl().endsWith("/inventory.html"),
                "Ожидали /inventory.html, но были на " + driver.getCurrentUrl()
        );
    }
    @Step("Добавление в корзину: {productName}")
    public PageInventory addToCart(String productName) {
        String id = switch (productName) {
            case "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack";
            case "Sauce Labs Bolt T-Shirt" -> "add-to-cart-sauce-labs-bolt-t-shirt";
            case "Sauce Labs Onesie" -> "add-to-cart-sauce-labs-onesie";
            default -> throw new IllegalArgumentException("Неизвестный товар: " + productName);
        };
        driver.findElement(By.id(id)).click();
        return this;
    }

    @Step("Переход в корзину")
    public void goToCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
}