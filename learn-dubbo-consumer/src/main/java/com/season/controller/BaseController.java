package com.season.controller;

import com.season.domain.BaseResult;
import com.season.utils.WebUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.InvalidSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/5/11.
 */
public class BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    /**
     * 统一异常处理
     *
     * @param request
     * @param response
     * @param exception
     */
    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        LOGGER.error("统一异常处理：", exception);
        request.setAttribute("ex", exception);

        if (WebUtil.isAjaxRequest(request)) {
            request.setAttribute("requestHeader", "ajax");
        }

        BaseResult result = null;
        // shiro没有权限异常
        if (exception instanceof UnauthorizedException || exception instanceof AuthenticationException) {
            result = BaseResult.unAuthorized();
        }
        // shiro会话已过期异常
        if (exception instanceof InvalidSessionException) {
            result = BaseResult.invalidSession();
        }
        if (null == result) {
            result = BaseResult.unKnow(exception.getMessage());
        }

        WebUtil.writeJson(result, response);
        return null;
    }


}
