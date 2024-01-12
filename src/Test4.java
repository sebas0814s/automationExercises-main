import org.junit.Test;

import junit.framework.Assert;

public class Test4 extends Test2 {
    @Test
    public void isNavigatedToLoginPage(){
        this.Newverifiuser();
        this.SignOut();
        Assert.assertTrue(this.driver.getCurrentUrl() == "https://automationexercise.com/login");
    }
}
