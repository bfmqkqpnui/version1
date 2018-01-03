package com.limovue.service.impl;

import com.limovue.common.util.CommonUtils;
import com.limovue.common.util.MyEncrypt;
import com.limovue.common.util.Token;
import com.limovue.dao.MemberDao;
import com.limovue.domain.MemberTable;
import com.limovue.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Map;

@Component(value="MemberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberTable login(Map<String, Object> param) {
        MemberTable member = null;
        if(CommonUtils.isExist(param)){
            String loginId = param.get("loginid") == null ? "" : param.get("loginid").toString();
            String pwd = param.get("pwd") == null ? "" : param.get("pwd").toString();

            if(StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(pwd)){
                member = memberDao.findByLoginIdAndPwd(loginId,pwd);

                if(null != member){
                    //密钥
                    String initKey = MyEncrypt.initMacKey();
                    Token token = new Token();
                    token.setMemberId(member.getMemberId());
                }
            }
        }
        return member;
    }
}
