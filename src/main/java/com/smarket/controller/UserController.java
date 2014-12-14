package com.smarket.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smarket.form.UserForm;
import com.smarket.model.User;
import com.smarket.service.UserService;
import com.smarket.validator.UserValidator;


/**
 * 
 * @author anirudh
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value="/signup" , method = RequestMethod.GET)
	public String showCreateUserPage(Model model) {
		UserForm user = new UserForm();
		model.addAttribute("user", user);
		return "createUser";
	}

	/**
	 * POST request to create User
	 * 
	 * @param modell
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserForm user,
			BindingResult errors,HttpSession session) {

		userValidator.validate(user, errors);
		String password = null;
		MessageDigest messageDigest = null;
        try
        {
            messageDigest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } 
        messageDigest.update(user.getPassword().getBytes(), 0, user.getPassword().length());
		password = new BigInteger(1, messageDigest.digest()).toString(); // Encrypted string
		
        System.out.println(password);
        
		user.setPassword(password);
		
		if (!errors.hasErrors()) {
			User newUser = populateUserFromForm(user);
			userService.createUser(newUser);
			session.setAttribute("user", newUser);
			return "index";
		} else {
			return "createUser";
		}
	}

	private User populateUserFromForm(UserForm user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		return newUser;
	}
	
	private UserForm transform(User user){
		UserForm newUser = new UserForm();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		return newUser;
	}
	
	/**
	 * Returns JSON data
	 * @param id
	 * @return
	 */

	@RequestMapping(value="/json/{id}" , method =RequestMethod.GET )
    @ResponseBody
	public UserForm getUserInJSon(@PathVariable String id){
		User userById = userService.getUserById(Long.valueOf(id));
		if(userById!=null){
			System.out.println("there is result");
			return transform(userById);
		}else{
			System.out.println("empty");
			return new UserForm();
			
		}
		 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUsers(Model model){
		 List<User> users = userService.getUsers();
		 model.addAttribute("users", users);
		 return "searchUsers";
	}
	
	
}
