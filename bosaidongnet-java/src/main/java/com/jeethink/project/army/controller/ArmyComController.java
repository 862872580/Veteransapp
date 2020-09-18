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
import com.jeethink.project.army.domain.ArmyCom;
import com.jeethink.project.army.service.IArmyComService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;

/**
 * 公司Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@RestController
@RequestMapping("/army/com")
public class ArmyComController extends BaseController {
    @Autowired
    private IArmyComService armyComService;

    /**
     * 查询公司列表
     */
    @PreAuthorize("@ss.hasPermi('army:com:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArmyCom armyCom) {
        startPage();
        List<ArmyCom> list = armyComService.selectArmyComList(armyCom);
        return getDataTable(list);
    }

    /**
     * 导出公司列表
     */
    @PreAuthorize("@ss.hasPermi('army:com:export')")
    @Log(title = "公司", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ArmyCom armyCom) {
        List<ArmyCom> list = armyComService.selectArmyComList(armyCom);
        ExcelUtil<ArmyCom> util = new ExcelUtil<ArmyCom>(ArmyCom.class);
        return util.exportExcel(list, "com");
    }

    /**
     * 获取公司详细信息
     */
    @PreAuthorize("@ss.hasPermi('army:com:query')")
    @GetMapping(value = "/{comId}")
    public AjaxResult getInfo(@PathVariable("comId") Long comId) {
        return AjaxResult.success(armyComService.selectArmyComById(comId));
    }

    /**
     * 新增公司
     */
    @PreAuthorize("@ss.hasPermi('army:com:add')")
    @Log(title = "公司", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArmyCom armyCom) {
        return toAjax(armyComService.insertArmyCom(armyCom));
    }

    /**
     * 修改公司
     */
    @PreAuthorize("@ss.hasPermi('army:com:edit')")
    @Log(title = "公司", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArmyCom armyCom) {
        return toAjax(armyComService.updateArmyCom(armyCom));
    }

    /**
     * 删除公司
     */
    @PreAuthorize("@ss.hasPermi('army:com:remove')")
    @Log(title = "公司", businessType = BusinessType.DELETE)
	@DeleteMapping("/{comIds}")
    public AjaxResult remove(@PathVariable Long[] comIds) {
        return toAjax(armyComService.deleteArmyComByIds(comIds));
    }
}
