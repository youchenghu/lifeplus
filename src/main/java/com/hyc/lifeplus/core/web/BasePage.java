package com.hyc.lifeplus.core.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@Data
@ApiModel
public abstract class BasePage {

    @ApiModelProperty(value = "查询的页码")
    protected int page = 1;

    @ApiModelProperty(value = "每页显示的数量")
    protected int size = 10;

    @ApiModelProperty(value = "升序字段，多个逗号分隔")
    protected String ascs;

    @ApiModelProperty(value = "降序字段，多个逗号分隔")
    protected String descs;

}
