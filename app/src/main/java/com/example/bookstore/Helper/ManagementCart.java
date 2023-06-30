package com.example.bookstore.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.bookstore.Domain.BookDomain;
import com.example.bookstore.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;


    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertBook(BookDomain item){
        ArrayList<BookDomain> listBook=getListCart();
        boolean existAlready = false;
        int n=0;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready){
            listBook.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listBook.add(item);
        }

        tinyDB.putListObject("CardList",listBook);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<BookDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberBook(ArrayList<BookDomain> listbook, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listbook.get(position).getNumberInCart()==1){
            listbook.remove(position);
        }else {
            listbook.get(position).setNumberInCart(listbook.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CardList",listbook);
        changeNumberItemsListener.changed();
    }
    public void plusNumberBook(ArrayList<BookDomain> listbook, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listbook.get(position).setNumberInCart(listbook.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CardList",listbook);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<BookDomain>listbook2=getListCart();
        double fee=0;
        for (int i = 0; i < listbook2.size(); i++) {
            fee=fee+(listbook2.get(i).getFee()*listbook2.get(i).getNumberInCart());
        }
        return fee;
    }
}
