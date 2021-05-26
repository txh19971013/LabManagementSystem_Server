package com.txh.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.txh.modules.dto.AllApplyBuyEquipmentDto;
import com.txh.modules.entity.ApplyBuyEquipmentEntity;
import com.txh.modules.entity.EquipmentEntity;
import com.txh.modules.form.ApplyBuyForm;
import com.txh.modules.form.NameTypeCount;
import com.txh.modules.form.SetApplyStatusForm;
import com.txh.modules.form.UpdateEquipmentCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EquipmentDao extends BaseMapper<EquipmentEntity> {
    //老师获取自己的耗材申请记录
    public List<ApplyBuyEquipmentEntity> getApplyById(Long teacherId);
    //管理员获取所有耗材申请记录，状态码从小到大排序，0-审核中， 1-已通过， 2-已拒绝，方便安卓端显示
    public List<AllApplyBuyEquipmentDto> getAllApply();
    //管理员进行耗材申请审核
    public Integer setApplyStatus(SetApplyStatusForm setApplyStatusForm);
    //教师发起耗材申购
    public Integer applyBuy(ApplyBuyForm applyBuyForm);
    //管理员审核通过的同时直接将该耗材新增入设备表
    public Integer addEquipment(EquipmentEntity equipmentEntity);
    //通过器材名称和型号查找它的数量
    public Integer getCountByNameAndType(String name, String type);
    //同名同型号的器材追加数量
    public Integer updateCount(UpdateEquipmentCount updateEquipmentCount);
    //通过耗材申请记录的id查询到耗材名，查询到的耗材名再用来在管理员审核通过时，向器材表新增器材，减少了安卓端需要传递回来的字段量
    public NameTypeCount getNameTypeCountById(Long id);
    //管理员查看全部设备
    public List<EquipmentEntity> getAllEquipment();
}
