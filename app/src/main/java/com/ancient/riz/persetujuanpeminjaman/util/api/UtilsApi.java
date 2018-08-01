package com.ancient.riz.persetujuanpeminjaman.util.api;

import com.ancient.riz.persetujuanpeminjaman.model.Token;

public class UtilsApi {

    //private static final String BASE_URL_API = "http://192.168.43.13/p3/api/";
    private static final String BASE_URL_API = "http://10.8.104.33/p3/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
