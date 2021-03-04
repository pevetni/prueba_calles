import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.Color;
import model.Driver;
import model.Semaphore;
import model.Street;
import services.DriveImpl;
import services.IDrive;

public class Application {
    public static void main(String[] args) {
        List<Semaphore> semaphoreList = new ArrayList<>();
        semaphoreList.add(Semaphore.builder()
                .id(1)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(2)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(3)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(1)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(4)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(5)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(6)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(7)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        semaphoreList.add(Semaphore.builder()
                .id(8)
                .changeTime(5000)
                .color(Color.ROJO)
                .build());
        //Initialize Streets
        List<Street> streetList = new ArrayList<>();
        streetList.add(Street.builder()
                .id(1)
                .semaphoreId(1)
                .nextStreet(2)
                .build());
        streetList.add(Street.builder()
                .id(2)
                .semaphoreId(2)
                .nextStreet(3)
                .build());
        streetList.add(Street.builder()
                .id(3)
                .semaphoreId(3)
                .nextStreet(4)
                .build());
        streetList.add(Street.builder()
                .id(1)
                .semaphoreId(1)
                .nextStreet(2)
                .build());
        streetList.add(Street.builder()
                .id(4)
                .semaphoreId(4)
                .nextStreet(5)
                .build());
        streetList.add(Street.builder()
                .id(5)
                .semaphoreId(5)
                .nextStreet(0)
                .build());

        Car car1 = Car.builder()
                .id(1)
                .street(Street.builder()
                        .id(1)
                        .semaphoreId(1)
                        .nextStreet(2)
                        .build())
                .build();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);

        List<Driver> driverList = new ArrayList<>();
        driverList.add(Driver.builder()
                .id(1)
                .car(car1)
                .destinationStreetId(5)
                .build());


        IDrive drive = new DriveImpl();


        drive.startSemaphores(semaphoreList);

        drive.subscribeToSemaphores(driverList, semaphoreList);

    }
}
