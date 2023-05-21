package org.elsys_bg.ElectronicsRepair.repository;

import org.elsys_bg.ElectronicsRepair.entity.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long>{
}