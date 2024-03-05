package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;

	@Override
	public String addUser(User user) {

		userRepo.save(user);
		return "User added Successfully";
	}

	//method to check if email already present or not
	@Override
	public boolean emailExists(String email) {
		if(userRepo.findByEmail(email)!=null) {
			return true;
		}
		else{
			return false;
		}

	}

	@Override
	public boolean validateUser(String email, String password) {
		User user=userRepo.findByEmail(email);
		
		String db_password = user.getPassword();
		if(db_password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getRoleType(String email) {
		User user = userRepo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {
		User user = userRepo.findByEmail(email);
		return user;
		
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}

}
