package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pearl.salon.R;
import com.pearl.salon.adapter.BookServiceAdapter;
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
    private ArrayList<BookHeadingList> ladiesList;
    private ArrayList<BookHeadingList> manList;

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

        rv_bookService.setLayoutManager(new LinearLayoutManager(this));

        setPriceList();
        setLadiesList();
        setManList();

        rv_bookService.setAdapter(new BookServiceAdapter(this, manList));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int gender = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(gender);
                if(radioButton.getText().equals("Male")){
                    rv_bookService.setAdapter(new BookServiceAdapter(BookFirstActivity.this, manList));
                }else{
                    rv_bookService.setAdapter(new BookServiceAdapter(BookFirstActivity.this, ladiesList));
                }
            }
        });

    }

    private void setPriceList(){
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

    private void setLadiesList(){
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

    private void setManList(){
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
