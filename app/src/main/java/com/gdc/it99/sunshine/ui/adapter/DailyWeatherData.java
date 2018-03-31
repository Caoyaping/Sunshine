package com.gdc.it99.sunshine.ui.adapter;

import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseAdapterData;
import com.gdc.it99.sunshine.R;
import com.gdc.it99.weather_core.api.weatherprovider.WeatherData;

/**
 * Created by IT99 on 2018/3/29.
 */

public class DailyWeatherData implements BaseAdapterData {

    public WeatherData.DailyForecastEntity dailyForecastData;

    public DailyWeatherData (WeatherData.DailyForecastEntity dailyForecastData) {
        this.dailyForecastData = dailyForecastData;
    }
    @Override
    public int getContentViewId() {
        return R.layout.weather_item_daily_forecast;
    }
}
