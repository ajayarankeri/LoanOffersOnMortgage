package com.hcl.LoanOffersOnMortgage.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.LoanOffersOnMortgage.entity.Offers;
import com.hcl.LoanOffersOnMortgage.entity.PropertyRates;
import com.hcl.LoanOffersOnMortgage.entity.User;
import com.hcl.LoanOffersOnMortgage.repository.OffersRepository;
import com.hcl.LoanOffersOnMortgage.repository.PropertyRatesRepository;
import com.hcl.LoanOffersOnMortgage.repository.UserRepository;

@Service
public class PropertyRatesService {
	
	@Autowired
	PropertyRatesRepository propertyRatesRepository;
	
	@Autowired
	OffersRepository offersRepository;
	
	@Autowired
	UserRepository userRepository;
	
	/**
	  * @throws ParseException 
	 * @desc In this function we are checking all conditions.
	*/	

	public List<Offers> checkOfferapplicable(User user) throws ParseException {
		
		Optional<PropertyRates> optionalPropertyRates = propertyRatesRepository.findByPincode(user.getPincode());
		
		boolean isPresentPropertyRates = optionalPropertyRates.isPresent();
		Optional<List<Offers>> offerList = null;
		List<Offers> offerDetails = null;
		
		if(isPresentPropertyRates)
		{
			PropertyRates pr =optionalPropertyRates.get();
			double myPropertyValue=calculatePropertyValue(pr.getSqure_feet_value(),user.getArea());			
			
			boolean eligibleAmountCriteria=getUserValidation(user);
			 if(eligibleAmountCriteria) {
				 userRepository.save(user);
			 }else {
				 System.out.println("User is not valid for the creiteria");
			 }
			 
			offerList=offersRepository.findByLoanAmountIsLessThanEqual(myPropertyValue*0.8);
			
			boolean isOffersPresent=offerList.isPresent();
			
			 if(isOffersPresent) {
				 offerDetails=offerList.get();
			 }
			
			
			
		}
		else
		{
			System.out.println("not found");
		}
		
		return offerDetails;
		

		
	}

	private boolean getUserValidation(User user) throws ParseException {
	
		if(user.getSalaryMonthly()<10000) {			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate DOB = LocalDate.parse(user.getDOB().toString(), formatter);
			
			int age= Period.between(DOB,LocalDate.now()).getYears();
			// System.out.println("BirtDate"+DOB+" currentTime"+LocalDate.now()+" Age:"+age);
			
			if(age<25) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}		
	}

	private double calculatePropertyValue(double squre_feet_value, int area) {
		
		return squre_feet_value*area;
	}


}
