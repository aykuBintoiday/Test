package com.example.quanlisinhvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quanlisinhvien.model.Nganh;

public interface NganhRepository extends JpaRepository<Nganh, String> {
}