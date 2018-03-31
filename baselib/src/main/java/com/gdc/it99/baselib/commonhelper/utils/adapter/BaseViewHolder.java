package com.gdc.it99.baselib.commonhelper.utils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by IT99 on 2018/3/28.
 */

public abstract class BaseViewHolder<T extends BaseAdapterData> extends RecyclerView.ViewHolder implements IProvideItemId {
    protected BaseRecyclerAdapter baseRecycleAdapter;
    private Context context;
    private LayoutInflater layoutInflater;

    protected Context getContext() {return context;}

    public BaseViewHolder(View itemView, BaseRecyclerAdapter mBaseRecycleAdapter) {
        super(itemView);
        baseRecycleAdapter = mBaseRecycleAdapter;
        setUIContext(itemView.getContext());

    }

    private void setUIContext(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public abstract void updateItem(T data,int position);

    protected  LayoutInflater getLayoutInflater() {return layoutInflater;}
}
