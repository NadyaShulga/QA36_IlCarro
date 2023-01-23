package tests;

import model.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
       if(!app.getHelperUser().isLogged()){
           app.getHelperUser().login(new User().withEmail("teddy1@gmail.com").withPassword("Teddy1206$"));
       }
   }
    @Test
    public void addNewCarSuccess() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Haiga, Israel")
                .manufacture("BMW")
                .model("ferrari")
                .year("2022")
                .fuel("Petrol")
                .seats("5")
                .clasS("C")
                .carRegNumber("123-00-" + i)
                .price("67")
                .about("cool")
                .build();

        Thread.sleep(500);
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\DocumentsNadya\\LecWebTelRan\\AutomationTesting\\AQA36Projects\\QA36_IlCarro\\car.jpeg");
        app.getHelperCar().submit();
        Thread.sleep(500);
        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));
        }
    }

