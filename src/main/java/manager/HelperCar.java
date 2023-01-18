package manager;

import model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }
    public void openCarForm() {

        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
    }

    public void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector(".pac-item"));
        try {
            pause(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
