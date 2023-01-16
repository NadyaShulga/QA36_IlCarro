package tests;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("teddy1@gmail.com", "Teddy1206$");
        app.getHelperUser().submit();
        Thread.sleep(2000);
        //bring a message from SubmitInForm
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }
    @Test
    public void loginSuccessModel() throws InterruptedException {
        User user = new User().withEmail("teddy1@gmail.com").withPassword("Teddy1206$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Thread.sleep(2000);
        //bring a message from SubmitInForm
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginWrongEmail() throws InterruptedException {
        User user = new User().withEmail("teddy1gmail.com").withPassword("Teddy1206$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        //bring a message from SubmitInForm
        Thread.sleep(2000);
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginWrongPassword(){
        User user = new User().withEmail("teddy1@gmail.com").withPassword("Ted");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }
    @Test (enabled = false)
    public void loginUnregisterUser(){

    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeDialogContainer();
    }

   /* @BeforeMethod
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
*/

}
