package thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models.Page;
import thiGK.ntu64130958.NguyenPhucKhang_baiThiGK.models.Post;

@Controller
public class HomeController {
	List<Page> dsPage = new ArrayList<>();
	List<Post> dsPost = new ArrayList<>();
	public HomeController() {
		
	}
	@GetMapping("/page/all")
	public String Page_List(Model model) {
		model.addAttribute("dsPage",this.dsPage);
		return "pageList";
	}
	@GetMapping("page/new")
	public String Page_Addnew(Model model) {
		return "pageAddnew";
	}
	@GetMapping("page/view/{id}")
	public String Page_View(Model model) {
		return "pageView";
	}
	@GetMapping("page/delete/id")
	public String Page_Delete(Model model) {
		return "pageDelete";
	}
}
