package com.example.quanlisinhvien.repository;

import com.example.quanlisinhvien.model.TotNghiepID;
import com.example.quanlisinhvien.model.Totnghiep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotnghiepRepository extends JpaRepository<Totnghiep, TotNghiepID> {
    List<Totnghiep> findBySoCMND(String soCMND);
    void deleteBySoCMND(String soCMND);
}