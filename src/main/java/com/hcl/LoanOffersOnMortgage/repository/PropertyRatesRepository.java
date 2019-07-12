package com.hcl.LoanOffersOnMortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.LoanOffersOnMortgage.entity.PropertyRates;

public interface PropertyRatesRepository extends JpaRepository<PropertyRates, Long>{

	Optional<PropertyRates> findByPincode(int pincode);




}
