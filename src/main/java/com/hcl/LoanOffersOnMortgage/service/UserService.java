package com.hcl.LoanOffersOnMortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.LoanOffersOnMortgage.entity.User;
import com.hcl.LoanOffersOnMortgage.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void saveUserDetails(User user) {
		userRepository.save(user);		
	}

}
