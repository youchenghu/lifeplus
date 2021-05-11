package com.hyc.lifeplus.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.hyc.lifeplus.account.enums.AccountType;
import com.hyc.lifeplus.account.enums.AccountingType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 胡友成
 * @since 2021-05-11 22:11
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_accounting")
@ApiModel(value="UserAccounting对象", description="")
public class UserAccounting implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("金额（分）")
    @TableField("amount")
    private Integer amount;

    @ApiModelProperty("账户类型")
    @TableField("account_type")
    private AccountType accountType;

    @ApiModelProperty("目的")
    @TableField("purpose")
    private String purpose;

    @ApiModelProperty("目的类型")
    @TableField("purpose_type")
    private String purposeType;

    @ApiModelProperty("发生时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("类型")
    @TableField("type")
    private AccountingType type;

}
