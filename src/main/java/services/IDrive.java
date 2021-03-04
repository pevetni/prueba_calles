package services;

import java.util.List;

import model.Driver;
import model.Semaphore;

public interface IDrive {

    void subscribeToSemaphores(List<Driver> driverList, List<Semaphore> semaphoreList);
    void startSemaphores(List<Semaphore> semaphoreList);
}
