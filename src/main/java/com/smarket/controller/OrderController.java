package com.smarket.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smarket.service.OrderService;

/**
 * Handles and retrieves the main requests
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	/**
	 * Handles and retrieves the AJAX Add page
	 */
    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public String getAjaxAddPage() {
    	logger.debug("Received request to show AJAX, place order page");
    	
    	// This will resolve to /WEB-INF/jsp/order-page.jsp
    	return "order-page";
	}
 
    /**
     * Handles request for adding two numbers
     */
    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public @ResponseBody Integer add(@RequestParam(value="inputNumber1", required=true) Integer inputNumber1,
    							@RequestParam(value="inputNumber2", required=true) Integer inputNumber2,
    							Model model) {
		logger.debug("Received request to place order");
		
		// Delegate to service to do the actual adding
		Integer sum = orderService.add(inputNumber1, inputNumber2);
		
		// @ResponseBody will automatically convert the returned value into JSON format
		// You must have Jackson in your classpath
		return sum;
	}
}
