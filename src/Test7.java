import org.junit.Test;
import org.openqa.selenium.By;

public class Test7 extends App {

    @Test
    public void HomeVisiblity(){
        this.HomeVisiblity();
    }

    public void ClickButtonTestCases(){
        this.driver.findElement(By.xpath("//a[contains(@href, 'test_cases')]")).click();
    }

    @Test
    public void VerifyPageTestCases(){
        this.ClickButtonTestCases();
        org.junit.Assert.assertTrue(this.driver.findElement(By.xpath("//b[contains(., 'Test Cases')]")).isDisplayed());   
    }
}
