package sopt.org.firstSeminar.controller.firstReport;

public class MainReport {

    public static void main(String[] args) {

        Car[] driver = new Car[2];
        driver[0] = new Truck();
        driver[1] = new Bus();

        for (int i = 0; i < driver.length; i++) {
            driver[i].drive();
        }
    }
}

class Car{
    public String carType = "";

    public void setCarType(String carType) {
        this.carType =carType;
    }

    public void drive() {
        System.out.println(carType + " Drive");
    }
}


class Truck extends Car{

    public Truck() {
        setCarType("Truck");
    }

    @Override
    public void drive() {
        super.drive();
    }
}


class Bus extends Car{

    public Bus() {
        setCarType("Bus");
    }

    @Override
    public void drive() {
        super.drive();
    }

}