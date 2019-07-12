package com.hcl.LoanOffersOnMortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.LoanOffersOnMortgage.entity.Offers;
import com.hcl.LoanOffersOnMortgage.entity.User;
import com.hcl.LoanOffersOnMortgage.service.OfferServices;
import com.hcl.LoanOffersOnMortgage.service.PropertyRatesService;
import com.hcl.LoanOffersOnMortgage.service.UserService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OfferServices offerServices;
	
	@Autowired
	PropertyRatesService propertyRatesService;
	
	/**
	  * @desc from this controller we are going to check whether user is valid for offers or not and fetch the offer details
	  * @param $User user : we are passing user entity and checking if user is valid then the user details will be saved in user table.
	*/	
	
	@PostMapping("/userDetails")
	public ResponseEntity<List<Offers>> addUserDetails(@RequestBody User user) {

		List<Offers> propertyList=propertyRatesService.checkOfferapplicable(user);
		
		System.out.println(propertyList);
		return new ResponseEntity<List<Offers>>(propertyList, HttpStatus.OK);
	}

}
