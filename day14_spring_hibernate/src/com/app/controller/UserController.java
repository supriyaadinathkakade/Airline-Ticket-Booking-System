package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IUserService;

//add ...... to send /WEB-INF/views/user/login.jsp) to clnt
@Controller
@RequestMapping("/user")
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// actual view name : /WEB-INF/views/user/login.jsp
	}

	// add a req handling method to process the form
	// display (sop) email n pwd
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password,
			Model map,HttpSession session) {
		System.out.println("in process login form " + email + " " + password);
		// invoke service's method for validation
		try {
			Vendor validatedUser = userService.authenticateUser(email, password);
			// successful login
			// add a mesg Admin/Vendor login successful
			session.setAttribute("message", validatedUser.getRole() + " login successful!");
			//add validated user details in session scope , to remember it till logout
			session.setAttribute("user_details", validatedUser);
			// if user : vendor => redirect the clnt to details page
			// (/WEB-INF/views/vendor/vendor_details.jsp)
			// Resp is sent to the clnt SC 302 | header : location : /vendor/details cookie
			// , body : empty
			// clnt browser sends a new request : http://host:port/day14/vendor/details ,
			// method=get
			if (validatedUser.getRole().equals(Role.VENDOR))
				return "redirect:/vendor/details";
			// SC(WC) response.sendRedirect(response.encodeRedirectURL("/vendor/details"));
			// if user : admin => redirect the clnt to vendor list page ,accessible only to
			// admin
			// (/WEB-INF/views/admin/list.jsp)
			return "redirect:/admin/list";

		} catch (RuntimeException e) {
			// failed login
			// add err mesg as the model attribute
			map.addAttribute("message", "Invalid Login , Please Retry");
			// forward the client to login page , highlighted with error mesg.
			return "/user/login";// actual view name : /WEB-INF/views/user/login.jsp
		}

	}

}
