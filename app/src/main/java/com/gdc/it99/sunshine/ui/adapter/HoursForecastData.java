package com.gdc.it99.sunshine.ui.adapter;

import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseAdapterData;
import com.gdc.it99.sunshine.R;
import com.gdc.it99.weather_core.api.weatherprovider.WeatherData;

/**
 * Created by IT99 on 2018/3/28.
 */

public class HoursForecastData implements BaseAdapterData {

    public WeatherData.HoursForecastEntity hoursForecastData;

    public HoursForecastData(WeatherData.HoursForecastEntity hoursForecastData){
        this.hoursForecastData = hoursForecastData;
    }
    @Override
    public int getContentViewId() {
        return R.layout.weather_item_hour_forecast;
    }
}
