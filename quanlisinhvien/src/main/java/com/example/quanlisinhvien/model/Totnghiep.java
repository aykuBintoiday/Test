package com.example.quanlisinhvien.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "TOT_NGHIEP")
@IdClass(TotNghiepID.class)
public class TotNghiep {

    @Id
    @Column(name = "SoCMND")
    private String soCMND;

    @Id
    @Column(name = "MaTruong")
    private String maTruong;

    @Id
    @Column(name = "MaNganh")
    private String maNganh;

    @Column(name = "HeTN")
    private String heTN;

    @Column(name = "NgayTN")
    private String ngayTN;

    @Column(name = "LoaiTN")
    private String loaiTN;

    public TotNghiep() {
    }

    public TotNghiep(String soCMND, String maTruong, String maNganh, String heTN, String ngayTN, String loaiTN) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getHeTN() {
        return heTN;
    }

    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }

    public String getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(String ngayTN) {
        this.ngayTN = ngayTN;
    }

    public String getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }
}