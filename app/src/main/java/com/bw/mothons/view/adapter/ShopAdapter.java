package com.bw.mothons.view.adapter;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.mothons.R;
import com.bw.mothons.model.bean.ShopBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DateTime:2020/4/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class ShopAdapter extends BaseExpandableListAdapter {
    private List<ShopBean.OrderDataBean> mOrderData;

    public ShopAdapter(List<ShopBean.OrderDataBean> orderData) {

        mOrderData = orderData;
    }

    @Override
    public int getGroupCount() {
        return mOrderData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mOrderData.get(i).getCartlist().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewGroupHolder viewGroupHolder = null;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.group_item, null);
            viewGroupHolder = new ViewGroupHolder(view);
            view.setTag(viewGroupHolder);
        } else {
            viewGroupHolder = (ViewGroupHolder) view.getTag();
        }
        ShopBean.OrderDataBean orderDataBean = mOrderData.get(i);
        viewGroupHolder.groupName.setText(orderDataBean.getShopName());
        List<ShopBean.OrderDataBean.CartlistBean> cartlist = orderDataBean.getCartlist();
        boolean c = true;
        for (int j = 0; j < cartlist.size(); j++) {
            ShopBean.OrderDataBean.CartlistBean cartlistBean = cartlist.get(j);
            if (cartlistBean.isChecked() == false) {
                c = false;
            }
        }
        notifyDataSetChanged();
        viewGroupHolder.groupCheck.setChecked(c);
        boolean finalC = c;
        viewGroupHolder.groupCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int j = 0; j < cartlist.size(); j++) {
                    boolean v = finalC;
                    v = !v;
                    ShopBean.OrderDataBean.CartlistBean cartlistBean = cartlist.get(j);
                    cartlistBean.setChecked(v);
                }
                notifyDataSetChanged();
                if (mOnClickListener != null) {
                    mOnClickListener.onClick();
                }
            }
        });
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewChildHolder viewChildHolder = null;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.child_item, null);
            viewChildHolder = new ViewChildHolder(view);
            view.setTag(viewChildHolder);
        } else {
            viewChildHolder = (ViewChildHolder) view.getTag();
        }
        ShopBean.OrderDataBean.CartlistBean cartlistBean = mOrderData.get(i).getCartlist().get(i1);
        viewChildHolder.name.setText(cartlistBean.getShopName());
        viewChildHolder.yanse.setText(cartlistBean.getColor());
        viewChildHolder.price.setText(cartlistBean.getPrice() + "");
        viewChildHolder.childCheck.setChecked(cartlistBean.isChecked());
        Uri parse = Uri.parse(cartlistBean.getDefaultPic());
        viewChildHolder.img.setImageURI(parse);
        viewChildHolder.childCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = cartlistBean.isChecked();
                cartlistBean.setChecked(!checked);
                notifyDataSetChanged();
                if (mOnClickListener != null) {
                    mOnClickListener.onClick();
                }
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    static
    class ViewGroupHolder {
        @BindView(R.id.group_check)
        CheckBox groupCheck;
        @BindView(R.id.group_name)
        TextView groupName;

        ViewGroupHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewChildHolder {
        @BindView(R.id.child_check)
        CheckBox childCheck;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.yanse)
        TextView yanse;
        @BindView(R.id.price)
        TextView price;

        ViewChildHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public float getPricess(){
        float prices=0;
        for (int i = 0; i <mOrderData.size() ; i++) {
            ShopBean.OrderDataBean orderDataBean = mOrderData.get(i);
            List<ShopBean.OrderDataBean.CartlistBean> cartlist = orderDataBean.getCartlist();
            for (int j = 0; j <cartlist.size() ; j++) {
                ShopBean.OrderDataBean.CartlistBean cartlistBean = cartlist.get(j);
                if(cartlistBean.isChecked()){
                    int price = cartlistBean.getPrice();
                    int count = cartlistBean.getCount();
                    prices+=price*count;
                }

            }
        }
        return prices;
    }
    public boolean allChecked(){
        boolean z=true;
        for (int i = 0; i <mOrderData.size() ; i++) {
            ShopBean.OrderDataBean orderDataBean = mOrderData.get(i);
            List<ShopBean.OrderDataBean.CartlistBean> cartlist = orderDataBean.getCartlist();
            for (int j = 0; j <cartlist.size() ; j++) {
                ShopBean.OrderDataBean.CartlistBean cartlistBean = cartlist.get(j);
                if(cartlistBean.isChecked()==false){
                    z=false;
                }
            }
        }
        return z;
    }
    public boolean allCheckedStatus(boolean ss){
        boolean z=true;
        for (int i = 0; i <mOrderData.size() ; i++) {
            ShopBean.OrderDataBean orderDataBean = mOrderData.get(i);
            List<ShopBean.OrderDataBean.CartlistBean> cartlist = orderDataBean.getCartlist();
            for (int j = 0; j <cartlist.size() ; j++) {
                ShopBean.OrderDataBean.CartlistBean cartlistBean = cartlist.get(j);
                cartlistBean.setChecked(ss);
                z=ss;
            }
        }
        notifyDataSetChanged();
        return z;
    }

    OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick();
    }
}
