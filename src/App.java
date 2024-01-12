import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class App extends Tests {
    WebDriver driver;

    public App() {
        System.setProperty("webdriver.chrome.driver", Credentials.driver);

        ChromeOptions options = new ChromeOptions();
        // Desactiva las extensiones
        options.addArguments("--disable-notifications");
        options.addArguments("--app=http://www.google.com");
        options.setExperimentalOption("prefs", new HashMap<String, Object>() {
            {
                put("autofill.profile_enabled", false);
            }
        });

        this.driver = new ChromeDriver(options);

        driver.get("http://automationexercise.com");
    }

    @Test
    public void HomeVisiblity() {
        WebElement header = this.driver.findElement(By.id("header"));
        Assert.assertTrue(header.isDisplayed());
    }

    public void clicksiginup() {
        HomeVisiblity();
        WebElement sigin = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-lock')]"));
        sigin.click();

    }

    public static void main(String[] args) throws Exception {
        Test6 test = new Test6();
        test.gotToHome();
    }

    @Test
    public void  VerifySignupForm(){
        WebElement div = this.driver.findElement(By.xpath("//div[contains(@class, 'signup-form')]"));
        Assert.assertTrue(div.isDisplayed());
    }
    
    // override sobre escribe el metodo(basicamente es utilizar el metodo en cualquier otra clase q la necesitemos
    //instanciandolo con la misma funcionalidad y pudiendo cambiar la informacion)
    @Override
    public void Newverifiuser(String emailp, String password, boolean login) {

        clicksiginup();

        

        String[] charcs = new String[] { "A", "B", "C", "D", "F", "G", "H", "I", "W", "Q", "V", "B", "Z", "T", "U", "P",
                "@", "3", "4", "5", "7", "$", "8", "1", "2", "3", "4", "6", "9", "#" };
        Random rn = new Random();
        String name = "", email = "";

        int index1 = rn.nextInt(5, charcs.length - 1);
        for (int i = 0; i < index1; i++) {
            name += charcs[rn.nextInt(0, charcs.length - 1)];
        }

        

        WebElement txtname = this.driver.findElement(By.name("name"));
        txtname.sendKeys(name);

        int index = rn.nextInt(5, charcs.length - 1);
        for (int i = 0; i < index; i++) {
            String randomChar = charcs[rn.nextInt(0, charcs.length - 1)];
            if (randomChar != "@" && randomChar != "$") {
                email += randomChar;
            }
        }
        if(emailp != ""){
            email = emailp;
        }
        else{
            email += "@gmail.com";
        }
        List<WebElement> txtemail = this.driver.findElements(By.name("email"));
        txtemail.get(1).sendKeys(email);

        List<WebElement> btnsiginup = driver.findElements(By.xpath("//button[contains(@class,'btn-default')]"));
        btnsiginup.get(1).click();

        WebElement Checkbox1 = this.driver.findElement(By.id("id_gender1"));
        Checkbox1.click();

        this.driver.findElement((By.id("password"))).sendKeys(password != "" ? password : "1234");

        WebElement days = this.driver.findElement(By.id("days"));
        days.click();
        Select selectday = new Select(days);
        selectday.selectByValue("3");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement months = this.driver.findElement(By.id("months"));
        months.click();
        Select selectmt = new Select(months);
        selectmt.selectByValue("10");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement year = this.driver.findElement(By.id("years"));
        year.click();
        Select selectyr = new Select(year);
        selectyr.selectByValue("2005");

        WebElement Checkbox2 = this.driver.findElement(By.id("newsletter"));
        Checkbox2.click();

        WebElement Checkbox3 = this.driver.findElement(By.id("optin"));
        Checkbox3.click();

        driver.findElement(By.name("first_name")).sendKeys("Koder");
        driver.findElement(By.name("last_name")).sendKeys("se la gano");
        driver.findElement(By.name("company")).sendKeys("Koder S.A.S");
        driver.findElement(By.name("address1")).sendKeys("calle 100 # 23-10");

        WebElement country = this.driver.findElement(By.id("country"));
        country.click();
        Select selectcou = new Select(country);
        selectcou.selectByValue("Canada");

        driver.findElement(By.name("state")).sendKeys("antioquia");
        driver.findElement(By.name("city")).sendKeys("medellin mor");
        driver.findElement(By.name("zipcode")).sendKeys("0150");
        driver.findElement(By.name("mobile_number")).sendKeys("3284356743");

        WebElement btncreate = driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]"));
        btncreate.click();

        WebElement btncontinue = driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]"));
        btncontinue.click();
        WebElement closeadd = this.driver.findElement(By.id("dismiss-button"));
        closeadd.click();
        if(!login){
          this.DeleteAccount();  
        }
        else{
            this.SignOut();
        }
    }

    @Test
    @Override
    public void VerifyLogin(){
        clicksiginup();
        junit.framework.Assert.assertTrue(this.driver.findElement(By.className("signup-form")).isDisplayed());
    }

    @Test
    public void VerifyInformation() {
        Newverifiuser("", "", false);
        WebElement div = this.driver.findElement(By.xpath("//h2[contains(@class, 'title text-center')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());

    }

    @Test
    public void verifyusercreate() {
        VerifyInformation();
        WebElement div = this.driver.findElement(By.xpath("//h2[contains(@class, 'title text-center')]"));
        junit.framework.Assert.assertTrue(div.isDisplayed());

    }

    public void DeleteAccount(){
        this.driver.findElement(By.xpath("//a[contains(@href, '/delete acount')]")).click();
    }

    public void SignOut(){
        this.driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();
    }
}