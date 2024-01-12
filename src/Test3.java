import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Test3 extends Test2 {
    @Override
    @Test
    public void userExist(){
        this.Newverifiuser();
        WebElement msgexist = this.driver.findElement(By.xpath("//p[contains(., 'Your email or password is incorrect!')]"));

        Assert.assertTrue(msgexist.isDisplayed());
    }
}
