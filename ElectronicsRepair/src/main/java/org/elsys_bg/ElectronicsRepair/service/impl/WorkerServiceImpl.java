package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.Worker;
import org.elsys_bg.ElectronicsRepair.repository.WorkerRepository;
import org.elsys_bg.ElectronicsRepair.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService{
    public final WorkerRepository workerRepository;

    @Override
    public List<Worker> findAll(){
        return workerRepository.findAll();
    }

    @Override
    public Worker save(Worker worker){
        return workerRepository.save(worker);
    }
}