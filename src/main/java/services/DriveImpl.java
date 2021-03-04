package services;

import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import model.Driver;
import model.Semaphore;

public class DriveImpl implements IDrive {

    @Override
    public void subscribeToSemaphores(List<Driver> driverList, List<Semaphore> semaphoreList) {
        for(Driver driver : driverList){
            for(Semaphore semaphore : semaphoreList){
                semaphore.setSupport(new PropertyChangeSupport(this));
                semaphore.addPropertyChangeListener(driver);
            }
        }
    }

    @Override
    public void startSemaphores(List<Semaphore> semaphoreList) {
        for(Semaphore semaphore : semaphoreList) {
            TimerTask timerTask = semaphore;
            Timer timer = new Timer(false);
            timer.scheduleAtFixedRate(timerTask, 0, semaphore.getChangeTime());
        }
    }
}
