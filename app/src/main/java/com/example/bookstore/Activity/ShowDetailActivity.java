package com.example.bookstore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookstore.Domain.BookDomain;
import com.example.bookstore.Helper.ManagementCart;
import com.example.bookstore.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt ;
    private ImageView plusBtn, minusBtn, picBook;
    private BookDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        
        managementCart = new ManagementCart(this);
        
        iniView();
        getBundle();
    }

    private void getBundle() {
        object=(BookDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picBook);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("VNĐ"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder +1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder >1){
                    numberOrder = numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText(String.valueOf(numberOrder*object.getFee()));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertBook(object);
            }
        });

    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picBook = findViewById(R.id.bookPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);


    }

}