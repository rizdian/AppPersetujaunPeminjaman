package com.ancient.riz.persetujuanpeminjaman.util.util.api;

public class UtilsApi {

    public static final String BASE_URL_API = "http://192.168.43.191/p3/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
