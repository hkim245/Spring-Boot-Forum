package net.codejava.SpringBootWebApp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@Autowired
	private UserService user;
	
	@RequestMapping("/test")
	public String test() {
		
		System.out.println("AppController->test()");
		
		return "test";
	}
	
	@RequestMapping("/list_contact")
	public String listContact(Model model) {
		
		ContactBusiness business = new ContactBusiness();
		List<Contact> contactList = business.getContactList();
		
		model.addAttribute("contacts", contactList);
		
		return "contact";
	}
	
	/*@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "register_form";
	}*/
	
	/*@PostMapping("/register")
	public String registerSubmit(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "register_result";
	}*/
	
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
	}*/
	
	@GetMapping("/register")
	public String userForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "register_form";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User thisUser, Model model) {
		user.saveUser(thisUser);
		
		model.addAttribute("user", thisUser);
		return "register_result";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		return "login_form";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User thisUser, Model model) {
		User logUser = user.get(thisUser.username);
		
		if (logUser.getUsername().equals(thisUser.getUsername()) && logUser.getPassword().equals(thisUser.getPassword())) {
			model.addAttribute("user", thisUser);
			return "login_result";
		}
		else {
			return "login_fail";
		}
	}
	
	@GetMapping("/logout")
	public String loginForm() {
		return "logout";
	}
	
	/*@PutMapping("/user/{username}")
	public void update(@RequestBody User thisUser, @PathVariable String username) {
		try {
			Optional<User> userExist = user.get(username);
			user.saveUser(thisUser);
		}
		catch (NoSuchElementException e){
			
		}
	}
		
	@DeleteMapping("/users/{username}")
	public void delete(@PathVariable String username) {
		user.delete(username);
	}*/
}
