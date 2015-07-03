package com.paddy.desi.dime.app.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.paddy.desi.dime.app.R;
import com.paddy.desi.dime.app.models.Deal;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Shrikant on 17-06-2015.
 */
public class DealsCustomListAdapter extends RecyclerView.Adapter<DealsCustomListAdapter.ContactViewHolder> {

    static ArrayList<Deal> customerList;

    Context context;

    public DealsCustomListAdapter(Context context, ArrayList<Deal> customerList) {
        this.customerList = customerList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {

        Deal ci = customerList.get(i);
        contactViewHolder.txt_Product_name.setText(ci.gettitle());
        contactViewHolder.txt_Product_description.setText(Html.fromHtml(ci.getdeal_detail()));
        Picasso.with(context).load(ci.getimage_thumb()).into(contactViewHolder.img_product_thumnail);
        contactViewHolder.txt_chat_count.setText("" + ci.getcomments_count());
        contactViewHolder.txt_share_count.setText("" + ci.getpopularity_count());
        contactViewHolder.txt_prise.setText("\u20B9 " + ci.getcurrent_price());
        try {
            contactViewHolder.txt_merchant_name.setText("at " + ci.getmerchant().getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.topdeal_custom_row, viewGroup, false);
        return new ContactViewHolder(itemView, context);
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