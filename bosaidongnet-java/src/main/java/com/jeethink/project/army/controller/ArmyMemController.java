package com.jeethink.project.army.controller;

import java.io.IOException;
import java.util.List;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.framework.config.JeeThinkConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.framework.aspectj.lang.annotation.Log;
import com.jeethink.framework.aspectj.lang.enums.BusinessType;
import com.jeethink.project.army.domain.ArmyMem;
import com.jeethink.project.army.service.IArmyMemService;
import com.jeethink.framework.web.controller.BaseController;
import com.jeethink.framework.web.domain.AjaxResult;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户Controller
 * 
 * @author miao
 * @date 2020-09-18
 */
@Api(value = "用户模块")
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
     * 获取用户详细信息
     */
    @PostMapping(value = "/getinfo")
    public AjaxResult getInfoApp(String memId) {
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
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
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

    /**
     * 短信验证登陆
     * @param phone 手机号
     * @param code 验证码
     * @return 是否成功
     */
    @PostMapping("/login")
    public String login(String phone, String code){
        return armyMemService.login(phone, code);
    }

    /**
     * 发送验证码
     * @param phone 手机号
     * @return 是否成功
     */
    @PostMapping("/sendsms")
    @ApiOperation("发送短息")
    public String sendSMS(String phone){
        return armyMemService.sendSMS(phone);
    }

    /**
     * 用户头像上传
     */
    @Log(title = "用户头像", businessType = BusinessType.UPDATE)
    @PostMapping("/photo")
    public AjaxResult photo(@RequestParam("photofile") MultipartFile file) throws IOException
    {
        if (!file.isEmpty())
        {
            String photo = FileUploadUtils.upload(JeeThinkConfig.getHandImagePhotoPath(), file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("imgUrl", photo);
            return ajax;
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
