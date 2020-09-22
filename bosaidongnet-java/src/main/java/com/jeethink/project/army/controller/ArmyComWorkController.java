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
import com.jeethink.project.army.domain.ArmyComWork;
import com.jeethink.project.army.service.IArmyComWorkService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 工作Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/work")
public class ArmyComWorkController extends BaseController {
    @Autowired
    private IArmyComWorkService armyComWorkService;

    /**
     * 查询工作列表
     */
    @PreAuthorize("@ss.hasPermi('army:work:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArmyComWork armyComWork) {
        startPage();
        List<ArmyComWork> list = armyComWorkService.selectArmyComWorkList(armyComWork);
        return getDataTable(list);
    }

    /**
     * 查询工作列表
     */
    @PostMapping("/getlist")
    public TableDataInfo getList(ArmyComWork armyComWork) {
        startPage();
        List<ArmyComWork> list = armyComWorkService.selectArmyComWorkList(armyComWork);
        return getDataTable(list);
    }

    /**
     * 导出工作列表
     */
    @PreAuthorize("@ss.hasPermi('army:work:export')")
    @Log(title = "工作", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyComWork armyComWork) {
        List<ArmyComWork> list = armyComWorkService.selectArmyComWorkList(armyComWork);
        ExcelUtil<ArmyComWork> util = new ExcelUtil<ArmyComWork>(ArmyComWork.class);
        return util.exportExcel(list, "work");
    }

    /**
     * 获取工作详细信息
     */
    @PreAuthorize("@ss.hasPermi('army:work:query')")
    @GetMapping(value = "/{workId}")
    public AjaxResult getInfo(@PathVariable("workId") Long workId) {
        return AjaxResult.success(armyComWorkService.selectArmyComWorkById(workId));
    }

    /**
     * 获取工作详细信息
     */
    @GetMapping(value = "/getinfo")
    public AjaxResult getInfoApp(Long workId) {
        return AjaxResult.success(armyComWorkService.selectArmyComWorkById(workId));
    }

    /**
     * 新增工作
     */
    @PreAuthorize("@ss.hasPermi('army:work:add')")
    @Log(title = "工作", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArmyComWork armyComWork) {
        armyComWork.setStatus("0");
        return toAjax(armyComWorkService.insertArmyComWork(armyComWork));
    }

    /**
     * 修改工作
     */
    @PreAuthorize("@ss.hasPermi('army:work:edit')")
    @Log(title = "工作", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArmyComWork armyComWork) {
        return toAjax(armyComWorkService.updateArmyComWork(armyComWork));
    }

    /**
     * 删除工作
     */
    @PreAuthorize("@ss.hasPermi('army:work:remove')")
    @Log(title = "工作", businessType = BusinessType.DELETE)
	@DeleteMapping("/{workIds}")
    public AjaxResult remove(@PathVariable Long[] workIds) {
        return toAjax(armyComWorkService.deleteArmyComWorkByIds(workIds));
    }
}
