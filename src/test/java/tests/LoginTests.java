package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("teddy1@gmail.com", "Teddy1206$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitInfForm();
        Thread.sleep(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessNew() throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("catty1@gmail.com", "Catty1206$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitInfForm();
        Thread.sleep(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
     @Test
    public void loginWrongEmail() throws InterruptedException {
    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm("teddy1gmail.com","Teddy1206$");
    Thread.sleep(2000);
    app.getHelperUser().isErrorMessageLogin();
    Thread.sleep(2000);
    String text = app.getHelperUser().isErrorMessageLogin();
    Assert.assertEquals("It'snot look like email", text);

    }
    @Test
    public void loginWrongPassword() throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("teddy1@gmail.com","Teddy");
        Thread.sleep(2000);
        app.getHelperUser().submitLogin();
       String text =  app.getHelperUser().isErrorMessagePassword();
       // Assert.assertFalse((app.getHelperUser().isLogged()));
        Assert.assertEquals(text,"Login failed");
        app.getHelperUser().submitWrongForm();
    }
    @Test
    public void loginUnregisterUser() throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Seddy@gmail.com", "Seddy1206$");
        Thread.sleep(2000);
        app.getHelperUser().submitLogin();
        String text =  app.getHelperUser().isErrorMessagePassword();
        Assert.assertEquals(text,"Login failed");
        app.getHelperUser().submitWrongForm();
    }


}
