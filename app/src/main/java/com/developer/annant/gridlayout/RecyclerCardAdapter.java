package com.developer.annant.gridlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Annant on 27-04-2017.
 */

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.MyViewHolder>  {
    private List<ProductDataVariable> productList;
    private Context context;
    public RecyclerCardAdapter(Context context,List<ProductDataVariable> productList) {
        this.productList = productList;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public ImageView thumbImage;
        public TextView productName;
        public TextView debitRs;
        public TextView rentRs;

        public MyViewHolder(View itemView) {
            super(itemView);
            thumbImage = (ImageView) itemView.findViewById(R.id.image_card);
            productName = (TextView) itemView.findViewById(R.id.text_name_product);
            debitRs = (TextView) itemView.findViewById(R.id.text_deposit);
            rentRs = (TextView) itemView.findViewById(R.id.text_rent);
        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_template, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductDataVariable currentVariable = productList.get(position);
        holder.thumbImage.setImageResource(currentVariable.getThumbImageResourceId());
        holder.productName.setText(currentVariable.getProductName());
        holder.debitRs.setText(String.valueOf(currentVariable.getDebitRs()));
        holder.rentRs.setText(String.valueOf(currentVariable.getRentRs()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
