package com.amazonCustomer.RestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonCustomer.RestDAO.AmazonCustDAO;
import com.amazonCustomer.model.AmazonCustomer;

@Service
public class AmazonCustService {

	@Autowired(required=true)
	AmazonCustDAO amazcustDAO;
	
	public List<AmazonCustomer> findallcustomer(){
		return amazcustDAO.findallcustomer();
	}
	public AmazonCustomer findbyid(int id){
		return amazcustDAO.findbyid(id);
	}
}
