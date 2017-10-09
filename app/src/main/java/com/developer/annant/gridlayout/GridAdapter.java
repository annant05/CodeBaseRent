package com.developer.annant.gridlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Annant on 27-04-2017.
 */

public class GridAdapter extends ArrayAdapter<ProductDataVariable> {


    private LayoutInflater layoutInflater;

    public GridAdapter(Context context, List<ProductDataVariable> productAdapter) {
       super(context,0,productAdapter);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = layoutInflater.inflate(R.layout.card_view_template, parent,false);
        }

        ImageView thumbImage = (ImageView) gridView.findViewById(R.id.image_card);
        TextView productName  = (TextView) gridView.findViewById(R.id.text_name_product);
        TextView debitRs = (TextView) gridView.findViewById(R.id.text_deposit);
        TextView rentRs = (TextView) gridView.findViewById(R.id.text_rent);

        ProductDataVariable currentVariable = getItem(position);

        thumbImage.setImageResource(currentVariable.getThumbImageResourceId());
        productName.setText(currentVariable.getProductName());
        debitRs.setText(String.valueOf(currentVariable.getDebitRs()));
        rentRs.setText(String.valueOf(currentVariable.getRentRs()));



        return gridView;
    }
}
