package com.ancient.riz.persetujuanpeminjaman.model;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
    private String onUpdate;

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

    public String getOnUpdate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setOnUpdate(String onUpdate) {
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

    @Override
    public String toString() {
        return "HistoryModel{" +
                "id=" + id +
                ", idPeminjam=" + idPeminjam +
                ", status='" + status + '\'' +
                ", tingkatan=" + tingkatan +
                ", idKaryawan=" + idKaryawan +
                ", onUpdate=" + onUpdate +
                ", divisi='" + divisi + '\'' +
                ", NmDepanApp='" + NmDepanApp + '\'' +
                ", NmBelakangApp='" + NmBelakangApp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoryModel)) return false;
        HistoryModel that = (HistoryModel) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getIdPeminjam(), that.getIdPeminjam()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getTingkatan(), that.getTingkatan()) &&
                Objects.equals(getIdKaryawan(), that.getIdKaryawan()) &&
                Objects.equals(getOnUpdate(), that.getOnUpdate()) &&
                Objects.equals(getDivisi(), that.getDivisi()) &&
                Objects.equals(getNmDepanApp(), that.getNmDepanApp()) &&
                Objects.equals(getNmBelakangApp(), that.getNmBelakangApp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getIdPeminjam(), getStatus(), getTingkatan(), getIdKaryawan(), getOnUpdate(), getDivisi(), getNmDepanApp(), getNmBelakangApp());
    }
}


