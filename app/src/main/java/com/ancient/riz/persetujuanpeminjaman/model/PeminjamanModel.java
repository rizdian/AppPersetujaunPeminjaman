package com.ancient.riz.persetujuanpeminjaman.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

public class PeminjamanModel {

    @SerializedName("id")
    private Integer id;

    @SerializedName("tgl_pinjam")
    private Date tglPinjam;

    @SerializedName("tgl_kembali")
    private Date tglKembali;

    @SerializedName("keterangan")
    private String keterangan;

    @SerializedName("no_polisi")
    private String noPol;

    @SerializedName("nama")
    private String nmMobil;

    @SerializedName("nama_depan")
    private String nmPeminjamDpn;

    @SerializedName("nama_belakang")
    private String nmPeminjamBlkng;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeminjamanModel that = (PeminjamanModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tglPinjam, that.tglPinjam) &&
                Objects.equals(tglKembali, that.tglKembali) &&
                Objects.equals(keterangan, that.keterangan) &&
                Objects.equals(noPol, that.noPol) &&
                Objects.equals(nmMobil, that.nmMobil) &&
                Objects.equals(nmPeminjamDpn, that.nmPeminjamDpn) &&
                Objects.equals(nmPeminjamBlkng, that.nmPeminjamBlkng);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tglPinjam, tglKembali, keterangan, noPol, nmMobil, nmPeminjamDpn, nmPeminjamBlkng);
    }

}
