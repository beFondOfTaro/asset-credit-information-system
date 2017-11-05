package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.ParkingLotCondition;
import com.iot.assetcreditinformationsystem.repository.ParkingLotConditionRepository;
import com.iot.assetcreditinformationsystem.service.ParkingLotConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingLotConditionServiceImp implements ParkingLotConditionService {

    @Autowired
    private ParkingLotConditionRepository parkingLotConditionRepository;

    @Override
    public List<ParkingLotCondition> findAll() {
        return parkingLotConditionRepository.findAll();
    }

    @Override
    public ParkingLotCondition save(ParkingLotCondition entity) {
        return parkingLotConditionRepository.save(entity);
    }

    @Override
    public ParkingLotCondition findOne(Integer id) {
        return parkingLotConditionRepository.findOne(id);
    }

    @Override
    public ParkingLotCondition update(ParkingLotCondition entity) {
        return parkingLotConditionRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        parkingLotConditionRepository.delete(id);
    }
}
