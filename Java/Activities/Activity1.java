package Activities;

public class Activity1 {

    public static void main(String[] args) {
        Car McLaren = new Car();
        McLaren.make = 2024;
        McLaren.color = "Red";
        McLaren.transmission = "Automatic";

        McLaren.displayCharacterstics();
        McLaren.accelerate();
        McLaren.brake();
    }

}
