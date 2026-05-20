package com.example.quanlisinhvien.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlisinhvien.model.SinhVien;

public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    @Query("SELECT s FROM SinhVien s WHERE " +
       "s.soCMND LIKE %:keyword% OR " +
       "s.hoTen LIKE %:keyword% OR " +
       "s.email LIKE %:keyword% OR " +
       "s.soDT LIKE %:keyword% OR " +
       "s.diaChi LIKE %:keyword%")
List<SinhVien> searchBasic(@Param("keyword") String keyword);
}