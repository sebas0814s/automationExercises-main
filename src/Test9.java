import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test9 extends Test8 {
    @Test 
    public void PageAllProducts(){
        this.VerifyAllProducts();
    }

    public void SearchProduct(){
        this.ClickProductButton();

        this.driver.findElement(By.id("search_product")).sendKeys("Blue Top");
        this.driver.findElement(By.id("submit_search")).click();
    }

    @Test
    public void VerifySearchedProducts(){
        this.SearchProduct();

        Assert.assertTrue(this.driver.findElement(By.xpath("//h2[contains(., 'Searched Products')]")).isDisplayed());
    }

    @Test 
    public void IsVisibleAllProductSearched(){
        this.SearchProduct();

        Assert.assertTrue(this.driver.findElement(By.xpath("//div[contains(@class, 'col-sm-4')]")).isDisplayed());
    }
}
