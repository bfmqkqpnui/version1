package com.limovue.controller;

import com.limovue.common.ReturnDTO;
import com.limovue.common.constans.CommonConstans;
import com.limovue.domain.MemberTable;
import com.limovue.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private MemberService memberService;
    /*
     * 日志
     * @author lance
     * @date 2017/12/13 0:58
     * @param  * @param null
     * @return
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
     * 登录
     * @author lance
     * @date 2017/12/13 1:00
     * @param  * @param loginId
     * @param loginPwd
     * @return com.lance.domain.ReturnDTO
     */
    @RequestMapping(value = "/member/login")
    public ReturnDTO login(String loginId, String loginPwd){
        logger.info("用户登录 开始");
        long beginTime = System.currentTimeMillis();
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if(StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(loginPwd)){
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("loginid",loginId);
            param.put("pwd",loginPwd);

            MemberTable member = memberService.login(param);
            if(null != member){
                System.out.println("========================================");
                //创建令牌
                dto.setObj(member);
                dto.setSuccess(true);
                dto.setResCode("200");
            }
        }else{
            dto.setErrMsg("登录失败,未接收到用户名和密码数据");
            dto.setResCode("504");
        }
        logger.info("用户登录 完成,耗时["+(System.currentTimeMillis()-beginTime)+"]毫秒");
        return dto;
    }

    /*
     * 注册
     * @author lance
     * @date 2017/12/13 1:01
     * @param  * @param loginId
     * @param loginPwd
     * @return com.lance.domain.ReturnDTO
     */
    @RequestMapping(value = "/member/regist")
    public ReturnDTO regist(String loginId,String loginPwd){
        logger.info("用户注册 开始");
        long beginTime = System.currentTimeMillis();
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if(StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(loginPwd)){
            Map<String,Object> params = new HashMap<String,Object>();
            params.put(CommonConstans.LOGINID,loginId);
            params.put(CommonConstans.LOGINPWD,loginPwd);
        }
        logger.info("用户注册 完成,耗时["+(System.currentTimeMillis()-beginTime)+"]毫秒");
        return dto;
    }
}
