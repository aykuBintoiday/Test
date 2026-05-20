package com.example.quanlisinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quanlisinhvien.model.CongViec;
import com.example.quanlisinhvien.model.CongViecID;

public interface CongviecRepository extends JpaRepository<CongViec, CongViecID> {
}