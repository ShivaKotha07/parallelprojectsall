package com.paytm.services;

import java.util.HashMap;
import java.util.List;

import com.paytm.model.Account;

import com.paytm.model.Account;
public interface Customerservice {
	public boolean addCustomer(Account c);
	public Account getAccountLogin(String name,String pwd);
	public float showbalance(Account a);
	public float depositbalance(Account a,float amt);
	public float withdrawamount(Account a,float wamt);
	public  HashMap<Float, String> printTransactions(Account a);
	public float transferfund(Account a,float tamt,String phno);
	public boolean validateName(String name);
	public boolean validatePhone(String phno);
	public boolean validatepwd(String pwd);
	public boolean validateEmail(String email);
	public List<Account> getall();
	
	

}



