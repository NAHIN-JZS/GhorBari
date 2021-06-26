package com.example.ghorbari2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Arrayadapter extends ArrayAdapter<Item> {

    private Activity context;
    private List<Item>itemList;


    public Arrayadapter(Activity context, List<Item> itemList) {
        super(context,R.layout.showitem, itemList);
        // public arrayadapter(Activity context, List<student> parentList) {
        //   super(context,R.layout.layoutres, parentList);
        this.context = context;
        this.itemList = itemList;
        //this.parentList = parentList;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.showitem,null,true);
        Item item = itemList.get(position);
        //student Student = parentList.get(position);
        TextView city1 = view.findViewById(R.id.city);
        TextView roomcount1 =view.findViewById(R.id.roomnumber);
        TextView size1 = view.findViewById(R.id.size);
        TextView address1 = view.findViewById(R.id.address);
        TextView owner1 = view.findViewById(R.id.owner);
        TextView description1 = view.findViewById(R.id.description);
        TextView rentFee1 = view.findViewById(R.id.rentFee);
        TextView phonenumber1 = view.findViewById(R.id.phoneNumber);


        city1.setText("City : "+item.getCity());
        roomcount1.setText("Total room : "+item.getRoomNumber());
        size1.setText("Size(Square feet) : "+item.getSize());
        address1.setText("Address : "+item.getAddress());
        owner1.setText("Owner's Name : "+item.getOwnerName());
        description1.setText("Description : "+item.getDescription());
        rentFee1.setText("Rent Fee : "+item.getRentfee1());
        phonenumber1.setText("Phone No : "+item.getPhoneNumber1());

        return view;
    }
}
