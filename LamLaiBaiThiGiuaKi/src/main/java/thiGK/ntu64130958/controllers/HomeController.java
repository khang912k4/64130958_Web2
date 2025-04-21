package thiGK.ntu64130958.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu64130958.models.Page;
import thiGK.ntu64130958.models.Post;




@Controller
public class HomeController{
	ArrayList<Page> pages = (ArrayList<Page>) Arrays.asList(
            new Page("1", "Home", "home, welcome", "Welcome to our website!", null),
            new Page("2", "About", "about, info", "We are a tech company.", "1"),
            new Page("3", "Services", "services, what we do", "Here are our services.", "1"),
            new Page("4", "Contact", "contact, support", "Contact us here.", "1"),
            new Page("5", "Blog", "blog, news", "Read our latest blog posts.", "1"),
            new Page("6", "Careers", "jobs, hiring", "Join our team!", "1"),
            new Page("7", "FAQ", "faq, help", "Frequently asked questions.", "1"),
            new Page("8", "Terms", "terms, policy", "Our terms and policies.", "1"),
            new Page("9", "Privacy", "privacy, data", "Your privacy matters.", "8"),
            new Page("10", "Team", "team, staff", "Meet the team.", "2")
        );
	ArrayList<Post> posts = (ArrayList<Post>) Arrays.asList(
            new Post("1", "Introduction to Java", "Java is a versatile language.", "101"),
            new Post("2", "OOP Concepts", "Let's dive into OOP: Encapsulation, Inheritance, Polymorphism.", "101"),
            new Post("3", "Spring Boot Basics", "Spring Boot makes it easy to create stand-alone apps.", "102"),
            new Post("4", "RESTful APIs", "Build powerful APIs with Spring MVC.", "102"),
            new Post("5", "Understanding Databases", "Relational vs NoSQL databases explained.", "103"),
            new Post("6", "MySQL Tutorial", "A quick guide to MySQL syntax and queries.", "103"),
            new Post("7", "Frontend vs Backend", "What’s the difference between frontend and backend dev?", "104"),
            new Post("8", "JavaScript Essentials", "Learn the basics of JavaScript in a flash.", "104"),
            new Post("9", "Deployment with Docker", "Containerize your app for smooth deployment.", "105"),
            new Post("10", "CI/CD Basics", "Automate your build and deployment pipeline.", "105")
        );
	@GetMapping("/")
	public String index() {
		return "Layout";
	}
	@GetMapping("page/all")
	public String pageAll(Model model) {
		model.addAttribute("pages",pages);
		model.addAttribute("menu","listPage");
		return "Layout";
	}
	@GetMapping("page/new")
	public String pageAdd(Model model) {
		model.addAttribute("menu","addPage");
		return "Layout";
	}
	@PostMapping("page/add")
	public String pageAddHandle(@RequestParam(name="pageName") String name,@RequestParam(name="keyword") String key,@RequestParam(name="content") String content,@RequestParam(name="parentPageId") String parentId,Model model) {
		String id=pages.size()+1+"";
		pages.add(new Page(id, name, key, content, parentId));
		model.addAttribute("menu","addPage");
		return "Layout";
	}
	@PostMapping("page/delete/id")
	public String pageDeleteHandle(@RequestParam(name="id") String id,Model model) {
		for (Page i:pages) {
			if(i.id.equals(id)) {
				pages.remove(i);
				break;
			}
		}
		model.addAttribute("pages",pages);
		model.addAttribute("menu","listPage");
		return "Layout";
	}
	@PostMapping("page/view/id")
	public String pageViewHandle(@RequestParam(name="id") int id,Model model ) {
		for (Post i:posts) {
			if(i.id.equals(id)) {
				model.addAttribute("item",i);
				break;
			}
		}
		model.addAttribute("menu","detailPage");
		return "Layout";
	}
	@GetMapping("post/new")
	public String postAdd(Model model) {
		model.addAttribute("menu","addPost");
		return "Layout";
	}
    @PostMapping("post/add")
	public String pageAddHandle(@RequestParam(name="title") String name,@RequestParam(name="content") String value,@RequestParam(name="categoryId") String cId,Model model) {
		String id=posts.size()+1+"";
		posts.add(new Post(id, name, value, cId));
		model.addAttribute("menu","addPost");
		return "Layout";
	}
	@GetMapping("post/all")
	public String postAll(Model model) {
		model.addAttribute("posts",posts);
		model.addAttribute("menu","listPost");
		return "Layout";
	}
	@PostMapping("post/view/id")
	public String postViewHandle(@RequestParam(name="id") int id ,Model model) {
		for (Post i:posts) {
			if(i.id.equals(id)) {
				model.addAttribute("item",i);
				break;
			}
		}
		model.addAttribute("content","postDetail");
		return "Layout";
	}
	@PostMapping("post/delete/id")
	public String postDeleteHandle(@RequestParam(name="id") String id,Model model) {
		for (Post i:posts) {
			if(i.id.equals(id)) {
				posts.remove(i);
				break;
			}
		}
		model.addAttribute("posts",posts);
		model.addAttribute("menu","listPost");
		return "Layout";
	}
}	