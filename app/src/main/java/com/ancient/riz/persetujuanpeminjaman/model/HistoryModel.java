package com.ancient.riz.persetujuanpeminjaman.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class HistoryModel {

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_peminjaman")
    private Integer idPeminjam;

    @SerializedName("status")
    private Integer status;

    @SerializedName("flag")
    private Integer tingkatan;

    @SerializedName("id_karyawan")
    private Integer idKaryawan;

    @SerializedName("on_update")
    private Date onUpdate;

    @SerializedName("nama")
    private String divisi;

    @SerializedName("nama_depan")
    private String NmDepanApp;

    @SerializedName("nama_belakang")
    private String NmBelakangApp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPeminjam() {
        return idPeminjam;
    }

    public void setIdPeminjam(Integer idPeminjam) {
        this.idPeminjam = idPeminjam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(Integer tingkatan) {
        this.tingkatan = tingkatan;
    }

    public Integer getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Integer idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public Date getOnUpdate() {
        return onUpdate;
    }

    public void setOnUpdate(Date onUpdate) {
        this.onUpdate = onUpdate;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getNmDepanApp() {
        return NmDepanApp;
    }

    public void setNmDepanApp(String nmDepanApp) {
        NmDepanApp = nmDepanApp;
    }

    public String getNmBelakangApp() {
        return NmBelakangApp;
    }

    public void setNmBelakangApp(String nmBelakangApp) {
        NmBelakangApp = nmBelakangApp;
    }
}


