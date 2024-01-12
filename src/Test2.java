import java.util.List;

import org.checkerframework.checker.units.qual.t;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test2 extends App{
   String email;
   String password;

   public Test2(){
      this.email = "elkoderselagano@gmail.com";
      this.password = "1234";
   }

   public void Newverifiuser(){
      this.clicksiginup();
      

      List<WebElement> txtemail = this.driver.findElements(By.name("email"));
        txtemail.get(0).sendKeys(this.email);

        this.driver.findElement(By.name("password")).sendKeys(this.password);

        List<WebElement> btnsiginup = driver.findElements(By.xpath("//button[contains(@class,'btn-default')]"));
        btnsiginup.get(0).click();
   }

   @Test
   @Override
   public void VerifyLogin(){
      this.clicksiginup();
      junit.framework.Assert.assertTrue(this.driver.findElement(By.className("login-form")).isDisplayed());
   }

   public void userExist(){
      this.Newverifiuser();
      try{
         WebElement msgexist = this.driver.findElement(By.xpath("//p[contains(., 'Your email or password is incorrect!')]"));
      
         if(msgexist.isDisplayed()){
            this.Newverifiuser(this.email, this.password, true);
            this.Newverifiuser();
         }
      }
      catch(Exception e){
         this.driver.findElements(By.className("btn btn-default")).get(0).click();
      }
   }

   @Test
   public void VisibleUsername(){
      userExist();
      WebElement username = driver.findElement(By.xpath("//i[contains(., ' Logged in as ')]"));
      junit.framework.Assert.assertTrue(username.isDisplayed());
      this.DeleteAccount();
   }

   @Test
   public void VerifyAccountDelete(){
      this.VisibleUsername();
      WebElement username = driver.findElement(By.xpath("//b[contains(., 'Account Deleted!')]"));
      junit.framework.Assert.assertTrue(username.isDisplayed());
   }
}
