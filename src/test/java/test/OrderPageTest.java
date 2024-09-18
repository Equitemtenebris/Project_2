package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OrderPage;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderPageTest {
    private WebDriver driver;
    private OrderPage orderPage;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;

    public OrderPageTest(String name, String lastName, String address, String metro, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Тестовая, д.1", "Бульвар Рокоссовского", "+79111234567"},
                {"Петр", "Петров", "Москва, ул. Примерная, д.5", "Комсомольская", "+79212223344"}
        });
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testPositiveOrderScenario() {
        orderPage.clickOrderButtonTop();
        orderPage.fillOrderForm(name, lastName, address, metro, phone);
        assertTrue("Заказ не был успешно оформлен", orderPage.isOrderSuccess());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
