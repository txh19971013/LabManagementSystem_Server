package com.txh.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.txh.modules.dao.EquipmentDao;
import com.txh.modules.dto.AllApplyBuyEquipmentDto;
import com.txh.modules.entity.ApplyBuyEquipmentEntity;
import com.txh.modules.entity.EquipmentEntity;
import com.txh.modules.form.ApplyBuyForm;
import com.txh.modules.form.SetApplyStatusForm;
import com.txh.modules.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentDao, EquipmentEntity> implements EquipmentService {
    @Override
    public List<ApplyBuyEquipmentEntity> getApplyById(Long teacherId) {
        return baseMapper.getApplyById(teacherId);
    }

    @Override
    public List<AllApplyBuyEquipmentDto> getAllApply() {
        return baseMapper.getAllApply();
    }

    @Override
    public Integer setApplyStatus(SetApplyStatusForm setApplyStatusForm) {
        return baseMapper.setApplyStatus(setApplyStatusForm);
    }

    @Override
    public Integer applyBuy(ApplyBuyForm applyBuyForm) {
        return baseMapper.applyBuy(applyBuyForm);
    }

    @Override
    public Integer addEquipment(EquipmentEntity equipmentEntity) {
        return baseMapper.addEquipment(equipmentEntity);
    }

    @Override
    public String queryEquipmentNameById(Long id) {
        return baseMapper.queryEquipmentNameById(id);
    }

    @Override
    public List<EquipmentEntity> getAllEquipment() {
        return baseMapper.getAllEquipment();
    }
}
