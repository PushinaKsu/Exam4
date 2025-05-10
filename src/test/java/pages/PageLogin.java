package pages;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.model.Parameter.Mode.MASKED;

public class PageLogin {
    private final WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод логина: {username}")
    public PageLogin enterUsername(@Param(name = "username") String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        return this;
    }

    @Step("Ввод пароля")
    public PageLogin enterPassword(@Param(name = "password", mode = MASKED) String password
    ) {
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки Login")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }
}
