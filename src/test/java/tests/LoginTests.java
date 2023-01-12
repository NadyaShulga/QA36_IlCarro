package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

   @BeforeMethod
   public void preCondition(){
   if(app.getHelperUser().isLogged())
           app.getHelperUser().logout();
        }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("teddy1@gmail.com", "Teddy1206$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitInfForm();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessNew(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("catty1@gmail.com", "Catty1206$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitInfForm();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


}
