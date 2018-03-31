package com.gdc.it99.sunshine.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.gdc.it99.baselib.commonhelper.utils.Check;
import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseRecyclerAdapter;
import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseViewHolder;
import com.gdc.it99.baselib.commonhelper.utils.util.TimeUtil;
import com.gdc.it99.sunshine.R;
import com.gdc.it99.weather_core.api.weatherprovider.WeatherData;
import com.gdc.it99.weather_core.corebase.ResourceProvider;

import butterknife.BindView;

/**
 * Created by SilenceDut on 16/10/20.
 */

public class DailyWeatherHolder extends BaseViewHolder<DailyWeatherData> {

    @BindView(R.id.date_week)
    TextView dateWeek;
    @BindView(R.id.weather_status_daily)
    TextView weatherStatusDaily;
    @BindView(R.id.weather_icon_daily)
    ImageView weatherIconDaily;
    @BindView(R.id.temp_daily)
    TextView tempDaily;

    public DailyWeatherHolder(View itemView, BaseRecyclerAdapter baseRecyclerAdapter) {
        super(itemView, baseRecyclerAdapter);
    }

    @Override
    public void updateItem(DailyWeatherData data, int position) {
        WeatherData.DailyForecastEntity dailyForecastData = data.dailyForecastData;
        if (Check.isNull(dailyForecastData)) {
            return;
        }

        if(dailyForecastData.getWeek().equals(TimeUtil.getWeek(TimeUtil.getMopnthDay()))) {
            dateWeek.setText("今天");
        }else {
            dateWeek.setText(dailyForecastData.getWeek());
        }

        weatherStatusDaily.setText(dailyForecastData.getWeather());
        tempDaily.setText(dailyForecastData.getTemp_range());
        weatherIconDaily.setImageResource(ResourceProvider.getIconId(dailyForecastData.getWeather()));
    }

    @Override
    public int getContentViewId() {
        return R.layout.weather_item_daily_forecast;
    }

}
