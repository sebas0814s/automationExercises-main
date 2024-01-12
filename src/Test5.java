import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Test5 extends Test4 {
    public void WriteSignup(){
        this.VerifyLogin();
        this.driver.findElement(By.name("name")).sendKeys("koder");
        this.driver.findElement(By.name("email")).sendKeys(this.email);
        List<WebElement> btnsiginup = driver.findElements(By.xpath("//button[contains(@class,'btn-default')]"));
        btnsiginup.get(1).click();
    }

    @Test
    public void EmailAlreadyExist(){
        WebElement emailExist = this.driver.findElement(By.xpath("//p[contains(., 'Email Address already exist!')]"));

        Assert.assertTrue(emailExist.isDisplayed());
    }

}
