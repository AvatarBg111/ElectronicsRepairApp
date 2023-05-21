package org.elsys_bg.ElectronicsRepair.controller.resources;

import lombok.Data;
import org.elsys_bg.ElectronicsRepair.entity.WorkerPost;

@Data
public class WorkerResource{
    private Integer id;
    private String name;
    private String password;
    private WorkerPost post;
}