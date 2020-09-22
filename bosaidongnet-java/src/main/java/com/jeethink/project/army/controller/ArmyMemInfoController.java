package com.jeethink.project.army.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.project.army.domain.ArmyMemInfo;
import com.jeethink.project.army.service.IArmyMemInfoService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 用户详细信息Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/info")
public class ArmyMemInfoController extends BaseController {
    @Autowired
    private IArmyMemInfoService armyMemInfoService;

    /**
     * 查询用户详细信息列表
     */
    @PostMapping("/list")
    public TableDataInfo list(ArmyMemInfo armyMemInfo) {
        startPage();
        List<ArmyMemInfo> list = armyMemInfoService.selectArmyMemInfoList(armyMemInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户详细信息列表
     */
    @Log(title = "用户详细信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyMemInfo armyMemInfo) {
        List<ArmyMemInfo> list = armyMemInfoService.selectArmyMemInfoList(armyMemInfo);
        ExcelUtil<ArmyMemInfo> util = new ExcelUtil<ArmyMemInfo>(ArmyMemInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取用户详细信息详细信息
     */
    @PostMapping(value = "/getinfo")
    public AjaxResult getInfo(Long infoId) {
        return AjaxResult.success(armyMemInfoService.selectArmyMemInfoById(infoId));
    }

    /**
     * 获取用户详细信息详细信息
     */
    @PostMapping(value = "/app/getinfo")
    public AjaxResult getInfoApp(Long infoId) {
        return AjaxResult.success(armyMemInfoService.selectArmyMemInfoById(infoId));
    }

    /**
     * 新增用户详细信息
     */
    @Log(title = "用户详细信息", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    public AjaxResult add(ArmyMemInfo armyMemInfo) {
        return toAjax(armyMemInfoService.insertArmyMemInfo(armyMemInfo));
    }

    /**
     * 修改用户详细信息
     */
    @Log(title = "用户详细信息", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(@RequestBody ArmyMemInfo armyMemInfo) {
        return toAjax(armyMemInfoService.updateArmyMemInfo(armyMemInfo));
    }

    /**
     * 删除用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('army:info:remove')")
    @Log(title = "用户详细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds) {
        return toAjax(armyMemInfoService.deleteArmyMemInfoByIds(infoIds));
    }

    /**
     * 删除用户详细信息
     */
    @Log(title = "用户详细信息", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    public AjaxResult delete(Long infoId) {
        return toAjax(armyMemInfoService.deleteArmyMemInfoById(infoId));
    }
}
