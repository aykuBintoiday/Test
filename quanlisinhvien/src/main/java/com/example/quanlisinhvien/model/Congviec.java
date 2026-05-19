package com.example.quanlisinhvien.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONG_VIEC")
@IdClass(CongviecID.class)

public class Congviec {
    @Id
    @Column(name = "SoCMND")
    private String soCMND;

    @Id
    @Column(name = "NgayVaoCongTy")
    private String ngayVaoCongTy;

    @Column(name = "MaNganh")
    private String maNganh;
    
    @Column(name = "TenCongViec")
    private String tenCongViec;

    @Column(name = "TenCongTy")
    private String tenCongTy;

    @Column(name = "DiaChiCongTy")
    private String diaChiCongTy;

    @Column(name = "ThoiGianLamViec")
    private String thoiGianLamViec;

    public Congviec(){}
    
    public Congviec(String soCMND,
                    String ngayVaoCongTy,
                    String maNganh,
                    String tenCongViec,
                    String tenCongTy,
                    String diaChiCongTy,
                    String thoiGianLamViec) {

        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
        this.maNganh = maNganh;
        this.tenCongViec = tenCongViec;
        this.tenCongTy = tenCongTy;
        this.diaChiCongTy = diaChiCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(String ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public String getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(String thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}
