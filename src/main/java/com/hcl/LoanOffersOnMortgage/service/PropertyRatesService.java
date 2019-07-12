package com.hcl.LoanOffersOnMortgage.service;

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
	  * @desc In this function we are checking all conditions.
	*/	

	public List<Offers> checkOfferapplicable(User user) {
		
		Optional<PropertyRates> optionalPropertyRates = propertyRatesRepository.findByPincode(user.getPincode());
		
		boolean isPresentPropertyRates = optionalPropertyRates.isPresent();
		Optional<List<Offers>> offerList = null;
		List<Offers> offerDetails = null;
		
		if(isPresentPropertyRates)
		{
			PropertyRates pr =optionalPropertyRates.get();
			double myPropertyValue=calculatePropertyValue(pr.getSqure_feet_value(),user.getArea());			
			
			boolean eligibleAmountCriteria=getEligibleAmountCriteria(myPropertyValue);
			 if(eligibleAmountCriteria) {
				 userRepository.save(user);
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

	private boolean getEligibleAmountCriteria(double myPropertyValue) {
		   if(myPropertyValue*0.8>500000) {
			   return true;
		   }else {
			   return false;
		   }
			   
		
	}

	private double calculatePropertyValue(double squre_feet_value, int area) {
		
		return squre_feet_value*area;
	}


}
