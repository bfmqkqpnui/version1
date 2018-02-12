package com.limovue.exception;

import com.limovue.common.ReturnDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnDTO handleException(HttpServletRequest req, Exception e) {
        ReturnDTO dto = new ReturnDTO();
        dto.setResCode("500");
        dto.setSuccess(false);
        dto.setErrMsg("系统错误,请稍后在试！");
        return dto;
    }
}
