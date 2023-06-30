package com.example.bookstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstore.Domain.BookDomain;
import com.example.bookstore.Helper.ManagementCart;
import com.example.bookstore.Interface.ChangeNumberItemsListener;
import com.example.bookstore.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<BookDomain> listBookSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<BookDomain> listBookSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listBookSelected = listBookSelected;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        System.out.println(listBookSelected.get(position).getFee());
        holder.title.setText(listBookSelected.get(position).getTitle());
        holder.feeEachItem.setText("VNĐ"+listBookSelected.get(position).getFee());
        holder.totalEachItem.setText("VNĐ"+ Math.round((listBookSelected.get(position).getNumberInCart()*listBookSelected.get(position).getFee())));
        holder.num.setText(String.valueOf(listBookSelected.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listBookSelected.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
        holder.plusItem.setOnClickListener(view -> managementCart.plusNumberBook(listBookSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
        holder.minusItem.setOnClickListener(view -> managementCart.minusNumberBook(listBookSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }

    @Override
    public int getItemCount() {
        return listBookSelected.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem, num;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.imageView2);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberOrderTxt);
        }
    }
}
