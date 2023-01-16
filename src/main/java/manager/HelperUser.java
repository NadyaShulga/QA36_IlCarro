package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[text()='Y’alla!']"));
    }

    public String getMessage() {
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
    }

    public void closeDialogContainer() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }

        }
    public boolean isLogged() {
            return isElementPresent(By.cssSelector("div.header a:nth-child(5)"));
        }

    public void logout () {
            click(By.cssSelector("div.header a:nth-child(5)"));
        }

    public String getErrorText () {
            return wd.findElement(By.cssSelector("div.error")).getText();
        }

    public boolean isYallaButtonNotActive () {
            // return isElementPresent(By.cssSelector("button[disabled]"));
            return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
        }

    public void openRegistrationForm() {
        click(By.cssSelector("a[href*='registration?url']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#name"),user.getName());
        type(By.cssSelector("#lastName"),user.getLastName());
        type(By.cssSelector("#email"),user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void checkPolicy() {
    //wd.findElement(By.xpath("//*[contains(@class,'checkbox-label terms-label')]")).click();
    click(By.xpath("//div[@class='checkbox-container']"));



    }
    public String getRegMessage() {
        return wd.findElement(By.cssSelector("h1[class='title']")).getText();
    }
    public void refresh(){
        wd.navigate().refresh();
    }
}

   /* public void submitInfForm(){
        click(By.xpath("//button[normalize-space()='Ok']"));
    }
    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//a[normalize-space()='Logout']"));
        return list.size()>0;
    }

    public String isErrorMessageLogin(){
        WebElement wrongEmail =  wd.findElement(By.cssSelector("div[class='ng-star-inserted']"));
        String text = wrongEmail.getText();
        return text;
    }

    public String isErrorMessagePassword(){
        WebElement wrongPassword = wd.findElement((By.cssSelector("h1[class='title']")));
        String text = wrongPassword.getText();
        return text;
    }

    public void submitWrongForm(){
        click(By.xpath("//button[normalize-space()='Ok']"));
    }

    */


