package com.example.quanlisinhvien.controller;

import com.example.quanlisinhvien.dto.SinhVienForm;
import com.example.quanlisinhvien.model.SinhVien;
import com.example.quanlisinhvien.repository.NganhRepository;
import com.example.quanlisinhvien.repository.TruongRepository;
import com.example.quanlisinhvien.service.SinhVienService;
import com.example.quanlisinhvien.repository.SinhVienRepository;
import com.example.quanlisinhvien.repository.TotnghiepRepository;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SinhVienController {

    private final SinhVienService sinhVienService;
    private final TruongRepository truongRepository;
    private final NganhRepository nganhRepository;
    private final SinhVienRepository sinhVienRepository;
    private final TotnghiepRepository totnghiepRepository;

    public SinhVienController(SinhVienService sinhVienService,
                              TruongRepository truongRepository,
                              NganhRepository nganhRepository,
                              SinhVienRepository sinhVienRepository,
                              TotnghiepRepository totnghiepRepository) {
        this.sinhVienService = sinhVienService;
        this.truongRepository = truongRepository;
        this.nganhRepository = nganhRepository;
        this.sinhVienRepository = sinhVienRepository;
        this.totnghiepRepository = totnghiepRepository;
    }

    @GetMapping("/")
    public String danhSach(Model model) {
        model.addAttribute("sinhviens", sinhVienService.findAll());
        return "danhsach";
    }

    @GetMapping("/them")
    public String showForm(Model model) {
        model.addAttribute("sinhVienForm", new SinhVienForm());
        model.addAttribute("truongs", truongRepository.findAll());
        model.addAttribute("nganhs", nganhRepository.findAll());
        return "form-sinhvien";
    }

    @PostMapping("/luu")
    public String saveForm(@Valid @ModelAttribute("sinhVienForm") SinhVienForm form,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            model.addAttribute("truongs", truongRepository.findAll());
            model.addAttribute("nganhs", nganhRepository.findAll());
            return "form-sinhvien";
        }

        sinhVienService.save(form);
        return "redirect:/";
    }

    @GetMapping("/sua/{soCMND}")
    public String showEditForm(@PathVariable String soCMND, Model model) {
        SinhVien sinhVien = sinhVienService.findById(soCMND).orElse(null);

        if (sinhVien == null) {
            return "redirect:/";
        }

        model.addAttribute("sinhVien", sinhVien);
        return "sua-sinhvien";
    }

    @PostMapping("/capnhat/{soCMND}")
    public String updateStudent(@PathVariable String soCMND,
                                @ModelAttribute SinhVien sinhVien) {
        sinhVienService.update(soCMND, sinhVien);
        return "redirect:/";
    }

    @GetMapping("/xoa/{soCMND}")
    public String deleteStudent(@PathVariable String soCMND) {
        sinhVienService.delete(soCMND);
        return "redirect:/";
    }

    @GetMapping("/timkiem-coban")
public String showSearchBasic() {
    return "timkiem-coban";
}

@GetMapping("/timkiem-coban/ketqua")
public String searchBasic(@RequestParam String keyword, Model model) {
    model.addAttribute("keyword", keyword);
    model.addAttribute("results", sinhVienRepository.searchBasic(keyword));
    return "timkiem-coban";
}

@GetMapping("/timkiem-totnghiep-vieclam")
public String showSearchGraduationAndJob() {
    return "timkiem-totnghiep-vieclam";
}

@GetMapping("/timkiem-totnghiep-vieclam/ketqua")
public String searchGraduationAndJob(@RequestParam String keyword, Model model) {
    model.addAttribute("keyword", keyword);
    model.addAttribute("results", totnghiepRepository.searchGraduationAndJob(keyword));
    return "timkiem-totnghiep-vieclam";
}
}