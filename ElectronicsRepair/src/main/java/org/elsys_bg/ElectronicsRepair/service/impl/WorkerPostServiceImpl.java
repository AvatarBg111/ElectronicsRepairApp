package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.controller.resources.WorkerPostResource;
import org.elsys_bg.ElectronicsRepair.entity.Worker;
import org.elsys_bg.ElectronicsRepair.entity.WorkerPost;
import org.elsys_bg.ElectronicsRepair.mapper.WorkerPostMapper;
import org.elsys_bg.ElectronicsRepair.repository.WorkerPostRepository;
import org.elsys_bg.ElectronicsRepair.service.WorkerPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WorkerPostServiceImpl implements WorkerPostService{
    public final WorkerPostRepository workerPostRepository;
    private final WorkerPostMapper workerPostMapper;

    public WorkerPost getById(Long workerPostId){
        return workerPostRepository.getById(workerPostId);
    }

    public WorkerPost getByPost(String workerPost){
        return workerPostRepository.getByPost(workerPost);
    }

    @Override
    public List<WorkerPost> findAll(){
        return workerPostRepository.findAll();
    }

    @Override
    public WorkerPost save(WorkerPost workerPost){
        return workerPostRepository.save(workerPost);
    }

    @Override
    public void delete(WorkerPost post){
        workerPostRepository.delete(post);
    }

    @Override
    public void updateWorkerPost(WorkerPost post) throws NoSuchElementException{
        WorkerPost existingWorkerPost = workerPostRepository.findById(Long.valueOf(post.getId())).orElse(null);
        if(existingWorkerPost != null){
            existingWorkerPost.setPost(post.getPost());
            workerPostRepository.save(existingWorkerPost);
        }else{
            throw new NoSuchElementException("ERR: Worker post with ID " + post.getId() + " does not exist.");
        }
    }

    public WorkerPost addWorkerPost(String workerPost){
        WorkerPostResource newWorkerPost = new WorkerPostResource();
        newWorkerPost.setPost(workerPost);
        return workerPostRepository.save(workerPostMapper.fromWorkerPostResource(newWorkerPost));
    }
}