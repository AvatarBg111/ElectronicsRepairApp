package org.elsys_bg.ElectronicsRepair.controller.resources;

import lombok.Data;
import org.elsys_bg.ElectronicsRepair.entity.Client;

@Data
public class ReviewResource{
    private Integer id;
    private Client client;
    private String reviewText;
}