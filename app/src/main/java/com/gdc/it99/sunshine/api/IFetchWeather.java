package com.gdc.it99.sunshine.api;

import com.gdc.it99.weather_core.api.ICoreApi;

import java.util.List;

/**
 * Created by IT99 on 2018/3/21.
 */

public interface IFetchWeather extends ICoreApi {
    void queryWeather(String cityId);
    void queryWeather(List<String> citys);

}
