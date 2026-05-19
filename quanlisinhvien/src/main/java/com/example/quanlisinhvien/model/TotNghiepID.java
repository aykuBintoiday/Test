package com.example.quanlisinhvien.model;

import java.io.Serializable;
import java.util.Objects;

public class TotNghiepID implements Serializable {

    private String soCMND;
    private String maTruong;
    private String maNganh;

    public TotNghiepID() {
    }

    public TotNghiepID(String soCMND, String maTruong, String maNganh) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotNghiepID)) return false;
        TotNghiepID that = (TotNghiepID) o;
        return Objects.equals(soCMND, that.soCMND)
                && Objects.equals(maTruong, that.maTruong)
                && Objects.equals(maNganh, that.maNganh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCMND, maTruong, maNganh);
    }
}