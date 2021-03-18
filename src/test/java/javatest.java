import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javatest {
private WebDriver webDriver;

@Before
public void start() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.get("https://savkk.github.io/selenium-practice/");
}

@Test
public void Fifthtask(){
    WebElement fifthtask = webDriver.findElement(By.id("iframe"));
    fifthtask.click();
    WebElement iframe = webDriver.findElement(By.xpath("//iframe"));
    webDriver.switchTo().frame(iframe);
    WebElement code= webDriver.findElement(By.xpath(".//label[@id= 'code']"));
    String text = code.getText().substring(code.getText().lastIndexOf(' ')+1);
    System.out.println(text);
    webDriver.switchTo().defaultContent();
   WebElement inputcode = webDriver.findElement(By.xpath("//input[@name='code']"));
   inputcode.sendKeys(text);
   WebElement button = webDriver.findElement(By.xpath("//input[@name='ok']"));
   button.click();
   WebElement returnFirstClicMe = webDriver.findElement(By.linkText("Great! Return to menu"));
   returnFirstClicMe.click();
}

@Test
public  void Sixthtask(){
    WebElement sixthtask = webDriver.findElement(By.id("alerts"));
    sixthtask.click();
    WebElement get = webDriver.findElement(By.xpath("//button[@class= 'get']"));
    get.click();
    Alert AlertGetPassword= webDriver.switchTo().alert();
    String alertTextget= AlertGetPassword.getText().substring(AlertGetPassword.getText().lastIndexOf(' ')+1);
    AlertGetPassword.accept();
    WebElement set = webDriver.findElement(By.xpath("//button[@class='set']"));
    set.click();
    Alert AlertSetPassword= webDriver.switchTo().alert();
    AlertSetPassword.sendKeys(alertTextget);
    AlertSetPassword.accept();
    WebElement great= webDriver.findElement(By.xpath("//label"));
    Assert.assertEquals("Great!",great.getText());
    WebElement ButtonReturn =webDriver.findElement(By.xpath("//button[@class='return']"));
    ButtonReturn.click();
    Alert AlertReturnButton =webDriver.switchTo().alert();
    AlertReturnButton.accept();
}

@Test
public void Seventhtask(){
    WebElement seventhtask = webDriver.findElement(By.id("table"));
    seventhtask.click();
}







    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
