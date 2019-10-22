package com.pearl.salon.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pearl.salon.R;
import com.pearl.salon.adapter.BookSpecialistAdapter;
import com.pearl.salon.adapter.BookTimeSalotAdapter;
import com.pearl.salon.clickListner.TimeSalotClickListner;
import com.pearl.salon.model.book.BookSpecialistList;
import com.pearl.salon.model.book.BookTimeSlotList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BookSecondActivity extends AppCompatActivity {

    private TextView tv_price, tv_date;
    private RecyclerView rv_staff, rv_timesalot;
    private Button btn_continue;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat selectedFormat;
    private ImageView banner;
    private String selectedTimeSlot = "";

    private TimeSalotClickListner clickListner = new TimeSalotClickListner() {
        @Override
        public void onTimeSelect(String time) {
            selectedTimeSlot = time;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_second);

        tv_price = findViewById(R.id.textView65);
        tv_date = findViewById(R.id.textView66);
        rv_staff = findViewById(R.id.rv_book_specialist);
        rv_timesalot = findViewById(R.id.rv_available_salot);
        btn_continue = findViewById(R.id.button12);
        banner = findViewById(R.id.imageView22);

        rv_staff.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rv_timesalot.setLayoutManager(new GridLayoutManager(this, 4));

        dateFormat = new SimpleDateFormat("dd MMMM, yyyy", Locale.US);
        selectedFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        tv_price.setText(getIntent().getStringExtra("totalPrice"));
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX1Zl9dZiTBT8WwG36HWdrMlTvJckwUn5VL4IciQLNVeGc-enk9A").into(banner);

        getCurrentTime();

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDateDialog();
            }
        });

        setSpecialistAdapter();
        setSalotAdapter();

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(selectedTimeSlot.equals("")){
                   Toast.makeText(BookSecondActivity.this, "Select any time slot to continue", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(BookSecondActivity.this, "Selected time: "+selectedTimeSlot, Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void getCurrentTime() {
        Date d = Calendar.getInstance().getTime();
        String formattedDate = dateFormat.format(d);
        tv_date.setText(formattedDate);
    }

    private void openDateDialog() {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        Calendar lastC = Calendar.getInstance();
        lastC.set(mYear, mMonth, mDay + 14);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    String fmonth, fDate;
                    int month;

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        Date date = null;
                        String str = null;
                        String paddedMonth = null;
                        try {
                            if (monthOfYear < 10 && dayOfMonth < 10) {

                                fmonth = "0" + monthOfYear;
                                month = Integer.parseInt(fmonth) + 1;
                                fDate = "0" + dayOfMonth;
                                paddedMonth = String.format("%02d", month);
                                str = fDate + "/" + paddedMonth + "/" + year;
                                try {
                                    date = selectedFormat.parse(str);
                                    str = dateFormat.format(date);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                tv_date.setText(str);

                            } else {

                                fmonth = "0" + monthOfYear;
                                month = Integer.parseInt(fmonth) + 1;
                                paddedMonth = String.format("%02d", month);
                                str = dayOfMonth + "/" + paddedMonth + "/" + year;
                                try {
                                    date = selectedFormat.parse(str);
                                    str = dateFormat.format(date);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                tv_date.setText(str);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(lastC.getTimeInMillis());
        datePickerDialog.show();
    }

    private void setSpecialistAdapter() {

        ArrayList<BookSpecialistList> arrayList = new ArrayList<>();

        BookSpecialistList data0 = new BookSpecialistList("Sandeep", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data1 = new BookSpecialistList("Ankit", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data2 = new BookSpecialistList("Rishi", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", true);
        BookSpecialistList data3 = new BookSpecialistList("Shubham", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data4 = new BookSpecialistList("Nitin", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data5 = new BookSpecialistList("Rupender", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data6 = new BookSpecialistList("Sunil", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data7 = new BookSpecialistList("Nikita", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data8 = new BookSpecialistList("Khusbu", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data9 = new BookSpecialistList("Yugvender", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);
        BookSpecialistList data10 = new BookSpecialistList("Charu", "https://dixmfnt6b5ogu.cloudfront.net/user/pages/02.home-9a/05._testimonials-2/jonas-eilsoe-profil-kvadrat.jpg?g-5d85d749", false);

        arrayList.add(data0);
        arrayList.add(data1);
        arrayList.add(data2);
        arrayList.add(data3);
        arrayList.add(data4);
        arrayList.add(data5);
        arrayList.add(data6);
        arrayList.add(data7);
        arrayList.add(data8);
        arrayList.add(data9);
        arrayList.add(data10);

        rv_staff.setAdapter(new BookSpecialistAdapter(this, arrayList));
    }

    private void setSalotAdapter() {

        ArrayList<BookTimeSlotList> slotList = new ArrayList<>();

        BookTimeSlotList data0 = new BookTimeSlotList("9:00 AM", false);
        BookTimeSlotList data1 = new BookTimeSlotList("9:30 AM", false);
        BookTimeSlotList data2 = new BookTimeSlotList("10:00 AM", false);
        BookTimeSlotList data3 = new BookTimeSlotList("10:30 AM", false);
        BookTimeSlotList data4 = new BookTimeSlotList("11:00 AM", false);
        BookTimeSlotList data5 = new BookTimeSlotList("11:30 AM", true);
        BookTimeSlotList data6 = new BookTimeSlotList("12:00 AM", false);
        BookTimeSlotList data7 = new BookTimeSlotList("12:30 PM", false);
        BookTimeSlotList data8 = new BookTimeSlotList("01:00 PM", false);
        BookTimeSlotList data9 = new BookTimeSlotList("01:30 PM", false);
        BookTimeSlotList data10 = new BookTimeSlotList("02:00 PM", false);
        BookTimeSlotList data11 = new BookTimeSlotList("02:30 PM", false);
        BookTimeSlotList data12 = new BookTimeSlotList("03:00 PM", false);

        slotList.add(data0);
        slotList.add(data1);
        slotList.add(data2);
        slotList.add(data3);
        slotList.add(data4);
        slotList.add(data5);
        slotList.add(data6);
        slotList.add(data7);
        slotList.add(data8);
        slotList.add(data9);
        slotList.add(data10);
        slotList.add(data11);
        slotList.add(data12);

        rv_timesalot.setAdapter(new BookTimeSalotAdapter(this, slotList, clickListner));
    }

    public void backBookSecond(View view) {
        finish();
    }
}
