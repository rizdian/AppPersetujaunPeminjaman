package com.ancient.riz.persetujuanpeminjaman.activity;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ancient.riz.persetujuanpeminjaman.R;
import com.ancient.riz.persetujuanpeminjaman.adapter.PeminjamanAdapter;
import com.ancient.riz.persetujuanpeminjaman.model.AllPeminjamanModel;
import com.ancient.riz.persetujuanpeminjaman.util.SharedPrefManager;
import com.ancient.riz.persetujuanpeminjaman.util.api.BaseApiService;
import com.ancient.riz.persetujuanpeminjaman.model.PeminjamanModel;
import com.ancient.riz.persetujuanpeminjaman.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.listPeminjaman)
    RecyclerView rvPeminjaman;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;

    Context mContext;
    List<PeminjamanModel> peminjamanModelList = new ArrayList<>();
    PeminjamanAdapter peminjamanAdapter;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mContext = this;
        sharedPrefManager = new SharedPrefManager(this);
        mApiService = UtilsApi.getAPIService();

        peminjamanAdapter = new PeminjamanAdapter(this, peminjamanModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPeminjaman.setLayoutManager(mLayoutManager);
        rvPeminjaman.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getResultListPeminjaman();
            }
        });
        // Configure the refreshing colors
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        getResultListPeminjaman();
    }

    public void getResultListPeminjaman() {
        mApiService.getListPeminjaman(sharedPrefManager.getSPToken()).enqueue(new Callback<AllPeminjamanModel>() {
            @Override
            public void onResponse(@NonNull Call<AllPeminjamanModel> call, @NonNull Response<AllPeminjamanModel> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    if (response.body().getStatus() == 1){
                        final List<PeminjamanModel> list = response.body().getData();
                        rvPeminjaman.setAdapter(new PeminjamanAdapter(mContext, list));
                        peminjamanAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);

                    }else{
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<AllPeminjamanModel> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        getResultListPeminjaman();
    }
}
