package com.example.quanlisinhvien.model;

import java.io.Serializable;
import java.util.Objects;

public class CongViecID implements Serializable {
    private String soCMND;
    private String ngayVaoCongTy;

    public CongViecID(){}

    public CongViecID(String soCMND, String ngayVaoCongTy) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CongViecID)) return false;
        CongViecID that = (CongViecID) o;
        return Objects.equals(soCMND, that.soCMND)
                && Objects.equals(ngayVaoCongTy, that.ngayVaoCongTy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, ngayVaoCongTy);
    }
}
