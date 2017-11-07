package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.Bank;
import com.iot.assetcreditinformationsystem.repository.BankRepository;
import com.iot.assetcreditinformationsystem.service.BankService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImp implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank save(Bank entity) {
        return bankRepository.save(entity);
    }

    @Override
    public Bank findOne(Integer id) {
        return bankRepository.findOne(id);
    }

    @Override
    public Bank update(Bank entity) {
        return bankRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        bankRepository.delete(id);
    }
}
