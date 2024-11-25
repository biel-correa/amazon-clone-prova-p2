package com.example.provap2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.provap2.models.Product;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Product product = Db.getInstance().getById(id);

        TextView name = findViewById(R.id.productDetailsName);
        name.setText(product.getName());

        TextView description = findViewById(R.id.productDetailsDescription);
        description.setText(product.getDescription());

        TextView price = findViewById(R.id.productDetailsPrice);
        price.setText(String.format("R$ %.2f", product.getPrice()));

        TextView offer = findViewById(R.id.productDetailsOffer);
        offer.setText(String.format("em até %d vezes sem juros", product.getOffer()));

        RatingBar rating = findViewById(R.id.detailsRatingBar);
        rating.setRating(product.getRating());
    }
}