package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.Worker;

import java.util.List;

public interface WorkerService{
    List<Worker> findAll();

    Worker save(Worker worker);

    void delete(Worker worker);
    void updateWorker(Worker worker);
}