package com.ancient.riz.persetujuanpeminjaman.util.api;

import com.ancient.riz.persetujuanpeminjaman.model.AllHistoryModel;
import com.ancient.riz.persetujuanpeminjaman.model.AllPeminjamanModel;
import com.ancient.riz.persetujuanpeminjaman.model.BaseModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("rest/generate")
    Call<ResponseBody> loginRequest(@Field("identity") String identity,
                                    @Field("password") String password);

    @GET("v1/peminjaman/all")
    Call<AllPeminjamanModel> getListAllPeminjaman(@Header("authorization") String auth);

    @GET("v1/peminjaman")
    Call<AllPeminjamanModel> getListPeminjaman(@Header("authorization") String auth);

    @FormUrlEncoded
    @POST("v1/peminjaman/acc")
    Call<BaseModel> getApproval(@Header("authorization") String auth,
                                @Field("id") Integer id);

    @FormUrlEncoded
    @POST("v1/peminjaman/detail")
    Call<AllHistoryModel> getListDetailApproval(@Header("authorization") String auth,
                                                @Field("id") Integer id);
}
