package manager;

import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
    if(!wd.findElement(By.id("terms-of-use")).isSelected()){
    click(By.cssSelector("label[for='terms-of-use']"));
    }
}
    public void checkPolicyXY() {
        Dimension size = wd.manage().window().getSize(); // object
        System.out.println("Window Height" + size.getHeight());
        System.out.println("Window Wight" + size.getWidth());

        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect(); //object
        int xOffset = rect.getWidth()/2;
        Actions actions = new Actions(wd);
        // actions.clickAndHold().moveToElement().pause().release().perform();
        // actions.dragAndDropBy();
        actions.moveToElement(label,-xOffset,0).click().release().perform();
    }

    public void checkPolicyJS() {
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }

    public void refresh() {
        wd.navigate().refresh();
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submit();
        closeDialogContainer();
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


