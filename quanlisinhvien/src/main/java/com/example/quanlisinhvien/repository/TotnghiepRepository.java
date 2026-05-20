package com.example.quanlisinhvien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.quanlisinhvien.model.TotNghiep;
import com.example.quanlisinhvien.model.TotNghiepID;

public interface TotnghiepRepository extends JpaRepository<TotNghiep, TotNghiepID> {

    void deleteBySoCMND(String soCMND);

    @Query(value =
            "SELECT " +
            "sv.SoCMND, " +
            "sv.HoTen, " +
            "tn.MaNganh AS MaNganhTotNghiep, " +
            "tn.MaTruong AS MaTruongTotNghiep, " +
            "cv.MaNganh AS MaNganhCongTy, " +
            "cv.TenCongTy, " +
            "cv.ThoiGianLamViec " +
            "FROM SINHVIEN sv " +
            "JOIN TOT_NGHIEP tn ON sv.SoCMND = tn.SoCMND " +
            "LEFT JOIN CONG_VIEC cv ON sv.SoCMND = cv.SoCMND " +
            "WHERE sv.SoCMND LIKE %:keyword% " +
            "OR sv.HoTen LIKE %:keyword% " +
            "OR tn.MaNganh LIKE %:keyword% " +
            "OR tn.MaTruong LIKE %:keyword% " +
            "OR cv.MaNganh LIKE %:keyword% " +
            "OR cv.TenCongTy LIKE %:keyword%",
            nativeQuery = true)
    List<Object[]> searchGraduationAndJob(@Param("keyword") String keyword);
}