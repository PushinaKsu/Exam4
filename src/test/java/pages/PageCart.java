package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageCart {
    private final WebDriver driver;

    public PageCart(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что в корзине {expectedCount} товара(ов)")
    public PageCart verifyItemsInCart(int expectedCount) {
        int actualCount = driver.findElements(By.xpath("//div[@class='cart_item']")).size();
        Assertions.assertEquals(expectedCount, actualCount, "Неверное количество товаров в корзине");
        return this;
    }

    @Step("Нажатие кнопки Checkout")
    public PageCheckout clickCheckout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        return new PageCheckout(driver);
    }
}