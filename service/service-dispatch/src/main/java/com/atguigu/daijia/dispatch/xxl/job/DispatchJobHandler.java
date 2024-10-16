package com.atguigu.daijia.dispatch.xxl.job;

/**
 * ClassName: DispatchJobHandler
 * Description:
 * <p>
 * DateTime: 2024/10/13 10:05
 * Author: 悉达多@NWAFU
 * Version: 1.0
 */
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class DispatchJobHandler {

    @XxlJob("firstJobHandler")
    public void firstJobHandler() {
        log.info("xxl-job项目集成测试");
    }
}