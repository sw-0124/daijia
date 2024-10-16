package com.atguigu.daijia.customer.controller;

import com.atguigu.daijia.common.login.GuiguLogin;
import com.atguigu.daijia.common.result.Result;
import com.atguigu.daijia.common.util.AuthContextHolder;
import com.atguigu.daijia.customer.service.CustomerService;
import com.atguigu.daijia.model.form.customer.UpdateWxPhoneForm;
import com.atguigu.daijia.model.vo.customer.CustomerLoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "客户API接口管理")
@RestController
@RequestMapping("/customer")
@SuppressWarnings({"unchecked", "rawtypes"})
public class CustomerController {

    @Autowired
    private CustomerService customerInfoService;

    @Operation(summary = "更新用户微信手机号")
    @PostMapping("/updateWxPhone")
    public Result gupdateWxPhone(@RequestBody UpdateWxPhoneForm updateWxPhoneForm) {
        updateWxPhoneForm.setCustomerId(AuthContextHolder.getUserId());
        // 个人版无法获取手机号 这里直接返回
        //customerInfoService.updateWxPhoneNumber(updateWxPhoneForm);
        return Result.ok(true);
    }

    @Operation(summary = "获取客户登录信息")
    @GetMapping("/getCustomerLoginInfo")
    @GuiguLogin
    public Result<CustomerLoginVo> getCustomerLoginInfo() {
        // 在这里获取乘客id 最后传给client 因为两个不是服务不是同一个线程
        //todo
        // 还有一种解决方法 使用FeignClient的远程 请求头传参
        Long customerId = AuthContextHolder.getUserId();
        return Result.ok(customerInfoService.getCustomerLoginInfo(customerId));
    }

    @Operation(summary = "小程序授权登录")
    @GetMapping("/login/{code}")
    public Result<String> wxLogin(@PathVariable String code) {
        return Result.ok(customerInfoService.login(code));
    }

}

