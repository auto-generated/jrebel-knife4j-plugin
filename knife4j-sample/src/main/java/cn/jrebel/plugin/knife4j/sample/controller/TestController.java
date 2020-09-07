package cn.jrebel.plugin.knife4j.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试文档")
public class TestController {

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
