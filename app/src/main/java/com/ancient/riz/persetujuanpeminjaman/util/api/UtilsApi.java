package com.ancient.riz.persetujuanpeminjaman.util.api;

import com.ancient.riz.persetujuanpeminjaman.model.Token;

public class UtilsApi {

    private static final String BASE_URL_API = "http://192.168.1.105/p3/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
