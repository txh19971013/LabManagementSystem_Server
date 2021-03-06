package com.txh.modules.service;


import com.txh.modules.dto.AllApplyBuyEquipmentDto;
import com.txh.modules.entity.ApplyBuyEquipmentEntity;
import com.txh.modules.entity.EquipmentEntity;
import com.txh.modules.form.ApplyBuyForm;
import com.txh.modules.form.NameTypeCount;
import com.txh.modules.form.SetApplyStatusForm;
import com.txh.modules.form.UpdateEquipmentCount;

import java.util.List;

public interface EquipmentService {

    public List<ApplyBuyEquipmentEntity> getApplyById(Long teacherId);

    public List<AllApplyBuyEquipmentDto> getAllApply();

    public Integer setApplyStatus(SetApplyStatusForm setApplyStatusForm);

    public Integer applyBuy(ApplyBuyForm applyBuyForm);

    public Integer addEquipment(EquipmentEntity equipmentEntity);

    public Integer getCountByNameAndType(String name, String type);

    public Integer updateCount(UpdateEquipmentCount updateEquipmentCount);

    public NameTypeCount getNameTypeCountById(Long id);

    public List<EquipmentEntity> getAllEquipment();

}
