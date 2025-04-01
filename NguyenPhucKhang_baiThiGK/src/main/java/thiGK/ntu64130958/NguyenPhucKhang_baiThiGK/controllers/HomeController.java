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
		this.dsPage.add(new Page("123","Khang","npk","sinh vien","234"));
		this.dsPage.add(new Page("123","Khang","npk","sinh vien","234"));
		this.dsPage.add(new Page("123","Khang","npk","sinh vien","234"));
		this.dsPage.add(new Page("123","Khang","npk","sinh vien","234"));
		this.dsPost.add(new Post("123","Khang","npk","234"));
		this.dsPost.add(new Post("123","Khang","npk","234"));
		this.dsPost.add(new Post("123","Khang","npk","234"));
		this.dsPost.add(new Post("123","Khang","npk","234"));
	}
	@GetMapping("/page/all")
	public String Page_List(Model model) {
		model.addAttribute("dsPage",this.dsPage);
		model.addAttribute("page",new Page());
		return "Page/pageList";
	}
	@GetMapping("/page/new")
	public String Page_Addnew(Model model) {
		
		return "Page/pageAddnew";
	}
	@GetMapping("/page/view/{id}")
	public String Page_View(Model model) {
		return "Page/pageView";
	}
	@GetMapping("/page/delete/id")
	public String Page_Delete(Model model) {
		return "Page/pageDelete";
	}

	
	@GetMapping("/post/all")
	public String Post_List(Model model) {
		model.addAttribute("dsPost",this.dsPost);
		model.addAttribute("post",new Post());
		return "Post/postList";
	}
	@GetMapping("/post/new")
	public String Post_Addnew(Model model) {
		return "Post/postAddnew";
	}
	@GetMapping("/post/view/{id}")
	public String Post_View(Model model) {
		return "Post/postView";
	}
	@GetMapping("/post/delete/id")
	public String Post_Delete(Model model) {
		return "Post/postDelete";
	}
}
