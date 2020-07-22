package com.amazonCustomer.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amazonCustomer.RestService.AmazonCustService;
import com.amazonCustomer.model.AmazonCustomer;

@RestController
public class AmazonCustController {
	@Autowired(required = true)
	AmazonCustService autocustserv;

	@RequestMapping(value = "/amazoncustomer", method = RequestMethod.GET, produces = "application/json")

	public @ResponseBody List<AmazonCustomer> findallcustomer() {

		List<AmazonCustomer> lst = autocustserv.findallcustomer();
	/*	if (lst.isEmpty()) {
			System.out.println("No Content");
			return new ResponseEntity<List<AmazonCustomer>>(lst, HttpStatus.NO_CONTENT);
		}*/
		System.out.println("done1111");
		return lst;

	}
   
	@RequestMapping(value = "/amazoncustomer/{id}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<AmazonCustomer> findbyid(@PathVariable("id") int id) {
		System.out.println("data" + id);
		autocustserv.findbyid(id);
		System.out.println("mai niche controller ke");
		return new ResponseEntity<AmazonCustomer>(HttpStatus.OK);

	}
}
