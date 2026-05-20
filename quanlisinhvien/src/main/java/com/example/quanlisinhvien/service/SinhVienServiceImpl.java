package com.example.quanlisinhvien.service;

import com.example.quanlisinhvien.dto.SinhVienForm;
import com.example.quanlisinhvien.model.SinhVien;
import com.example.quanlisinhvien.model.TotNghiep;
import com.example.quanlisinhvien.repository.SinhVienRepository;
import com.example.quanlisinhvien.repository.TotnghiepRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    private final SinhVienRepository sinhVienRepository;
    private final TotnghiepRepository totnghiepRepository;

    public SinhVienServiceImpl(SinhVienRepository sinhVienRepository,
                               TotnghiepRepository totnghiepRepository) {
        this.sinhVienRepository = sinhVienRepository;
        this.totnghiepRepository = totnghiepRepository;
    }

    @Override
    public List<SinhVien> findAll() {
        return sinhVienRepository.findAll();
    }

    @Override
    public Optional<SinhVien> findById(String soCMND) {
        return sinhVienRepository.findById(soCMND);
    }

    @Override
    @Transactional
    public void save(SinhVienForm form) {
        SinhVien sinhVien = new SinhVien(
                form.getSoCMND(),
                form.getHoTen(),
                form.getEmail(),
                form.getSoDT(),
                form.getDiaChi()
        );

        sinhVienRepository.save(sinhVien);

        TotNghiep totnghiep = new TotNghiep(
                form.getSoCMND(),
                form.getMaTruong(),
                form.getMaNganh(),
                form.getHeTN(),
                form.getNgayTN(),
                form.getLoaiTN()
        );

        totnghiepRepository.save(totnghiep);
    }

    @Override
    @Transactional
    public void update(String soCMND, SinhVien sinhVien) {
        sinhVien.setSoCMND(soCMND);
        sinhVienRepository.save(sinhVien);
    }

    @Override
    @Transactional
    public void delete(String soCMND) {
        totnghiepRepository.deleteBySoCMND(soCMND);
        sinhVienRepository.deleteById(soCMND);
    }
}