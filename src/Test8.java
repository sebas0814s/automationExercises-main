import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test8 extends App {
    
    @Test
    public void HomeVisibility(){
        this.HomeVisiblity();
    }

    public void ClickProductButton(){
        this.driver.findElement(By.xpath("//a[contains(@href, '/products')]")).click();
    }

    @Test
    public void VerifyAllProducts(){
        ClickProductButton();
        Assert.assertTrue(this.driver.findElement(By.xpath("//h2[contains(., 'All Products')]")).isDisplayed());
    }

    public void ClickViewFirstProduct(){
        this.driver.findElement(By.xpath("//a[contains(@href, '/product_details/1')]")).click();
    }

    @Test
    public void VerifyInformationProduct(){
        ClickViewFirstProduct();
        Assert.assertTrue(this.driver.findElement(By.xpath("//h2[contains(., 'Blue Top')]")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.xpath("//p[contains(., 'Category: Women > Tops')]")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.xpath("//span[contains(., 'Rs. 500')]")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.xpath("//input[contains(@id, 'quantity')]")).getText() != "0");
        Assert.assertTrue(this.driver.findElement(By.xpath("//b[contains(., 'Brand:')]")).isDisplayed());
        Assert.assertTrue(this.driver.findElement(By.xpath("//p[contains(., ' Polo')]")).findElement(By.xpath("//b[contains(., 'Condition:')]")).isDisplayed());
    }

}
