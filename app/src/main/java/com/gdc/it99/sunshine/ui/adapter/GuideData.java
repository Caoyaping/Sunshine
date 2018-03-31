package com.gdc.it99.sunshine.ui.adapter;


import com.gdc.it99.baselib.commonhelper.utils.adapter.BaseAdapterData;
import com.gdc.it99.sunshine.R;

/**
 * Created by SilenceDut on 16/10/22.
 */

public class GuideData implements BaseAdapterData {
    public String guide;
    public int guideIconId;

    public GuideData(String guide) {
        this.guide = guide;
    }

    public void setGuideIconId(int guideIconId) {
        this.guideIconId = guideIconId;
    }

    @Override
    public int getContentViewId() {
        return R.layout.weather_item_guide;
    }
}
