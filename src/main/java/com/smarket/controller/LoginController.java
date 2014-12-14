/**
 * 
 */
package com.smarket.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
public class LoginController {
        
	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(ModelMap model) {
		logger.debug("Received request to show login page");
		return "login";
	}
	
	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, 
			ModelMap model) {
		logger.debug("Received request to show login page");

		if (error == true) {
			model.put("error", "You have entered an invalid username or password!");
			return "login";
		} else {
			
			model.put("error", "");
		}
		return "index";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutUser(HttpSession session){
		if(session.getAttribute("user")!=null){
			session.invalidate();
		}
		return "index";
	}
	
	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a regular user
	 * tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
 	public String getDeniedPage() {
		System.out.println("Received request to show denied page");
		return "denied";
	}
}