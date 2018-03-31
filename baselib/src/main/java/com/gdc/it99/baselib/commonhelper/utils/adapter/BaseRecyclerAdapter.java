package com.gdc.it99.baselib.commonhelper.utils.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdc.it99.baselib.commonhelper.utils.Check;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT99 on 2018/3/28.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private SparseArray<Class<? extends BaseViewHolder >> typeHolders = new SparseArray();
    private List<BaseAdapterData> mData = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    protected HolderClickListener mHolderClickListener;

    public interface HolderClickListener <T extends BaseAdapterData>{
        void onHolderClicked(int position,T data);
    }

    public BaseRecyclerAdapter(Context context){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

    }

    public void registerHolder(Class<? extends BaseViewHolder> viewHolder,List<? extends BaseAdapterData> data){
        if (Check.isEmpty(data)) {
            return;
        }
        typeHolders.put(data.get(0).getContentViewId(), viewHolder);
        addData(data);

    }

    public void setData(List<? extends BaseAdapterData> data) {
        if (Check.isEmpty(data)) {
            return;
        }
        mData.clear();
        addData(data);
    }
    public void registerHolder(Class<? extends BaseViewHolder> viewHolder, int itemViewType) {
        typeHolders.put(itemViewType, viewHolder);
    }
    
    public <T extends BaseAdapterData> void registerHolder(Class<? extends BaseViewHolder> viewHolder, T data) {
        if (data ==null){
            return;
        }
        typeHolders.put(data.getContentViewId(), viewHolder);
        addData(data);
    }

    public  <T extends BaseAdapterData> void addData(T data) {
        if (data == null){
            return;
        }
        mData.add(data);

        notifyDataSetChanged();
    }
    public void addData(List<? extends BaseAdapterData> data) {
        if (data == null) {
            return;
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mInflater.inflate(viewType,parent,false);
        BaseViewHolder viewHolder = new NoDataViewHolder(item, this);
        Class<?> cls = typeHolders.get(viewType);
        try {
            Constructor holderConstructor = cls.getDeclaredConstructor(View.class, BaseRecyclerAdapter.class);
            holderConstructor.setAccessible(true);
            viewHolder = (BaseViewHolder) holderConstructor.newInstance(item, this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return viewHolder;
    }

    public List<BaseAdapterData> getData () {
        return mData;
    }

    public void clear() {
        mData.clear();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (Check.isEmpty(mData) || Check.isNull(mData.get(position))) {
            return;
        }
        if (getItemViewType(position) != holder.getContentViewId()) {
            return;
        }

        holder.updateItem(mData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public int getItemViewType(int position) {
        return mData.get(position).getContentViewId();
    }
}
