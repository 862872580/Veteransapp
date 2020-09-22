package com.jeethink.project.army.controller;

import java.io.IOException;
import java.util.List;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.framework.config.JeeThinkConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.project.army.domain.ArmyCom;
import com.jeethink.project.army.service.IArmyComService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

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
     * 获取公司详细信息
     */
    @PostMapping(value = "/getinfo")
    public AjaxResult getInfoApp(Long comId) {
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

    /**
     * 公司图片上传
     */
    @Log(title = "公司图片", businessType = BusinessType.UPDATE)
    @PostMapping("/photo")
    public AjaxResult photo(@RequestParam("photofile") MultipartFile file) throws IOException
    {
        if (!file.isEmpty())
        {
            String photo = FileUploadUtils.upload(JeeThinkConfig.getComPhotoPath(), file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imgUrl", photo);
            return ajax;
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
