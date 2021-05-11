package com.hyc.lifeplus.core.web;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyc.lifeplus.core.exception.HappyException;
import com.hyc.lifeplus.core.util.HappyUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：胡友成
 * @date ：2021/5/11
 * @description：
 */
public class PageFactory {

    /**
     * 最大的每页显示条数
     * -1 表示不限制
     */
    private static int maxPageSize = -1;

    public static void init(PageSizeLimiter limiter){
        if(limiter != null){
            maxPageSize = limiter.getPageSizeMax();
        }
    }

    /**
     * 将 BasePage 转换成 IPage
     */
    public static <T> IPage<T> convertPage(BasePage basePage) {
        if (basePage == null) {
            return new Page<>(1, 10);
        }
        Page<T> page = new Page<>(basePage.getPage(), basePage.getSize());
        if (StrUtil.isNotEmpty(basePage.getAscs())) {
            for (String asc : basePage.getAscs().split(",")) {
                if (StrUtil.isNotEmpty(asc)) {
                    page.addOrder(OrderItem.asc(StrUtil.toSymbolCase(illegalStringValidate(asc), '_')));
                }
            }
        }
        if (StrUtil.isNotEmpty(basePage.getDescs())) {
            for (String desc : basePage.getDescs().split(",")) {
                if (StrUtil.isNotEmpty(desc)) {
                    page.addOrder(OrderItem.desc(StrUtil.toSymbolCase(illegalStringValidate(desc), '_')));
                }
            }
        }

        if(maxPageSize > 0 && page.getSize() > maxPageSize){
            page.setSize(maxPageSize);
        }

        return page;
    }

    /**
     * 从 Request 中获取 Parameter 构造 IPage
     */
    public static <T> IPage<T> convertPageByParameters() {
        HttpServletRequest request = HappyUtil.getRequest();
        if (request == null) {
            return new Page<>(1, 10);
        }
        int page = 1;
        int size = 10;
        String pageString = request.getParameter("page");
        if (StrUtil.isNotEmpty(pageString)) {
            try {
                page = Integer.parseInt(pageString);
            } catch (NumberFormatException ignored) {
            }
        }
        String sizeString = request.getParameter("size");
        if (StrUtil.isNotEmpty(sizeString)) {
            try {
                size = Integer.parseInt(sizeString);
            } catch (NumberFormatException ignored) {
            }
        }

        Page<T> p = new Page<>(page, size);

        String ascs = request.getParameter("ascs");
        if (StrUtil.isNotEmpty(ascs)) {
            for (String asc : ascs.split(",")) {
                if (StrUtil.isNotEmpty(asc)) {
                    p.addOrder(OrderItem.asc(StrUtil.toSymbolCase(illegalStringValidate(asc), '_')));
                }
            }
        }

        String descs = request.getParameter("descs");
        if (StrUtil.isNotEmpty(descs)) {
            for (String desc : descs.split(",")) {
                if (StrUtil.isNotEmpty(desc)) {
                    p.addOrder(OrderItem.desc(StrUtil.toSymbolCase(illegalStringValidate(desc), '_')));
                }
            }
        }

        if (CollUtil.isEmpty(p.getOrders())) {
            // 兼容前端老代码
            String[] sorts = request.getParameterValues("sort");
            if (ArrayUtil.isNotEmpty(sorts)) {
                for (String sort : sorts) {
                    if (StrUtil.isNotEmpty(sort)) {
                        String[] s = sort.split(",");
                        String property = s[0];
                        String direction = "asc";
                        if (s.length > 1) {
                            direction = "asc".equalsIgnoreCase(s[1]) ? "asc" : "desc";
                        }

                        if ("asc".equals(direction)) {
                            p.addOrder(OrderItem.asc(StrUtil.toSymbolCase(illegalStringValidate(property), '_')));
                        } else {
                            p.addOrder(OrderItem.desc(StrUtil.toSymbolCase(illegalStringValidate(property), '_')));
                        }
                    }
                }
            }
        }

        if(maxPageSize > 0 && p.getSize() > maxPageSize){
            p.setSize(maxPageSize);
        }

        return p;
    }

    /**
     * 泛型转换
     */
    public static <T> IPage<T> convertPage(IPage iPage) {
        return (IPage<T>) iPage;
    }

    /**
     * 构造分页结果集，用于返回给前端
     */
    public static PageResult buildPageResult(IPage<?> iPage, List<?> data) {
        PageResult result = new PageResult();
        result.setData(data);
        result.setTotal(iPage.getTotal());
        result.setBegin(iPage.offset());
        result.setSize(iPage.getSize());
        result.setCurrentPage(iPage.getCurrent());
        result.setTotalPage(iPage.getPages());

        String ascs = iPage.orders().stream()
                .filter(OrderItem::isAsc)
                .map(item -> StrUtil.toCamelCase(item.getColumn()))
                .collect(Collectors.joining(","));
        result.setAscs(ascs);

        String descs = iPage.orders().stream()
                .filter(orderItem -> !orderItem.isAsc())
                .map(item -> StrUtil.toCamelCase(item.getColumn()))
                .collect(Collectors.joining(","));
        result.setDescs(descs);

        return result;
    }

    private static String illegalStringValidate(String str) {
        String s = StrUtil.trim(str);
        if (StrUtil.isEmpty(s)) {
            return "";
        }

        if (!ReUtil.isMatch("\\w+", s)) {
            throw new HappyException("非法字符： {}", s);
        }
        return s;
    }
}
