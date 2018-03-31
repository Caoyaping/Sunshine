package com.gdc.it99.sunshine.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdc.it99.baselib.commonhelper.utils.Check;
import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseRecyclerAdapter;
import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseViewHolder;
import com.gdc.it99.sunshine.R;
import com.gdc.it99.weather_core.api.weatherprovider.WeatherData;
import com.gdc.it99.weather_core.corebase.ResourceProvider;

import butterknife.BindView;

/**
 * Created by IT99 on 2018/3/28.
 */

public class HourWeatherHolder extends BaseViewHolder<HoursForecastData> {

    @BindView(R.id.hour)
    TextView hour;
    @BindView(R.id.hour_icon)
    ImageView hourIcon;
    @BindView(R.id.hour_temp)
    TextView hourTemp;

    public HourWeatherHolder(View itemView, BaseRecyclerAdapter mBaseRecycleAdapter) {
        super(itemView, mBaseRecycleAdapter);
    }

    @Override
    public int getContentViewId() {
        return R.layout.weather_item_hour_forecast;
    }

    @Override
    public void updateItem(HoursForecastData data, int position) {
        WeatherData.HoursForecastEntity hoursForecastData = data.hoursForecastData;
        if (Check.isNull(hoursForecastData)) {
            return;
        }
        hour.setText(hoursForecastData.getTime().substring(11, 16));
        hourIcon.setImageResource(ResourceProvider.getIconId(hoursForecastData.getWeather()));
        hourTemp.setText(hoursForecastData.getTemp());

    }
}
