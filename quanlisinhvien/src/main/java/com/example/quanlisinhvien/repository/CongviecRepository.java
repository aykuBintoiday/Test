package com.example.quanlisinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quanlisinhvien.model.Congviec;
import com.example.quanlisinhvien.model.CongviecID;

public interface CongviecRepository extends JpaRepository<Congviec, CongviecID> {
}