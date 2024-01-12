import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class Test6 extends App {

    @Test
    public void VerifyHomePage(){
        this.HomeVisiblity();
    }

    public void ContactUs(){
        this.driver.findElement(By.xpath("//a[contains(@href, '/contact_us')]")).click();
    }

    @Test
    public void VerifyGetInTouch(){
        this.ContactUs();

        Assert.assertTrue(this.driver.findElement(By.xpath("//h2[contains(., 'Get In Touch')]")).isDisplayed());
    }

    public void EnterInfoInTouch(){
        this.ContactUs();
        this.driver.findElement(By.name("name")).sendKeys("koder");
        this.driver.findElement(By.name("email")).sendKeys("koderc2005@gmail.com");
        this.driver.findElement(By.name("subject")).sendKeys("subject koder");
        this.driver.findElement(By.name("message")).sendKeys("koder message");
    }

    public void UploadFile(){
        this.EnterInfoInTouch();
        WebElement file = this.driver.findElement(By.name("upload_file"));

        String filePath = "C:\\Users\\koderx\\Desktop\\automationExercises\\src\\files\\parcialbd.txt";

        file.sendKeys(filePath);
    }

    public void ClickButtonSubmit(){
        this.UploadFile();
        this.driver.findElement(By.name("submit")).click();
    }

    public void OkPopUp(){
        ClickButtonSubmit();
        Alert confirm = this.driver.switchTo().alert();

        confirm.accept();
    }

    @Test
    public void VerifySuccess(){
        OkPopUp();
        Assert.assertTrue(this.driver.findElement(By.xpath("//div[contains(@class, 'status alert alert-success')]")).isDisplayed());
    }

    public void gotToHome(){
        this.OkPopUp();

        this.driver.findElement(By.xpath("//a[contains(@class, 'btn btn-success')]")).click();
    }
}
