package com.gdc.it99.baselib.commonhelper.utils.adapter;

import android.view.View;

/**
 * Created by IT99 on 2018/3/28.
 */

public class NoDataViewHolder extends BaseViewHolder {
    public NoDataViewHolder(View itemView, BaseRecyclerAdapter mBaseRecycleAdapter) {
        super(itemView, mBaseRecycleAdapter);
    }

    @Override
    public int getContentViewId() {
        return 0;
    }

    @Override
    public void updateItem(BaseAdapterData data, int position) {

    }
}
