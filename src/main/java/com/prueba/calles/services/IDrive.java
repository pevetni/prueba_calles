package com.prueba.calles.services;

import java.util.List;

import com.prueba.calles.model.Driver;
import com.prueba.calles.model.Semaphore;

public interface IDrive {

    void startSimulation(List<Driver> driverList, List<Semaphore> semaphoreList);

}
