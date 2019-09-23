package com.paytm.dao;

import java.util.HashMap;
import java.util.List;

import com.paytm.model.Account;

public interface Customerdao {
	public boolean createCustomer(Account c);

	public Account createLogin(String name, String pwd);

	public float getbalance(Account a);
	
	public float creditedbalance(Account a,float amt);
	public float removedbalance(Account a,float wamt);
	public float transferedbalance(Account a,float tamt,String phno);
	public  HashMap<Float, String> getTransactions(Account a);
	public List<Account> getallacc();
}