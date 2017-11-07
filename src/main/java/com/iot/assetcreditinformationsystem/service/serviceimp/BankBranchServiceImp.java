package com.iot.assetcreditinformationsystem.service.serviceimp;

import com.iot.assetcreditinformationsystem.domain.BankBranch;
import com.iot.assetcreditinformationsystem.repository.BankBranchRepository;
import com.iot.assetcreditinformationsystem.service.BankBranchService;
import com.iot.assetcreditinformationsystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankBranchServiceImp implements BankBranchService {

    @Autowired
    private BankBranchRepository bankBranchRepository;

    @Override
    public List<BankBranch> findAll() {
        return bankBranchRepository.findAll();
    }

    @Override
    public BankBranch save(BankBranch entity) {
        return bankBranchRepository.save(entity);
    }

    @Override
    public BankBranch findOne(Integer id) {
        return bankBranchRepository.findOne(id);
    }

    @Override
    public BankBranch update(BankBranch entity) {
        return bankBranchRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        bankBranchRepository.delete(id);
    }
}
