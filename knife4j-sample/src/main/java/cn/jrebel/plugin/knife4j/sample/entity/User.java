package cn.jrebel.plugin.knife4j.sample.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户")
public class User {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    private Integer sex;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
