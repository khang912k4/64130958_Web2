package tiil.edu.TongHopGK.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	List<SinhVien> dsSV = new ArrayList<>();

    public HomeController() {
        dsSV.add(new SinhVien("SV001", "Nguyễn Văn A", 8.5));
        dsSV.add(new SinhVien("SV002", "Trần Thị B", 7.0));
        dsSV.add(new SinhVien("SV003", "Lê Văn C", 6.8));
    }
    @GetMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("dsSV", dsSV);
        return "list";
    }
    @GetMapping("/homepage")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    @GetMapping("/address")
    public String addressPage() {
        return "address";
    }
}