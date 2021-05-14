package com.hyc.lifeplus.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hyc.lifeplus.account.enums.AccountType;
import com.hyc.lifeplus.account.enums.AccountingType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：胡友成
 * @date ：2021/5/13 9:47 下午
 * @description：
 */
@Data
public class AddUserAccountingDTO {

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("金额（分）")
    private Integer amount;

    @ApiModelProperty("账户类型")
    private AccountType accountType;

    @ApiModelProperty("目的")
    private String purpose;

    @ApiModelProperty("目的类型")
    private String purposeType;

    @ApiModelProperty("类型")
    private AccountingType type;
}
