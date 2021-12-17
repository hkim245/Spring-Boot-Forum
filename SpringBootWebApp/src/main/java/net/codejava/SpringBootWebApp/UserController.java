package net.codejava.SpringBootWebApp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService user;
	
	/*@GetMapping("/user")
	public List<User> list() {
		return user.listAll();
	}
	
	@GetMapping("/user/{username}")
	public Optional<User> get(@PathVariable String username) {
		try {
			return user.get(username);
		}
		catch (NoSuchElementException e) {
			return Optional.empty();
		}
	}
	
	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "register_form";
	}
	
	@PostMapping("/register")
	public String add(@ModelAttribute User thisUser, Model model) {
		user.saveUser(thisUser);
		
		model.addAttribute("user", user);
		return "register_result";
	}*/
}
