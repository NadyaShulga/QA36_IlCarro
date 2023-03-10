package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Paula").withLastName("Moro").withEmail("moro"+i+"@gmail.com").withPassword("Moro12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        //app.getHelperUser().checkPolicyJS();
        app.getHelperUser().submit();
        Thread.sleep(2000);
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
    }
    @Test
    public void registrationWrongEmail(){

        User user = new User().withName("Paula").withLastName("Moro").withEmail("morogmail.com").withPassword("Moro12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Wrong email format\n" +
                "Wrong email format");
    }
       @Test
    public void registrationWrongPassword(){

        User user = new User().withName("Paula").withLastName("Moro").withEmail("moro@gmail.com").withPassword("45");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
    }
    @Test
    public void registrationWrongName() throws InterruptedException {

        User user = new User().withName("").withLastName("Moro").withEmail("moro1@gmail.com").withPassword("Moro#12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Thread.sleep(2000);
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
       // app.getHelperUser().refresh();
    }
    @Test
    public void registrationWrongLastName() throws InterruptedException {

        User user = new User().withName("Paula").withLastName("").withEmail("moro@gmail.com").withPassword("Moro12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        Thread.sleep(2000);
        app.getHelperUser().submit();
        Thread.sleep(2000);
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
    }
    @AfterMethod
    public void postCondition() {
        app.getHelperUser().closeDialogContainer();
    }
}
