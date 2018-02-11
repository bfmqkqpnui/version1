package com.limovue.dao;

import com.limovue.domain.MemberTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao{

    @Select("select * from t_member where loginId = #{loginId} and pwd = #{pwd}")
    MemberTable findByLoginIdAndPwd(@Param(value = "loginId") String loginId, @Param(value = "pwd") String pwd);
}
