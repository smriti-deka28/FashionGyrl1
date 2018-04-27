package com.niit.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Dao.CustomerDao;
import com.niit.Model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;
	public void registerCustomer(Customer customer)
	{
		customerDao.registerCustomer(customer);
	}

}
