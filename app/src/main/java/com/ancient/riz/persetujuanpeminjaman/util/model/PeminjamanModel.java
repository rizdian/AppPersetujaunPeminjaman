package com.ancient.riz.persetujuanpeminjaman.util.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PeminjamanModel {

    @SerializedName("id")
    private String id;

    @SerializedName("tgl_pinjam")
    private Date tglPinjam;

    @SerializedName("tgl_kembali")
    private Date tglKembali;

    @SerializedName("keterangan")
    private Date keterangan;

    @SerializedName("no_polisi")
    private String noPol;

    @SerializedName("nama")
    private String nmMobil;

    @SerializedName("nama_depan")
    private String nmPeminjamDpn;

    @SerializedName("nama_belakang")
    private String nmPeminjamBlkng;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Date getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(Date keterangan) {
        this.keterangan = keterangan;
    }

    public String getNoPol() {
        return noPol;
    }

    public void setNoPol(String noPol) {
        this.noPol = noPol;
    }

    public String getNmMobil() {
        return nmMobil;
    }

    public void setNmMobil(String nmMobil) {
        this.nmMobil = nmMobil;
    }

    public String getNmPeminjamDpn() {
        return nmPeminjamDpn;
    }

    public void setNmPeminjamDpn(String nmPeminjamDpn) {
        this.nmPeminjamDpn = nmPeminjamDpn;
    }

    public String getNmPeminjamBlkng() {
        return nmPeminjamBlkng;
    }

    public void setNmPeminjamBlkng(String nmPeminjamBlkng) {
        this.nmPeminjamBlkng = nmPeminjamBlkng;
    }

    @Override
    public String toString() {
        return "PeminjamanModel{" +
                "id='" + id + '\'' +
                ", tglPinjam=" + tglPinjam +
                ", tglKembali=" + tglKembali +
                ", keterangan=" + keterangan +
                ", noPol='" + noPol + '\'' +
                ", nmMobil='" + nmMobil + '\'' +
                ", nmPeminjamDpn='" + nmPeminjamDpn + '\'' +
                ", nmPeminjamBlkng='" + nmPeminjamBlkng + '\'' +
                '}';
    }
}
