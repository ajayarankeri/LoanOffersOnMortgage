package com.hcl.LoanOffersOnMortgage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.LoanOffersOnMortgage.entity.Offers;

public interface OffersRepository extends JpaRepository<Offers, Long>{

	Optional<List<Offers>> findByLoanAmountIsLessThanEqual(double loanAmount);

	
}
