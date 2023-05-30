package org.elsys_bg.ElectronicsRepair.controller;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.WorkerPost;
import org.elsys_bg.ElectronicsRepair.service.WorkerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/worker_posts")
@RequiredArgsConstructor
public class WorkerPostController{
    private final WorkerPostService workerPostService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllClients(){
        StringBuilder htmlContentBuilder = new StringBuilder();

        try{
            List<WorkerPost> workerPosts = workerPostService.findAll();
            workerPosts.forEach(post -> {
                htmlContentBuilder.append(post.getPost()).append(";");
            });
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String htmlContent = htmlContentBuilder.toString();
        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }
}