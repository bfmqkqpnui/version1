package com.limovue.service;

import com.limovue.domain.MemberTable;

import java.util.Map;

public interface MemberService {

    MemberTable login(Map<String,Object> param);
}
