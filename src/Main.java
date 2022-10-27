import transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 1.7, "желтый", 2015, "Россия", "автомат", "хэтч", "хкк123", 4, false, new Car.Key(), new Car.Insurance(LocalDate.now(), 124, "фыв"));
        ladaGranta.setRegNumber("d123ds231");
        System.out.println(ladaGranta);
        System.out.println(ladaGranta.isCorrectRegNumber());
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "черный", 2020, "Германия");
        System.out.println(audiA8);
        Car bmwZ8 = new Car("BMW", "Z8", 3.0, "черный", 2021, "Германия");
        System.out.println(bmwZ8);
        Car kiaSportage = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
        System.out.println(kiaSportage);
        Car hyundaiAvante = new Car("Hyundai", "Avante", 1.6, "оранжевый", 2016, "Южная Корея");
        System.out.println(hyundaiAvante);
    }
}