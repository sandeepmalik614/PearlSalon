package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.adapter.BookServiceAdapter;
import com.pearl.salon.clickListner.BookServiceClickListner;
import com.pearl.salon.model.book.BookHeadingList;
import com.pearl.salon.model.book.BookServiceList;

import java.util.ArrayList;

public class BookFirstActivity extends AppCompatActivity {

    private ImageView bannerImage, backImage;
    private RadioGroup radioGroup;
    private TextView tv_price;
    private RecyclerView rv_bookService;
    private Button btn_book;

    private ArrayList<BookServiceList> serviceList;
    private ArrayList<BookServiceList> selectedList;
    private ArrayList<BookHeadingList> ladiesList;
    private ArrayList<BookHeadingList> manList;
    private BookServiceList selectedData;
    private int selectedPrice = 0;

    private BookServiceClickListner clickListner = new BookServiceClickListner() {
        @Override
        public void onPriceAdd(String name, int price) {
            selectedData = new BookServiceList(name, price);
            selectedList.add(selectedData);
            selectedPrice += price;
            tv_price.setText("Price: \u20B9" + selectedPrice);
        }

        @Override
        public void onPriceChange(String name, int price) {
            selectedPrice = 0;
            selectedData = new BookServiceList(name, price);
            for (int i = 0; i < selectedList.size(); i++) {
                if (name.equals(selectedList.get(i).getName())) {
                    selectedList.set(i, selectedData);
                }

                selectedPrice += selectedList.get(i).getPrice();

                if (i == (selectedList.size() - 1)) {
                    tv_price.setText("Price: \u20B9" + selectedPrice);
                }
            }
        }

        @Override
        public void onPriceDelete(String name, int price) {
            selectedData = new BookServiceList(name, price);
            selectedList.remove(selectedData);
            selectedPrice -= price;
            tv_price.setText("Price: \u20B9" + selectedPrice);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_first);

        backImage = findViewById(R.id.imageView20);
        bannerImage = findViewById(R.id.imageView21);
        radioGroup = findViewById(R.id.radioGroup);
        tv_price = findViewById(R.id.textView60);
        rv_bookService = findViewById(R.id.rv_bookService);
        btn_book = findViewById(R.id.button11);

        tv_price.setText("Price: \u20B9 0");

        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX1Zl9dZiTBT8WwG36HWdrMlTvJckwUn5VL4IciQLNVeGc-enk9A")
                .into(bannerImage);

        rv_bookService.setLayoutManager(new LinearLayoutManager(this));

        selectedList = new ArrayList<>();

        setPriceList();
        setLadiesList();
        setManList();

        rv_bookService.setAdapter(new BookServiceAdapter(this, manList, clickListner));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int gender = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(gender);
                selectedList.clear();
                selectedPrice = 0;
                tv_price.setText("Price: \u20B9 0.00");
                if (radioButton.getText().equals("Male")) {
                    rv_bookService.setAdapter(new BookServiceAdapter(BookFirstActivity.this, manList, clickListner));
                } else {
                    rv_bookService.setAdapter(new BookServiceAdapter(BookFirstActivity.this, ladiesList, clickListner));
                }
            }
        });

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPrice == 0){
                    Toast.makeText(BookFirstActivity.this, "Please select any service for booking", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(BookFirstActivity.this, BookSecondActivity.class);
                    intent.putExtra("totalPrice", tv_price.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    private void setPriceList() {
        serviceList = new ArrayList<>();
        BookServiceList data0 = new BookServiceList("Select service", 0);
        BookServiceList data1 = new BookServiceList("Large", 200);
        BookServiceList data2 = new BookServiceList("Medium", 150);
        BookServiceList data3 = new BookServiceList("Small", 100);

        serviceList.add(data0);
        serviceList.add(data1);
        serviceList.add(data2);
        serviceList.add(data3);
    }

    private void setLadiesList() {
        ladiesList = new ArrayList<>();
        BookHeadingList ladiesList0 = new BookHeadingList("Haircut", serviceList);
        BookHeadingList ladiesList1 = new BookHeadingList("Spa", serviceList);
        BookHeadingList ladiesList2 = new BookHeadingList("Makeup", serviceList);
        BookHeadingList ladiesList3 = new BookHeadingList("Facial", serviceList);
        BookHeadingList ladiesList4 = new BookHeadingList("Hair color", serviceList);
        BookHeadingList ladiesList5 = new BookHeadingList("Bridal", serviceList);
        BookHeadingList ladiesList6 = new BookHeadingList("Nail", serviceList);

        ladiesList.add(ladiesList0);
        ladiesList.add(ladiesList1);
        ladiesList.add(ladiesList2);
        ladiesList.add(ladiesList3);
        ladiesList.add(ladiesList4);
        ladiesList.add(ladiesList5);
        ladiesList.add(ladiesList6);
    }

    private void setManList() {
        manList = new ArrayList<>();
        BookHeadingList manList0 = new BookHeadingList("Hair Style", serviceList);
        BookHeadingList manList1 = new BookHeadingList("Saving", serviceList);
        BookHeadingList manList2 = new BookHeadingList("Styling", serviceList);
        BookHeadingList manList3 = new BookHeadingList("Facial", serviceList);
        BookHeadingList manList4 = new BookHeadingList("Hair color", serviceList);
        BookHeadingList manList5 = new BookHeadingList("Triming", serviceList);
        BookHeadingList manList6 = new BookHeadingList("Hair cut", serviceList);

        manList.add(manList0);
        manList.add(manList1);
        manList.add(manList2);
        manList.add(manList3);
        manList.add(manList4);
        manList.add(manList5);
        manList.add(manList6);
    }
}
