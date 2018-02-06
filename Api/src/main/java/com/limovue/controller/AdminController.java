package com.limovue.controller;

import com.limovue.domain.AdminPassWordReq;
import com.limovue.domain.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 管理员控制类
 * <p>
 * Author jacky
 * CreateTime 2018年1月23日
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 管理员修改密码
     *
     * @param a 管理员请求更密码bean（AdminPassWordReq）
     * @return Result对象
     */
    @RequestMapping(value = "/updateAdminPassWord")
    public Result updateAdminPassWord(@RequestBody AdminPassWordReq a) {
        logger.info(">>>>>");
        Result result;
        if (StringUtils.isBlank(a.getId())) {
            result = new Result(1, "管理员主键为空", null);
            return result;
        }
        if (StringUtils.isBlank(a.getOldPassWord())) {
            result = new Result(1, "管理员旧密码为空", null);
            return result;
        }
        if (StringUtils.isBlank(a.getNewPassWord())) {
            result = new Result(1, "管理员新密码为空", null);
            return result;
        }
        if (StringUtils.isBlank(a.getToken())) {
            result = new Result(1, "管理员令牌为空", null);
            return result;
        }
        return null;
    }

}
