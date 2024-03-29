
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class Test_1
{
    WebDriver driver;


    @AfterClass
    public void afterClass() {

        // driver.close();
    }


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jon\\Desktop\\java\\chromedriver100.exe");

        driver = new ChromeDriver();

    }


    @Test(enabled = true)
    public void test1_step_01() throws Exception {
        try {


            driver.get("https://www.ozon.ru/"); // открытие страницы яндекс
            //   driver.manage().window().maximize(); // задаем размеры браузера во все разрешение экрана
            //Есть кнопка  «зарабатывай с озон»
            assertTrue(driver.findElement(By.xpath("//a[@rel=\"nofollow\"]//span[text()='Зарабатывай с Ozon']")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(true);
        }
    }

    @Test(enabled = true)
    public void test1_step_02() {
        try {

            //Нажать на кнопку«зарабатывай с озон»
            driver.findElement(By.xpath("//a[@rel=\"nofollow\"]//span[text()='Зарабатывай с Ozon']")).click();
            //Отобразилась кнопка «хочу зарабытывать»
            Assert.assertEquals(driver.findElement(By.xpath("//a[@href=\"#eaming-picker\"and text()='Хочу зарабатывать']")).isDisplayed(), true);

        } catch (Throwable e) {

            assertTrue(false);
        }
    }

    @Test(enabled = true)
    public void test1_step_03() {
        try {

            //Нажать кнопку «хочу зарабытывать»
            driver.findElement(By.xpath("//a[@href=\"#eaming-picker\"and text()='Хочу зарабатывать']")).click();
            //Отобразилось кнопка в форме «установите постамат»
            assertTrue(driver.findElement(By.xpath("//i[@alt=\"icon arrow\"]/parent::a[@href=\"https://www.ozon.ru/ozon-box/\"]")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(false);
        }
    }

    @Test(enabled = true)
    public void test1_step_04() {
        try {

            //Нажать на кнопку в форме кнопка в форме «установите постамат»
            //--//i[@alt="icon arrow"]/../../a[@href="https://www.ozon.ru/ozon-box/"]
            driver.findElement(By.xpath("//i[@alt=\"icon arrow\"]/parent::a[@href=\"https://www.ozon.ru/ozon-box/\"]")).click();
            //Появилась кнопка «оставит заявку»
            assertTrue(driver.findElement(By.xpath("//a[@class=\"box-top-button box-button\"][@href=\"#ozonbox-form-place\"]")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(true);
        }
    }

    @Test(enabled = true)
    public void test1_step_05() {
        try {

//Нажать на кнопку «оставит заявку»
            driver.findElement(By.xpath("//a[@class=\"box-top-button box-button\"][@href=\"#ozonbox-form-place\"]")).click();
// Появилась форма с полями
            assertTrue(driver.findElement(By.xpath("//input[@id=\"name\"]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//input[@id=\"postamats\"]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//input[@id=\"phone\"]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//input[@id=\"email\"]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("//input[@id=\"address\"]")).isDisplayed());


        } catch (Throwable e) {

            assertTrue(true);
        }
    }

    @Test(enabled = true)
    public void test1_step_06() {
        try {

//Ввести в поле имя фамилия- donn
//Ввести в поле колич -10
//Тел- 012 345 67 89
//Емаил -dor@mail.ru
//Город -Курск
//Адрес -дружбы 5
            driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("donn");
            driver.findElement(By.xpath("//input[@id=\"postamats\"]")).sendKeys("10");
            driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("0123456789");
            driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("dor@mail.ru");
            driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).sendKeys("Курск");
            driver.findElement(By.xpath("//input[@id=\"address\"]")).sendKeys("дружбы 5");
//Данные ввелись

            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"name\"]")).getAttribute("value"), "donn");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"postamats\"]")).getAttribute("value"), "10");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"phone\"]")).getAttribute("value"), "+7 012 345 67 89");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"email\"]")).getAttribute("value"), "dor@mail.ru");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).getAttribute("value"), "Курск");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"address\"]")).getAttribute("value"), "дружбы 5");
//проверка красного цвета
            Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"ozon-box-form__validation-text\"]")).getCssValue("color"), "rgba(248, 17, 85, 1)");


        } catch (Throwable e) {

            assertTrue(true);
        }
    }


    @Test(enabled = true)
    public void test1_step_07() {
        try {

            //отчистить форму
            driver.findElement(By.xpath("//input[@id=\"name\"]")).clear();
            driver.findElement(By.xpath("//input[@id=\"postamats\"]")).clear();
            driver.findElement(By.xpath("//input[@id=\"phone\"]")).clear();
            driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
            driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).clear();
            driver.findElement(By.xpath("//input[@id=\"address\"]")).clear();
            //Ввести в поле имя фамилия- donn%
            //Ввести в поле колич -999
            //Тел- +7 000 000 00 00
            //Емаил –dor@почта.рф
            //Город –Курск2%#
            //Адрес -дружбы 5%#
            driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("donn%");
            driver.findElement(By.xpath("//input[@id=\"postamats\"]")).sendKeys("999");
            driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys("0000000000");
            driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("dor@почта.рф");
            driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).sendKeys("Курск2%#");
            driver.findElement(By.xpath("//input[@id=\"address\"]")).sendKeys("дружбы 5%#");
//Данные ввелись

            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"name\"]")).getAttribute("value"), "donn%");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"postamats\"]")).getAttribute("value"), "999");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"phone\"]")).getAttribute("value"), "+7 000 000 00 00");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"email\"]")).getAttribute("value"), "dor@xn--80a1acny.xn--p1ai");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@class=\"prompt search-input\"]")).getAttribute("value"), "Курск2%#");
            Assert.assertEquals(driver.findElement(By.xpath("//input[@id=\"address\"]")).getAttribute("value"), "дружбы 5%#");


        } catch (Throwable e) {

            assertTrue(false);
        }
    }


}
