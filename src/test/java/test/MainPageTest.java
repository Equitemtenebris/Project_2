// test/MainPageTest.java

package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Ожидаемый текст ответа 1"},
                {1, "Ожидаемый текст ответа 2"}
        });
    }

    private int questionIndex;
    private String expectedAnswer;

    public MainPageTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Before
    public void setUp() {
        // Инициализация драйвера
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
    }

    @Test
    public void testImportantQuestions() {
        mainPage.clickQuestion(questionIndex);
        String actualAnswer = mainPage.getAnswerText(questionIndex);
        assertTrue("Текст ответа не совпадает", actualAnswer.contains(expectedAnswer));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
