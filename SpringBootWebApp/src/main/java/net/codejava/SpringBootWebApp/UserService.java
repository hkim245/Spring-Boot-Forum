package net.codejava.SpringBootWebApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> listAll() {
		return userRepo.findAll();
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public User get(String username) {
		Optional<User> user = userRepo.findById(username);
		
		if (user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
	
	public void delete(String username) {
		userRepo.deleteById(username);
	}
}
