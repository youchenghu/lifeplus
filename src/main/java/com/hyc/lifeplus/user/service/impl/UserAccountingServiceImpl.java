package com.hyc.lifeplus.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.account.enums.AccountingType;
import com.hyc.lifeplus.user.entity.UserAccounting;
import com.hyc.lifeplus.user.dao.UserAccountingMapper;
import com.hyc.lifeplus.user.service.UserAccountingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胡友成
 * @date 2021-05-11 22:11
 * @description
 */
@Service
public class UserAccountingServiceImpl extends ServiceImpl<UserAccountingMapper, UserAccounting> implements UserAccountingService {

    @Override
    public List<UserAccounting> pageUserAccounting(Integer userId, AccountingType type, IPage iPage) {
        QueryWrapper<UserAccounting> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        qw.eq("type", type);
        return page(iPage, qw).getRecords();
    }
}
