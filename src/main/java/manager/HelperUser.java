package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
        wd.findElement(By.cssSelector("a[ng-reflect-router-link='login']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.cssSelector("#email"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
    }
    public void submitInfForm(){
        click(By.xpath("//button[normalize-space()='Ok']"));
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//a[normalize-space()='Logout']"));
        return list.size()>0;
    }

    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
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

}
