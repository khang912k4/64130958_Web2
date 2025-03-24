package tiil.edu.SB_TruyenViewSangController.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class main {
	@GetMapping("/sv")
	public String traVeFormTinh() {
		return "SinhVien";
	}
	@GetMapping("/svTT")
	public String thongTin(
			@RequestParam("mssv") String MSSV,
			@RequestParam("hoten") String HOTEN,
			@RequestParam("namsinh") String NAMSINH,
			@RequestParam("gioitinh") String GIOITINH,
			Model m
			) {
		m.addAttribute("mssv1",MSSV);
		m.addAttribute("hoten1",HOTEN);
		m.addAttribute("namsinh1",NAMSINH);
		m.addAttribute("gioitinh1",GIOITINH);
		return "SinhVien";
	}
	@PostMapping("/svTTPost")
	public String thongTinPost(
			@RequestParam("mssv") String MSSV,
			@RequestParam("hoten") String HOTEN,
			@RequestParam("namsinh") String NAMSINH,
			@RequestParam("gioitinh") String GIOITINH,
			Model m
			) {
		m.addAttribute("mssv1",MSSV);
		m.addAttribute("hoten1",HOTEN);
		m.addAttribute("namsinh1",NAMSINH);
		m.addAttribute("gioitinh1",GIOITINH);
		return "SinhVien";
	}
}
