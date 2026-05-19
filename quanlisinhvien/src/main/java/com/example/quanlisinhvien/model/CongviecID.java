package com.example.quanlisinhvien.model;

import java.io.Serializable;
import java.util.Objects;

public class CongviecID implements Serializable {
    private String soCMND;
    private String ngayVaoCongTy;

    public CongviecID(){}

    public CongviecID(String soCMND, String ngayVaoCongTy) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CongviecID)) return false;
        CongviecID that = (CongviecID) o;
        return Objects.equals(soCMND, that.soCMND)
                && Objects.equals(ngayVaoCongTy, that.ngayVaoCongTy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, ngayVaoCongTy);
    }
}
