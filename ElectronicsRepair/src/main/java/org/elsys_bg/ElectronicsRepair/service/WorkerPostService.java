package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.WorkerPost;

import java.util.List;

public interface WorkerPostService{
    List<WorkerPost> findAll();

    WorkerPost save(WorkerPost workerPost);

    void delete(WorkerPost post);
    void updateWorkerPost(WorkerPost post);
}