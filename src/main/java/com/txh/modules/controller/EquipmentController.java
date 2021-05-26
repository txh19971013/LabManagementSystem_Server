package com.txh.modules.controller;

import com.txh.common.utils.R;
import com.txh.modules.entity.EquipmentEntity;
import com.txh.modules.form.ApplyBuyForm;
import com.txh.modules.form.SetApplyStatusForm;
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
        if (equipmentService.setApplyStatus(setApplyStatusForm) == 1) {//状态更改成功
            if (setApplyStatusForm.getBuyStatus() == 1) {//状态更改成功，且状态是更改为通过，则在设备表新增数据
                String name = equipmentService.queryEquipmentNameById(setApplyStatusForm.getId());
                EquipmentEntity equipmentEntity = new EquipmentEntity();
                equipmentEntity.setName(name);
                if (equipmentService.addEquipment(equipmentEntity) == 1) {//在设备表新增数据成功
                    return R.ok("已通过");
                } else {
                    return R.error("审核通过，但数据库设备表丢失该器材数据，请联系数据库维护人员");
                }
            } else {//状态更改成功，且状态是更改为拒绝
                return R.ok("已拒绝");
            }
        } else {
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
