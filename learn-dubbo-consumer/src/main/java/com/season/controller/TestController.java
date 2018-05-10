package com.season.controller;

import com.season.AsyncTask;
import com.season.jms.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/5/9.
 */
@Api("测试")
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    AsyncTask asyncTask;

    @ApiOperation(value="给其他服务发送信息", notes="给其他服务发送信息")
    @ApiImplicitParam(name = "msg", value = "发送的信息", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    public void sendMess(@PathVariable("msg")String msg){
        try {
            asyncTask.doTask4(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
