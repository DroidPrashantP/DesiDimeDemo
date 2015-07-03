package com.paddy.desi.dime.app.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.paddy.desi.dime.app.R;
import com.paddy.desi.dime.app.models.Deal;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Shrikant on 03-07-2015.
 */
public class CustomGridAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<Deal> DealsList;
    private LayoutInflater mLayoutInflater = null;

    public CustomGridAdapter(Context context,
                            ArrayList<Deal> DealsList) {
        this.mContext = context;
        this.DealsList = DealsList;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return DealsList.size();
    }

    @Override
    public Deal getItem(int pos) {
        return DealsList.get(pos);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ContactViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.dealsgridview, null);
            viewHolder = new ContactViewHolder(v,mContext);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ContactViewHolder) v.getTag();
        }
        Deal ci = DealsList.get(position);
        viewHolder.txt_Product_name.setText(ci.gettitle());
        viewHolder.txt_Product_description.setText(Html.fromHtml(ci.getdeal_detail()));
        Picasso.with(mContext).load(ci.getimage_thumb()).into(viewHolder.img_product_thumnail);
        viewHolder.txt_chat_count.setText("" + ci.getcomments_count());
        viewHolder.txt_share_count.setText("" + ci.getpopularity_count());
        viewHolder.txt_prise.setText("\u20B9 " + ci.getcurrent_price());
        try {
            viewHolder.txt_merchant_name.setText("at " + ci.getmerchant().getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return v;
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView txt_Product_name;
        protected TextView txt_Product_description;
        protected TextView txt_chat_count;
        protected TextView txt_share_count;
        protected TextView txt_merchant_name;
        protected TextView txt_prise;
        protected ImageView img_product_thumnail;
        protected RelativeLayout main_layout;
        CardView card_view;
        Context holdercontext;


        public ContactViewHolder(View v, final Context context) {
            super(v);
            this.holdercontext = context;
            txt_Product_name = (TextView) v.findViewById(R.id.txt_product_name);
            txt_Product_description = (TextView) v.findViewById(R.id.txt_product_description);
            txt_chat_count = (TextView) v.findViewById(R.id.chat_count);
            txt_share_count = (TextView) v.findViewById(R.id.share_count);
            txt_merchant_name = (TextView) v.findViewById(R.id.txt_product_title);
            txt_prise = (TextView) v.findViewById(R.id.txt_prise);
            img_product_thumnail = (ImageView) v.findViewById(R.id.main_image);
            main_layout = (RelativeLayout) v.findViewById(R.id.main_layout);
            card_view = (CardView) v.findViewById(R.id.card_view);
            card_view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
        }
    }
}
