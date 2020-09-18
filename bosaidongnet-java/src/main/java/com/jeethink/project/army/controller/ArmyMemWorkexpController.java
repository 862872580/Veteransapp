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
import com.jeethink.project.army.domain.ArmyMemWorkexp;
import com.jeethink.project.army.service.IArmyMemWorkexpService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 工作经历Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/workexp")
public class ArmyMemWorkexpController extends BaseController {
    @Autowired
    private IArmyMemWorkexpService armyMemWorkexpService;

    /**
     * 查询工作经历列表
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArmyMemWorkexp armyMemWorkexp) {
        startPage();
        List<ArmyMemWorkexp> list = armyMemWorkexpService.selectArmyMemWorkexpList(armyMemWorkexp);
        return getDataTable(list);
    }

    /**
     * 导出工作经历列表
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:export')")
    @Log(title = "工作经历", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyMemWorkexp armyMemWorkexp) {
        List<ArmyMemWorkexp> list = armyMemWorkexpService.selectArmyMemWorkexpList(armyMemWorkexp);
        ExcelUtil<ArmyMemWorkexp> util = new ExcelUtil<ArmyMemWorkexp>(ArmyMemWorkexp.class);
        return util.exportExcel(list, "workexp");
    }

    /**
     * 获取工作经历详细信息
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:query')")
    @GetMapping(value = "/{workexpId}")
    public AjaxResult getInfo(@PathVariable("workexpId") Long workexpId) {
        return AjaxResult.success(armyMemWorkexpService.selectArmyMemWorkexpById(workexpId));
    }

    /**
     * 新增工作经历
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:add')")
    @Log(title = "工作经历", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArmyMemWorkexp armyMemWorkexp) {
        return toAjax(armyMemWorkexpService.insertArmyMemWorkexp(armyMemWorkexp));
    }

    /**
     * 修改工作经历
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:edit')")
    @Log(title = "工作经历", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArmyMemWorkexp armyMemWorkexp) {
        return toAjax(armyMemWorkexpService.updateArmyMemWorkexp(armyMemWorkexp));
    }

    /**
     * 删除工作经历
     */
    @PreAuthorize("@ss.hasPermi('army:workexp:remove')")
    @Log(title = "工作经历", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workexpIds}")
    public AjaxResult remove(@PathVariable Long[] workexpIds) {
        return toAjax(armyMemWorkexpService.deleteArmyMemWorkexpByIds(workexpIds));
    }
}
