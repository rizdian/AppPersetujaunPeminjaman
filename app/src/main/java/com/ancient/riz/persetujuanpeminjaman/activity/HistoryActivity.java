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
import com.ancient.riz.persetujuanpeminjaman.adapter.HistoryAdapter;
import com.ancient.riz.persetujuanpeminjaman.model.AllHistoryModel;
import com.ancient.riz.persetujuanpeminjaman.model.HistoryModel;
import com.ancient.riz.persetujuanpeminjaman.util.SharedPrefManager;
import com.ancient.riz.persetujuanpeminjaman.util.api.BaseApiService;
import com.ancient.riz.persetujuanpeminjaman.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.listDetailPeminjaman)
    RecyclerView rvDetailPeminjaman;
    @BindView(R.id.swipe_container_detail)
    SwipeRefreshLayout swipeRefreshLayout;

    Context mContext;
    List<HistoryModel> historyModelList = new ArrayList<>();
    HistoryAdapter historyAdapter;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        this.id = getIntent().getIntExtra("id", -1);

        ButterKnife.bind(this);
        mContext = this;
        sharedPrefManager = new SharedPrefManager(this);
        mApiService = UtilsApi.getAPIService();

        historyAdapter = new HistoryAdapter(this, historyModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvDetailPeminjaman.setLayoutManager(mLayoutManager);
        rvDetailPeminjaman.setItemAnimator(new DefaultItemAnimator());

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
        mApiService.getListDetailApproval(sharedPrefManager.getSPToken(),this.id).enqueue(new Callback<AllHistoryModel>() {
            @Override
            public void onResponse(@NonNull Call<AllHistoryModel> call, @NonNull Response<AllHistoryModel> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    if (response.body().getStatus() == 1){
                        final List<HistoryModel> list = response.body().getData();
                        rvDetailPeminjaman.setAdapter(new HistoryAdapter(mContext, list));
                        historyAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);

                    }else{
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(@NonNull Call<AllHistoryModel> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        getResultListPeminjaman();
    }
}
