package com.jeethink.framework.SMS;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.jeethink.framework.SMS.TecentString.*;

/**
 * @author lulifeng
 * 腾讯短信
 * 参考:https://github.com/qcloudsms/qcloudsms_java
 */
public class TengXunSMS {

    private static final Logger LOGGER = LoggerFactory.getLogger(TengXunSMS.class);

//  public static void main(String[] args) {
//      TengXunSMS.validation("18858312781", "15268",334697);
//    }

    /**
     * 330170  模板 验证码
     * @param phoneNo
     * @param templateId
     * 返回结果 {"result":0,"errmsg":"OK","ext":"","sid":"8:WJ1I0oRY8iUvHUtqpAm20190701","fee":1}
     */
    public static void validation(String phoneNo,String code, int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[] {code}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult senderResult = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.println(senderResult);
           /* JSONObject jsonResult = new JSONObject(senderResult);
            String sid = jsonResult.getString("sid");*/
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    /**
     * 350416  模板  审核不通过
     * @param phoneNo
     * @param templateId
     */
    public static void Auditfailed(String phoneNo,String name,int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[]{name}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
    /**
     * 333808  模板  审核不通过有意见
     * @param phoneNo
     * @param templateId
     */
    public static void auditOpinion(String phoneNo,String name, String projectName, String Opinion, int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[]  {name, projectName,Opinion}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 326466  模板 审核不通过
     * @param phoneNo
     * @param templateId
     */
    public static void send(String phoneNo,String name, String projectName,int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[] {name, projectName}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 350415  模板
     * @param phoneNo 发送短信
     * @param templateId
     */
    public static void QualifiedAudit(String phoneNo,String name, int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[] {name}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * 350415  模板
     * @param phoneNo 发送短信
     * @param templateId
     */
    public static void review(String phoneNo, int templateId) {
        try {
            String phoneNumbers[] = new String[] {phoneNo};
            String[] params = new String[] {}; // 短信发送的内容{1}，{2}，{3}
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
                    templateId, params, SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
        } catch (HTTPException | JSONException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}