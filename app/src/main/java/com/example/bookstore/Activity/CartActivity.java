package com.example.bookstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.bookstore.Helper.ManagementCart;
import com.example.bookstore.R;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);

        initView();
        initList();
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
    }

    private void calculateCard() {
        double percentTax = 0.02;   //you can change this item for tax price
        double delivery = 10;       // can change this item you need price for delivery

        tax=Math.round((managementCart.getTotalFee()*percentTax)*100.0)/100.0;
        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal = Math.round(managementCart.getTotalFee()*100.0)/100.0;

        totalFeeTxt.setText("VND"+itemTotal);
        taxTxt.setText("VND"+tax);
        deliveryTxt.setText("VND"+delivery);
        totalTxt.setText("VND"+total);
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt = findViewById(R.id.emptyTxt);
    }
}