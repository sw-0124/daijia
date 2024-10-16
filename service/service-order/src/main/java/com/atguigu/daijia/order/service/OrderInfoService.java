package com.atguigu.daijia.order.service;

import com.atguigu.daijia.model.entity.order.OrderInfo;
import com.atguigu.daijia.model.form.order.OrderInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 乘客下单 保存订单信息
     * @param orderInfoForm
     * @return
     */
    Long saveOrderInfo(OrderInfoForm orderInfoForm);

    /**
     * 获取订单状态
     * @param orderId
     * @return
     */
    Integer getOrderStatus(Long orderId);
}
