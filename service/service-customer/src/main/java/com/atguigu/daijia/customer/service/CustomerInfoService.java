package com.atguigu.daijia.customer.service;

import com.atguigu.daijia.model.entity.customer.CustomerInfo;
import com.atguigu.daijia.model.vo.customer.CustomerInfoVo;
import com.atguigu.daijia.model.vo.customer.CustomerLoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CustomerInfoService extends IService<CustomerInfo> {

    /**
     * 用户登录接口
     * @param code
     * @return
     */
    Long login(String code);

    /**
     * 获取用户信息
     * @param customerId
     * @return
     */
    CustomerLoginVo getCustomerLoginInfo(Long customerId);
}
