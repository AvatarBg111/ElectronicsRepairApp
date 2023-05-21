package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.WorkerPost;
import org.elsys_bg.ElectronicsRepair.repository.WorkerPostRepository;
import org.elsys_bg.ElectronicsRepair.service.WorkerPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerPostServiceImpl implements WorkerPostService{
    public final WorkerPostRepository workerPostRepository;

    @Override
    public List<WorkerPost> findAll(){
        return workerPostRepository.findAll();
    }

    @Override
    public WorkerPost save(WorkerPost workerPost){
        return workerPostRepository.save(workerPost);
    }
}