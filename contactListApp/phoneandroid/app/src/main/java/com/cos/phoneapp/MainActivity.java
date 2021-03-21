package com.cos.phoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.cos.phoneapp.adapter.PhoneAdapter;
import com.cos.phoneapp.model.Phone;
import com.cos.phoneapp.service.PhoneService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;
    private MainActivity mainActivity;

    private RecyclerView rvPhone;
    private PhoneAdapter phoneAdapter;

    private List<Phone> phones = new ArrayList<>();
    private PhoneService phoneService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneService = PhoneService.retrofit.create(PhoneService.class);

        findAll();

    }

    private void findAll() {
        Call<CMRespDto<List<Phone>>> call = phoneService.findAll();

        call.enqueue(new Callback<CMRespDto<List<Phone>>>() {
            @Override
            public void onResponse(Call<CMRespDto<List<Phone>>> call, Response<CMRespDto<List<Phone>>> response) {
                CMRespDto<List<Phone>> cmRespDto = response.body();
                phones = cmRespDto.getData();
                Log.d(TAG, "데이터: "+phones);
                init();
            }

            @Override
            public void onFailure(Call<CMRespDto<List<Phone>>> call, Throwable t) {
                Log.d(TAG, "onFailure: findAll() 실패");
            }
        });
    }


    private void init() {
        rvPhone.findViewById(R.id.rv_phone);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
        rvPhone.setLayoutManager(manager);
        phoneAdapter = new PhoneAdapter(phones, mainActivity);
        rvPhone.setAdapter(phoneAdapter);
    }

}