package com.prueba.calles.services;

import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;

import com.prueba.calles.model.Driver;
import com.prueba.calles.model.Semaphore;

@Service
public class DriveImpl implements IDrive {

    private void subscribeToSemaphores(List<Driver> driverList, List<Semaphore> semaphoreList) {
        for(Driver driver : driverList){
            for(Semaphore semaphore : semaphoreList){
                semaphore.setSupport(new PropertyChangeSupport(this));
                semaphore.addPropertyChangeListener(driver);
            }
        }
    }

    private void startSemaphores(List<Semaphore> semaphoreList) {
        for(Semaphore semaphore : semaphoreList) {
            TimerTask timerTask = semaphore;
            Timer timer = new Timer(false);
            timer.scheduleAtFixedRate(timerTask, 0, semaphore.getChangeTime());
        }
    }


    @Override
    public void startSimulation(List<Driver> driverList, List<Semaphore> semaphoreList) {
        this.startSemaphores(semaphoreList);
        this.subscribeToSemaphores(driverList, semaphoreList);
    }
}
