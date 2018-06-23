package com.ancient.riz.persetujuanpeminjaman.util.model;

import java.util.List;

public class AllPeminjamanModel extends BaseModel {

    private List<PeminjamanModel> listAllPeminjaman;

    public List<PeminjamanModel> getListAllPeminjaman() {
        return listAllPeminjaman;
    }

    public void setListAllPeminjaman(List<PeminjamanModel> listAllPeminjaman) {
        this.listAllPeminjaman = listAllPeminjaman;
    }


    @Override
    public String toString() {
        return "AllPeminjamanModel{" +
                "listAllPeminjaman=" + listAllPeminjaman +
                '}';
    }
}
