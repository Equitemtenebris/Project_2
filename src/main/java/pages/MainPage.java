// pages/MainPage.java

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    // Кнопка "Заказать" (верхняя)
    private By orderTopButton = By.cssSelector(".Button_Button__ra12g");

    // Кнопка "Заказать" (нижняя)
    private By orderBottomButton = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    // Раздел "Вопросы о важном"
    private By importantQuestionsSection = By.id("accordion");

    // Вопрос в выпадающем списке
    private By question = By.xpath("//div[@id='accordion']//div[@class='accordion__question']");

    // Текст ответа
    private By answerText = By.xpath("//div[@id='accordion']//div[@class='accordion__panel']//p");

    // Методы взаимодействия
    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }

    public void clickQuestion(int questionIndex) {
        driver.findElements(question).get(questionIndex).click();
    }

    public String getAnswerText(int questionIndex) {
        return driver.findElements(answerText).get(questionIndex).getText();
    }
}
