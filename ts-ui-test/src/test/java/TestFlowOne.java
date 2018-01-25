import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 *
 *
 *
 * You need discuss.
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class TestFlowOne {
    private WebDriver driver;
    private String trainType;//0--all,1--GaoTie,2--others
    private String baseUrl;
    //获取指定位数的随机字符串(包含数字,0<length)
    public static String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/Program/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testCancelTickets() throws Exception{

        String userid = getRandomString(6) + "@163.com";

        String password = getRandomString(8);

        baseUrl = "http://10.141.212.22:12898/doErrorQueue/useAccount/"+userid+"/"+password;
        driver.get(baseUrl);

        Thread.sleep(20000);

        //String status = driver.findElement(By.xpath("//html/body/text()")).getText();
        //Assert.assertEquals(status.startsWith("[Do"),true);

    }


    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
