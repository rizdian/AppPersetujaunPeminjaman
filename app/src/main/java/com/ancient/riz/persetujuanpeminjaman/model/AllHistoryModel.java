package com.ancient.riz.persetujuanpeminjaman.model;

import java.util.List;

public class AllPeminjamanModel extends BaseModel {

    private List<PeminjamanModel> data;

    public List<PeminjamanModel> getData() {
        return data;
    }

    public void setData(List<PeminjamanModel> data) {
        this.data = data;
    }
}
