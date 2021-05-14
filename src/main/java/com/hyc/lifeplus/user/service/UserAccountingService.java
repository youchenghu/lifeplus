package com.hyc.lifeplus.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyc.lifeplus.account.enums.AccountingType;
import com.hyc.lifeplus.user.dto.AddUserAccountingDTO;
import com.hyc.lifeplus.user.entity.UserAccounting;

import java.util.List;

/**
 * @author 胡友成
 * @date 2021-05-11 22:11
 * @description
 */
public interface UserAccountingService extends IService<UserAccounting> {

    /**
     * 新增用户记账记录
     * @param dto
     */
    void addUserAccounting(AddUserAccountingDTO dto);

    /**
     * 按类型获取用户记账信息列表
     * @param userId
     * @param type
     * @return
     */
    List<UserAccounting> pageUserAccounting(Integer userId, AccountingType type, IPage iPage);
}
