package org.elsys_bg.ElectronicsRepair.repository;

import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportedDeviceForRepairRepository extends JpaRepository<SupportedDeviceForRepair, Long> {
}