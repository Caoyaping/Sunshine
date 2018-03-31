package com.gdc.it99.sunshine.ui.adapter;


import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseAdapterData;
import com.gdc.it99.sunshine.R;

/**
 * Created by SilenceDut on 16/10/17 .
 */

public class LifeIndexGuideData implements BaseAdapterData {

    String guide;

    public LifeIndexGuideData(String guide) {
        this.guide = guide;
    }

    @Override
    public int getContentViewId() {
        return R.layout.weather_item_index_guide;
    }
}
