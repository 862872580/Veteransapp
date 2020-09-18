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
    @PreAuthorize("@ss.hasPermi('army:eduexp:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArmyMemEduexp armyMemEduexp) {
        startPage();
        List<ArmyMemEduexp> list = armyMemEduexpService.selectArmyMemEduexpList(armyMemEduexp);
        return getDataTable(list);
    }

    /**
     * 导出教育经历列表
     */
    @PreAuthorize("@ss.hasPermi('army:eduexp:export')")
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
    @PreAuthorize("@ss.hasPermi('army:eduexp:query')")
    @GetMapping(value = "/{eduexpId}")
    public AjaxResult getInfo(@PathVariable("eduexpId") Long eduexpId) {
        return AjaxResult.success(armyMemEduexpService.selectArmyMemEduexpById(eduexpId));
    }

    /**
     * 新增教育经历
     */
    @PreAuthorize("@ss.hasPermi('army:eduexp:add')")
    @Log(title = "教育经历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArmyMemEduexp armyMemEduexp) {
        return toAjax(armyMemEduexpService.insertArmyMemEduexp(armyMemEduexp));
    }

    /**
     * 修改教育经历
     */
    @PreAuthorize("@ss.hasPermi('army:eduexp:edit')")
    @Log(title = "教育经历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArmyMemEduexp armyMemEduexp) {
        return toAjax(armyMemEduexpService.updateArmyMemEduexp(armyMemEduexp));
    }

    /**
     * 删除教育经历
     */
    @PreAuthorize("@ss.hasPermi('army:eduexp:remove')")
    @Log(title = "教育经历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eduexpIds}")
    public AjaxResult remove(@PathVariable Long[] eduexpIds) {
        return toAjax(armyMemEduexpService.deleteArmyMemEduexpByIds(eduexpIds));
    }
}
