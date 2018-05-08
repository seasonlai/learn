package com.season.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.season.domain.City;

/**
 * Created by Administrator on 2018/5/8.
 */
@Service(version = "1.0.0")
public class CityDuboServiceImpl implements CityDubboService {

    @Override
    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
