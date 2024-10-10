package com.atguigu.daijia.driver.service;

import com.atguigu.daijia.model.vo.driver.DriverLicenseOcrVo;
import com.atguigu.daijia.model.vo.driver.IdCardOcrVo;
import org.springframework.web.multipart.MultipartFile;

public interface OcrService {

    /**
     * 身份证认证
     * @param file
     * @return
     */
    IdCardOcrVo idCardOcr(MultipartFile file);

    /**
     * 驾驶证认证
     * @param file
     * @return
     */
    DriverLicenseOcrVo driverLicenseOcr(MultipartFile file);
}
