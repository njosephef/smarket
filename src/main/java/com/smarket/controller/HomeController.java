package com.smarket.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves the home or admin page depending on the URI template.
 * Only the admin can see the admin page, however.
 * 
 */
@Controller
public class HomeController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getHomePage() {
    	logger.debug("Received request to show common page");
    	return "index";
	}
	
    /**
     * Handles and retrieves the admin JSP page that only admins can see
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
    	logger.debug("Received request to show admin page");
    	return "admin";
	}
}
