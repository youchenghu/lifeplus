package com.hyc.lifeplus.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyc.lifeplus.account.enums.AccountingType;
import com.hyc.lifeplus.core.exception.HappyException;
import com.hyc.lifeplus.user.dto.AddUserAccountingDTO;
import com.hyc.lifeplus.user.entity.UserAccounting;
import com.hyc.lifeplus.user.dao.UserAccountingMapper;
import com.hyc.lifeplus.user.service.UserAccountingService;
import com.hyc.lifeplus.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 胡友成
 * @date 2021-05-11 22:11
 * @description
 */
@Service
public class UserAccountingServiceImpl extends ServiceImpl<UserAccountingMapper, UserAccounting> implements UserAccountingService {

    @Autowired
    UserService userService;

    @Override
    public void addUserAccounting(AddUserAccountingDTO dto) {

        Integer userId = dto.getUserId();
        if (userService.getById(userId) == null) {
            throw new HappyException("用户不存在！");
        }

        UserAccounting userAccounting = new UserAccounting();
        BeanUtil.copyProperties(dto, userAccounting, true);
        userAccounting.setCreateTime(LocalDateTime.now());
        save(userAccounting);
    }

    @Override
    public List<UserAccounting> pageUserAccounting(Integer userId, AccountingType type, IPage iPage) {
        QueryWrapper<UserAccounting> qw = new QueryWrapper<>();
        qw.eq("user_id", userId);
        qw.eq("type", type);
        qw.orderByDesc("create_time");
        return page(iPage, qw).getRecords();
    }
}
