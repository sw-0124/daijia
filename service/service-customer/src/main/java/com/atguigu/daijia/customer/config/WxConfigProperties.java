package com.atguigu.daijia.customer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: WxPropertiesConfig
 * Description:
 * <p>
 * DateTime: 2024/10/8 20:31
 * Author: 悉达多@NWAFU
 * Version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "wx.miniapp")
@Component
public class WxConfigProperties {
    private String appId;
    private String secret;
}
