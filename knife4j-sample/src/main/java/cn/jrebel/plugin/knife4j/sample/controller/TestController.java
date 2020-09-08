package cn.jrebel.plugin.knife4j.sample.controller;

import cn.jrebel.plugin.knife4j.sample.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试文档")
public class TestController {

    @ApiOperation("hello")
    @GetMapping("/hello/{aa}")
    public String hello(@PathVariable String aa) {
        return aa;
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    public User test() {
        return new User("test", "test");
    }

    @ApiOperation("测试user")
    @GetMapping("/user")
    public User test(User user) {
        return new User("张三", "123456");
    }
}
