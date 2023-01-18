package tests;

import model.Car;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
       if(!app.getHelperUser().isLogged()){
           app.getHelperUser().login(new User().withEmail("teddy1@gmail.com").withPassword("Teddy1206$"));
       }
   }
    @Test
    public void addNewCarSuccess(){

        Car car = Car.builder()
                .location("Haiga, Israel")
                .manufacture("BMW")
                .model("ferrari")
                .year("2022")
                .fuel("Hybrid")
                .seats("5")
                .clasS("C")
                .carRegNumber("1122334455")
                .price("67")
                .about("cool")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        //app.getHelperCar().attachPhoto();
        app.getHelperCar().submit();
        //asserts
        }
    }

