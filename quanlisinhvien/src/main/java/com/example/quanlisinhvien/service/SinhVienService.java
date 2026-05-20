package com.example.quanlisinhvien.service;

import com.example.quanlisinhvien.dto.SinhVienForm;
import com.example.quanlisinhvien.model.SinhVien;

import java.util.List;
import java.util.Optional;

public interface SinhVienService {

    List<SinhVien> findAll();

    Optional<SinhVien> findById(String soCMND);

    void save(SinhVienForm form);

    void update(String soCMND, SinhVien sinhVien);

    void delete(String soCMND);
}