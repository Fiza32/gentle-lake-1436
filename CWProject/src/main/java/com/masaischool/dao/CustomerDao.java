package com.masaischool.dao;

import com.masaischool.entity.Customer;
import com.masaischool.exceptions.SomeThingWentWrongException;

public interface CustomerDao {
	void login(String username, String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;
	void deleteAccount() throws SomeThingWentWrongException;
	void addCustomer(Customer customer) throws SomeThingWentWrongException;
}
