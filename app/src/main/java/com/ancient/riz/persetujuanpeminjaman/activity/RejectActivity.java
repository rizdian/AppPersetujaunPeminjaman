package com.ancient.riz.persetujuanpeminjaman.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.ancient.riz.persetujuanpeminjaman.R;
import com.ancient.riz.persetujuanpeminjaman.adapter.PeminjamanAdapter;
import com.ancient.riz.persetujuanpeminjaman.model.BaseModel;
import com.ancient.riz.persetujuanpeminjaman.model.PeminjamanModel;
import com.ancient.riz.persetujuanpeminjaman.util.SharedPrefManager;
import com.ancient.riz.persetujuanpeminjaman.util.api.BaseApiService;
import com.ancient.riz.persetujuanpeminjaman.util.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RejectActivity extends AppCompatActivity {

    @BindView(R.id.reason)
    EditText etReason;

    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;

    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);

        this.id = getIntent().getIntExtra("id", -1);
    }

    @OnClick(R.id.btnReject)
    public void requestReject(){

        if(etReason.getText().toString().length()==0){
            etReason.setError("Harap Masukan Alasan");
        }else{
            mApiService.getReject(sharedPrefManager.getSPToken(),this.id,etReason.getText().toString())
                    .enqueue(new Callback<BaseModel>() {
                        @Override
                        public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                            if (response.isSuccessful()){
                                assert response.body() != null;
                                if (response.body().getStatus() == 1){
                                    Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                }else{
                                    Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(mContext, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                            Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
