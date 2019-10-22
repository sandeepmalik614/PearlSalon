package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.adapter.PaymentMethodAdapter;
import com.pearl.salon.clickListner.PamentMethodClickListner;
import com.pearl.salon.model.book.PaymentMethodList;

import java.util.ArrayList;

public class BookingDetailsActivity extends AppCompatActivity {

    private RecyclerView rv_bookDetails;
    private ArrayList<PaymentMethodList> methodList;
    private ImageView banner;
    private Toolbar tb_booking_details;
    private Button btn;

    private PamentMethodClickListner clickListner = new PamentMethodClickListner() {
        @Override
        public void onSelect(String method) {
            btn.setText("Continue with "+method);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        rv_bookDetails = findViewById(R.id.rv_bookDetails);
        banner = findViewById(R.id.img_salon_booking_details);
        btn = findViewById(R.id.button13);

        rv_bookDetails.setLayoutManager(new LinearLayoutManager(this));

        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX1Zl9dZiTBT8WwG36HWdrMlTvJckwUn5VL4IciQLNVeGc-enk9A").into(banner);

        methodList = new ArrayList<>();

        PaymentMethodList data0 = new PaymentMethodList("Credit/Debit Card", "", R.drawable.ic_visa, true);
        PaymentMethodList data1 = new PaymentMethodList("Bank Account", "", R.drawable.ic_bank, false);
//        PaymentMethodList data2 = new PaymentMethodList("PayPal", "", R.drawable.ic_paypal, false);
        PaymentMethodList data3 = new PaymentMethodList("Pay at Salon", "", R.drawable.ic_cod, false);

        methodList.add(data0);
        methodList.add(data1);
//        methodList.add(data2);
        methodList.add(data3);

        rv_bookDetails.setAdapter(new PaymentMethodAdapter(this, methodList, clickListner));
    }
}
