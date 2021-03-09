package com.pradana.tumbuh.model;

public class Tanaman {
    private String mNama;
    private String mTanggal;
    private String mDeskripsi;

    public void setNama(String nama) {
        this.mNama = nama;
    }

    public String getNama() {
        return this.mNama;
    }

    public void setTanggal(String tanggal) {
        this.mTanggal = tanggal;
    }

    public String getTanggal() {
        return this.mTanggal;
    }

    public void setDeskripsi(String deskripsi) {
        this.mDeskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return this.mDeskripsi;
    }
}
