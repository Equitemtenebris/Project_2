package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    // Локаторы для элементов формы заказа
    private By orderButtonTop = By.className("Button_Button__ra12g"); // Верхняя кнопка заказа
    private By orderButtonBot = By.className(".Button_Button__ra12g.Button_UltraBig__UU3Lp"); // Нижняя кнопка заказа
    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationInput = By.className("select-search__input"); // Станция метро
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[contains(text(),'Далее')]");
    private By successMessage = By.className("Order_ModalHeader__3FDaJ"); // Всплывающее окно с успешным заказом

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика по кнопке "Заказать" вверху страницы
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    public void clickOrderButtonBot() {
        driver.findElement(orderButtonBot).click();
    }

    // Метод для заполнения формы заказа
    public void fillOrderForm(String name, String lastName, String address, String metro, String phone) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroStationInput).sendKeys(metro);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    // Метод для проверки, что появилось окно с успешным заказом
    public boolean isOrderSuccess() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
