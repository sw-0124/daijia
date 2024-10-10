package com.atguigu.daijia.driver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName: TencentCloudProperties
 * Description:
 * <p>
 * DateTime: 2024/10/9 21:27
 * Author: 悉达多@NWAFU
 * Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent.cloud")
public class TencentCloudProperties {

    private String secretId;
    private String secretKey;
    private String region;
    private String bucketPrivate;

    private String personGroupId;
}