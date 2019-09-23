package com.paytm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.paytm.model.Account;

public class Customerdaoimpl implements Customerdao {
	private static List<Account> list = new ArrayList<Account>();

	@Override
	public boolean createCustomer(Account c) {
		boolean result = list.add(c);
		return result;
	}

	@Override
	public Account createLogin(String name, String pwd) {
		Iterator<Account> itr = list.iterator();
		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.getName().equals(name) && a.getPwd().equals(pwd)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public float getbalance(Account a) {		
		return a.getBal();
	}

	@Override
	public float creditedbalance(Account a, float amt) {
				float bal = a.getBal();
				a.setBal(bal + amt);
				HashMap<Float, String> trans = a.gettransaction();
				trans.put(amt,"credit_deposit");
				a.settransaction(trans);
				return bal + amt;
			}

	@Override
	public float removedbalance(Account a, float wamt) {
		float bal = a.getBal();
		a.setBal(bal - wamt);
		HashMap<Float, String> trans = a.gettransaction();
		trans.put(wamt,"debit_withdraw");
		a.settransaction(trans);
		return bal-wamt ;
	}

	@Override
	public float transferedbalance(Account a, float tamt, String phno) {
		
		Iterator<Account> itr = list.iterator();
		while (itr.hasNext()) {
			Account a1 = itr.next();
			if(a1.getPhno().equals(phno)){
				float currentamt=a.getBal();
				a.setBal(currentamt-tamt);
				HashMap<Float, String> trans = a.gettransaction();
				trans.put(tamt,"transfered to "+phno);
				float scurrentamt=a1.getBal();
				a1.setBal(scurrentamt+tamt);
				HashMap<Float, String> trans1 = a1.gettransaction();
				trans1.put(tamt,"transfered from "+ a1.getPhno());
			}
			/*else
			{
				 throw new NullPointerException("invalid number");
			}*/
		}
		return a.getBal();
	}
	public  HashMap<Float, String> getTransactions(Account a){
		return a.gettransaction();
	}
	public List<Account> getallacc(){
		return list;
	}
		
	}

