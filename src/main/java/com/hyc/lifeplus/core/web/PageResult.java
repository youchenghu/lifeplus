package com.hyc.lifeplus.core.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
@Data
@ApiModel
public class PageResult {

    @ApiModelProperty(value = "数据列表")
    protected List<?> data;

    @ApiModelProperty(value = "总数")
    protected long total = 0;

    @ApiModelProperty(value = "起始记录号")
    protected long begin = 0;

    @ApiModelProperty(value = "每页显示条数")
    protected long size = 10;

    @ApiModelProperty(value = "当前页")
    protected long currentPage = 1;

    @ApiModelProperty(value = "总页数")
    protected long totalPage = 0;

    @ApiModelProperty(value = "升序字段，多个逗号分隔")
    protected String ascs;

    @ApiModelProperty(value = "降序字段，多个逗号分隔")
    protected String descs;

}
