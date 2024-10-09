package com.atguigu.daijia.customer.service.impl;

import com.atguigu.daijia.common.constant.RedisConstant;
import com.atguigu.daijia.common.execption.GuiguException;
import com.atguigu.daijia.common.result.Result;
import com.atguigu.daijia.common.result.ResultCodeEnum;
import com.atguigu.daijia.customer.client.CustomerInfoFeignClient;
import com.atguigu.daijia.customer.service.CustomerService;
import com.atguigu.daijia.model.vo.customer.CustomerLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerInfoFeignClient customerInfoFeignClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(String code) {
        // 获取用户id
        Result<Long> result = customerInfoFeignClient.login(code);
        if(result.getCode().intValue() != ResultCodeEnum.SUCCESS.getCode()){
            throw new GuiguException(result.getCode(), result.getMessage());
        }
        Long customerId = result.getData();
        if(customerId == null){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }

        // 将token存到redis中
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(RedisConstant.USER_LOGIN_KEY_PREFIX + token, customerId.toString(), RedisConstant.USER_LOGIN_KEY_TIMEOUT, TimeUnit.SECONDS);
        return token;
    }

  /*  @Override
    public CustomerLoginVo getCustomerLoginInfo(String token) {
        // 根据token查询redis
        String customerId = (String)redisTemplate.opsForValue().get(RedisConstant.USER_LOGIN_KEY_PREFIX + token);
        if(!StringUtils.hasText(customerId)){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }

        // 远程调用查询登录信息
        Result<CustomerLoginVo> result = customerInfoFeignClient.getCustomerLoginInfo(Long.parseLong(customerId));
        Integer code = result.getCode();
        if(code.intValue() != ResultCodeEnum.SUCCESS.getCode()){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }
        CustomerLoginVo customerLoginVo = result.getData();
        if(customerLoginVo == null){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }
        return customerLoginVo;
    }*/

    public CustomerLoginVo getCustomerLoginInfo(Long customerId) {
        // 远程调用查询登录信息
        Result<CustomerLoginVo> result = customerInfoFeignClient.getCustomerLoginInfo(customerId);
        Integer code = result.getCode();
        if(code.intValue() != ResultCodeEnum.SUCCESS.getCode()){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }
        CustomerLoginVo customerLoginVo = result.getData();
        if(customerLoginVo == null){
            throw new GuiguException(ResultCodeEnum.DATA_ERROR);
        }
        return customerLoginVo;
    }
}
