package com.gdc.it99.sunshine.ui.adapter;



import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseAdapterData;
import com.gdc.it99.sunshine.R;
import com.gdc.it99.weather_core.api.weatherprovider.WeatherData;

import java.util.List;

/**
 * Created by SilenceDut on 16/10/25.
 */

public class LifeIndexData implements BaseAdapterData {

    public List<WeatherData.LifeIndexEntity> lifeIndexesData;

    public LifeIndexData(List<WeatherData.LifeIndexEntity> lifeIndexesData) {
        this.lifeIndexesData = lifeIndexesData;
    }

    @Override
    public int getContentViewId() {
        return R.layout.weather_item_life;
    }
}
