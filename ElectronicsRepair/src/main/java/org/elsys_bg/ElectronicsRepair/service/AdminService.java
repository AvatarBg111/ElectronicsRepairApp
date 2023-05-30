package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.Admin;

import java.util.List;

public interface AdminService{
    List<Admin> findAll();

    Admin save(Admin admin);

    void delete(Admin admin);

    void updateAdmin(Admin admin);
}