package com.season.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.season.domain.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public String getCity() {
        String cityName="温岭";
        if(cityDubboService!=null) {
            City city = cityDubboService.findCityByName(cityName);
            return city.toString();
        }
        return null;
    }
}
