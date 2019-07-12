package com.hcl.LoanOffersOnMortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.LoanOffersOnMortgage.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
