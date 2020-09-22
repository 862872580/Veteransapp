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
import com.jeethink.project.army.domain.ArmyMemEduexp;
import com.jeethink.project.army.service.IArmyMemEduexpService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 教育经历Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/eduexp")
public class ArmyMemEduexpController extends BaseController {
    @Autowired
    private IArmyMemEduexpService armyMemEduexpService;

    /**
     * 查询教育经历列表
     */
    @PostMapping("/list")
    public TableDataInfo list(ArmyMemEduexp armyMemEduexp) {
        startPage();
        List<ArmyMemEduexp> list = armyMemEduexpService.selectArmyMemEduexpList(armyMemEduexp);
        return getDataTable(list);
    }

    /**
     * 导出教育经历列表
     */
    @Log(title = "教育经历", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyMemEduexp armyMemEduexp) {
        List<ArmyMemEduexp> list = armyMemEduexpService.selectArmyMemEduexpList(armyMemEduexp);
        ExcelUtil<ArmyMemEduexp> util = new ExcelUtil<ArmyMemEduexp>(ArmyMemEduexp.class);
        return util.exportExcel(list, "eduexp");
    }

    /**
     * 获取教育经历详细信息
     */
    @PostMapping(value = "/getInfo")
    public AjaxResult getInfo(Long eduexpId) {
        return AjaxResult.success(armyMemEduexpService.selectArmyMemEduexpById(eduexpId));
    }

    /**
     * 新增教育经历
     */
    @Log(title = "教育经历", businessType = BusinessType.INSERT)
    @PostMapping("/insert")
    public AjaxResult add(ArmyMemEduexp armyMemEduexp) {
        return toAjax(armyMemEduexpService.insertArmyMemEduexp(armyMemEduexp));
    }

    /**
     * 修改教育经历
     */
    @Log(title = "教育经历", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(ArmyMemEduexp armyMemEduexp) {
        return toAjax(armyMemEduexpService.updateArmyMemEduexp(armyMemEduexp));
    }

    /**
     * 删除教育经历
     */
    @Log(title = "教育经历", businessType = BusinessType.DELETE)
	@PostMapping("/{eduexpIds}")
    public AjaxResult remove(@PathVariable Long[] eduexpIds) {
        return toAjax(armyMemEduexpService.deleteArmyMemEduexpByIds(eduexpIds));
    }

    /**
     * 删除教育经历
     */
    @Log(title = "教育经历", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    public AjaxResult delete(Long eduexpId) {
        return toAjax(armyMemEduexpService.deleteArmyMemEduexpById(eduexpId));
    }
}
