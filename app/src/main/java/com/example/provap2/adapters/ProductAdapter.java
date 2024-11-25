package com.example.provap2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.provap2.ProductDetailsActivity;
import com.example.provap2.R;
import com.example.provap2.models.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private final List<Product> items;
    private final LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Product getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.product_list_item, parent, false);
        }

        Product item = getItem(position);

        RelativeLayout layout = view.findViewById(R.id.card);
        setOnClickListener(view, layout, item);

        TextView name = view.findViewById(R.id.productName);
        name.setText(item.getName());

        TextView price = view.findViewById(R.id.productPrice);
        price.setText(String.format("R$ %.2f", item.getPrice()));

        TextView offer = view.findViewById(R.id.productOffer);
        offer.setText(String.format("em até %d vezes sem juros", item.getOffer()));

        RatingBar rating = view.findViewById(R.id.ratingBar);
        rating.setRating(item.getRating());

        return view;
    }

    private void setOnClickListener(View view, RelativeLayout layout, Product item) {
        layout.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
            intent.putExtra("id", item.getId());
            view.getContext().startActivity(intent);
        });
    }
}
