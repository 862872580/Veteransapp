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
import com.jeethink.project.army.domain.ArmyMem;
import com.jeethink.project.army.service.IArmyMemService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/mem")
public class ArmyMemController extends BaseController {
    @Autowired
    private IArmyMemService armyMemService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('army:mem:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArmyMem armyMem) {
        startPage();
        List<ArmyMem> list = armyMemService.selectArmyMemList(armyMem);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('army:mem:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyMem armyMem) {
        List<ArmyMem> list = armyMemService.selectArmyMemList(armyMem);
        ExcelUtil<ArmyMem> util = new ExcelUtil<ArmyMem>(ArmyMem.class);
        return util.exportExcel(list, "mem");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('army:mem:query')")
    @GetMapping(value = "/{memId}")
    public AjaxResult getInfo(@PathVariable("memId") String memId) {
        return AjaxResult.success(armyMemService.selectArmyMemById(memId));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('army:mem:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArmyMem armyMem) {
        return toAjax(armyMemService.insertArmyMem(armyMem));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('army:mem:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArmyMem armyMem) {
        return toAjax(armyMemService.updateArmyMem(armyMem));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('army:mem:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memIds}")
    public AjaxResult remove(@PathVariable String[] memIds) {
        return toAjax(armyMemService.deleteArmyMemByIds(memIds));
    }
}
