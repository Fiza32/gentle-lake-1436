package com.masaischool.service;

import com.masaischool.dao.CustomerDao;
import com.masaischool.dao.CustomerDaoImpl;
import com.masaischool.entity.Customer;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CustomerDao cDao = new CustomerDaoImpl();
		cDao.login(username, password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDao cDao = new CustomerDaoImpl();
		cDao.changePassword(oldPassword, newPassword);
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDao cDao = new CustomerDaoImpl();
		cDao.deleteAccount();
	}

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		CustomerDao cDao = new CustomerDaoImpl();
		cDao.addCustomer(customer);
	}

}
