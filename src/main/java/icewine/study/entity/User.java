package icewine.study.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class User {

    @ApiModelProperty("用户名")
    String name;
    @ApiModelProperty("密码")
    String password;
}
