package com.masaischool.service;

import com.masaischool.entity.Customer;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;

public interface CustomerService {
	void addCustomer(Customer customer) throws SomeThingWentWrongException;
	void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException;
	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;
	void deleteAccount() throws SomeThingWentWrongException;
}
