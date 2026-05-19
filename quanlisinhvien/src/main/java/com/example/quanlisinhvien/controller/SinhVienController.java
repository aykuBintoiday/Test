package com.example.quanlisinhvien.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.quanlisinhvien.model.SinhVien;
import com.example.quanlisinhvien.model.Totnghiep;
import com.example.quanlisinhvien.repository.NganhRepository;
import com.example.quanlisinhvien.repository.SinhVienRepository;
import com.example.quanlisinhvien.repository.TotnghiepRepository;
import com.example.quanlisinhvien.repository.TruongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SinhVienController {

    @Autowired
    private TruongRepository truongRepository;

    @Autowired
    private NganhRepository nganhRepository;

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private TotnghiepRepository totnghiepRepository;

    @GetMapping("/")
    public String danhSach(Model model) {
        model.addAttribute("sinhviens", sinhVienRepository.findAll());
        return "danhsach";
    }

    @GetMapping("/them")
    public String showForm(Model model) {
        model.addAttribute("truongs", truongRepository.findAll());
        model.addAttribute("nganhs", nganhRepository.findAll());
        return "form-sinhvien";
    }

    @PostMapping("/luu")
    public String saveForm(@RequestParam String soCMND,
                           @RequestParam String hoTen,
                           @RequestParam String email,
                           @RequestParam String soDT,
                           @RequestParam String diaChi,
                           @RequestParam String maTruong,
                           @RequestParam String maNganh,
                           @RequestParam String heTN,
                           @RequestParam String ngayTN,
                           @RequestParam String loaiTN) {

        SinhVien sinhVien = new SinhVien(soCMND, hoTen, email, soDT, diaChi);
        sinhVienRepository.save(sinhVien);

        Totnghiep totnghiep = new Totnghiep(soCMND, maTruong, maNganh, heTN, ngayTN, loaiTN);
        totnghiepRepository.save(totnghiep);

        return "redirect:/";
    }

    @GetMapping("/sua/{soCMND}")
public String showEditForm(@PathVariable String soCMND, Model model) {
    Optional<SinhVien> sinhVienOptional = sinhVienRepository.findById(soCMND);

    if (sinhVienOptional.isEmpty()) {
        return "redirect:/";
    }

    model.addAttribute("sinhVien", sinhVienOptional.get());
    model.addAttribute("truongs", truongRepository.findAll());
    model.addAttribute("nganhs", nganhRepository.findAll());

    return "sua-sinhvien";
}

@PostMapping("/capnhat")
public String updateStudent(@RequestParam String soCMND,
                            @RequestParam String hoTen,
                            @RequestParam String email,
                            @RequestParam String soDT,
                            @RequestParam String diaChi) {

    SinhVien sinhVien = new SinhVien(soCMND, hoTen, email, soDT, diaChi);
    sinhVienRepository.save(sinhVien);

    return "redirect:/";
}

@GetMapping("/xoa/{soCMND}")
public String deleteStudent(@PathVariable String soCMND) {
    totnghiepRepository.deleteBySoCMND(soCMND);
    sinhVienRepository.deleteById(soCMND);

    return "redirect:/";
}

}