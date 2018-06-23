package com.ancient.riz.persetujuanpeminjaman.util.util.api;

import com.ancient.riz.persetujuanpeminjaman.util.model.AllPeminjamanModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("rest/generate")
    Call<ResponseBody> loginRequest(@Field("identity") String identity,
                                    @Field("password") String password);

    @GET("peminjaman/all")
    Call<AllPeminjamanModel> getListAllPeminjaman();
}
