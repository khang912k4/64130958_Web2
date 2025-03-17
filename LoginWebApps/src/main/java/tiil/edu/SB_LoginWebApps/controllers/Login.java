package tiil.edu.SB_LoginWebApps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Login {
	@PostMapping("/profile")
	public String profilePost(@RequestParam("id") String id,@RequestParam("password") String password,Model model) {
		if(id.equals("64130958")&&password.equals("12345")) {
			return("profilePage");
		}
		return "loginPage";
	}
	@GetMapping("/profile")
	public String profileGet(@RequestParam("id") String id,@RequestParam("password") String password,Model model) {
		if(id.equals("64130958")&&password.equals("12345")) {
			return("profilePage");
		}
		return("profilePage");
	}
	@GetMapping("/login")
	public String loginHandler() {
		return "loginPage";
	}
}
