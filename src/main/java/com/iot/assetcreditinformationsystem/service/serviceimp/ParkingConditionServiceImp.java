package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.ParkingCondition;
import com.iot.assetcreditinformationsystem.repository.ParkingConditionRepository;
import com.iot.assetcreditinformationsystem.service.ParkingConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingConditionServiceImp implements ParkingConditionService {

    @Autowired
    private ParkingConditionRepository parkingConditionRepository;

    @Override
    public List<ParkingCondition> findAll() {
        return parkingConditionRepository.findAll();
    }

    @Override
    public ParkingCondition save(ParkingCondition entity) {
        return parkingConditionRepository.save(entity);
    }

    @Override
    public ParkingCondition findOne(Integer id) {
        return parkingConditionRepository.findOne(id);
    }

    @Override
    public ParkingCondition update(ParkingCondition entity) {
        return parkingConditionRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        parkingConditionRepository.delete(id);
    }
}
