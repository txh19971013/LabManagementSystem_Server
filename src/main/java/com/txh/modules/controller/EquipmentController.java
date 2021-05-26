package com.txh.modules.controller;

import com.txh.common.utils.R;
import com.txh.modules.entity.EquipmentEntity;
import com.txh.modules.form.ApplyBuyForm;
import com.txh.modules.form.NameTypeCount;
import com.txh.modules.form.SetApplyStatusForm;
import com.txh.modules.form.UpdateEquipmentCount;
import com.txh.modules.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/equipment")
@Api(value = "器材接口", description = "器材接口")
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;

    @GetMapping("getApplyById")
    @ApiOperation("教师通过id获取自己的耗材申请记录列表")
    public R getApplyById(@RequestParam(required = false, defaultValue = "1") Long teacherId) {
        return R.ok("成功获取申购历史").put("apply", equipmentService.getApplyById(teacherId));
    }

    @GetMapping("getAllApply")
    @ApiOperation("管理员获取所有老师的耗材申请信息列表")
    public R getAllApply() {
        return R.ok("成功获取申购列表").put("apply", equipmentService.getAllApply());
    }

    @PostMapping("setApplyStatus")
    @ApiOperation("管理员审核耗材申请信息")
    public R setApplyStatus(@RequestBody @Valid SetApplyStatusForm setApplyStatusForm) {
        if (equipmentService.setApplyStatus(setApplyStatusForm) == 1) {//数据库更新数据成功
            //如果审核为通过，审核为通过的时候要在设备表加数据
            if (setApplyStatusForm.getBuyStatus() == 1) {
                //获取申购表种正在审核的这条记录的耗材名称、耗材型号还有耗材数量
                NameTypeCount nameTypeCount = equipmentService.getNameTypeCountById(setApplyStatusForm.getId());
                //获取数据库相同耗材的数量
                Integer count = equipmentService.getCountByNameAndType(nameTypeCount.getName(), nameTypeCount.getType());
                //如果设备表中没有同种器材则直接新插入一条记录
                if (count == null) {
                    EquipmentEntity equipmentEntity = new EquipmentEntity();
                    equipmentEntity.setName(nameTypeCount.getName());
                    equipmentEntity.setType(nameTypeCount.getType());
                    equipmentEntity.setCount(nameTypeCount.getCount());
                    equipmentService.addEquipment(equipmentEntity);
                } else { //如果设备表中已经有同种器材的记录，则在原有器材数量上追加数量
                    UpdateEquipmentCount updateEquipmentCount = new UpdateEquipmentCount();
                    updateEquipmentCount.setName(nameTypeCount.getName());
                    updateEquipmentCount.setType(nameTypeCount.getType());
                    updateEquipmentCount.setCount(count + nameTypeCount.getCount());
                    equipmentService.updateCount(updateEquipmentCount);
                }
                return R.ok("已通过");
            } else {//如果审核为拒绝
                return R.ok("已拒绝");
            }
        } else {//数据库更新数据失败
            return R.error("审核失败，请稍后重试");
        }
    }

    @PostMapping("applyBuy")
    @ApiOperation("教师进行耗材申购")
    public R applyBuy(@RequestBody @Valid ApplyBuyForm applyBuyForm) {
        if (equipmentService.applyBuy(applyBuyForm) == 1) {
            return R.ok("提交申请成功");
        } else {
            return R.error("你已经申请过该耗材，请耐心等待管理员审批");
        }
    }

    @GetMapping("getAllEquipment")
    @ApiOperation("管理员查看全部设备列表")
    public R getAllEquipment() {
        return R.ok("成功获取设备列表").put("AllEquipment", equipmentService.getAllEquipment());
    }
}
