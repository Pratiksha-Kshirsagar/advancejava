package com.dal;

import java.util.List;

import com.pojo.Bank;

public interface BankDal {

	List<Bank> getallbank();
	int addacc(Bank obj);
	int updateacc(Bank obj);
	int deleteacc(String bankname);
	
	
		
		
	
		
}
