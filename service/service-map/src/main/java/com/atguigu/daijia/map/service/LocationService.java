package com.atguigu.daijia.map.service;

import com.atguigu.daijia.model.form.map.SearchNearByDriverForm;
import com.atguigu.daijia.model.form.map.UpdateDriverLocationForm;
import com.atguigu.daijia.model.vo.map.NearByDriverVo;

import java.util.List;

public interface LocationService {

    /**
     * 更新司机位置 前端会实时传数据来更新
     * @param updateDriverLocationForm
     * @return
     */
    Boolean updateDriverLocation(UpdateDriverLocationForm updateDriverLocationForm);

    /**
     * 删除司机位置
     * @param driverId
     * @return
     */
    Boolean removeDriverLocation(Long driverId);

    /**
     * 搜索附近适合接单的司机
     * @param searchNearByDriverForm
     * @return
     */
    List<NearByDriverVo> searchNearByDriver(SearchNearByDriverForm searchNearByDriverForm);
}
