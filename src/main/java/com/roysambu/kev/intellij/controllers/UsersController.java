package com.roysambu.kev.intellij.controllers;

import java.util.List;
import java.util.Optional;

import com.roysambu.kev.intellij.models.Users;
import com.roysambu.kev.intellij.repositories.UsersRespository;
import com.roysambu.kev.intellij.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class UsersController {
	@Autowired
	UsersService usersService;

	@Autowired
	UsersRespository usersRepo;
	
	@GetMapping("/")
	public String welcome(Model model) {
		List<Users> u = usersService.getAllUsers();
		model.addAttribute("users",u);
		model.addAttribute("title","Wamupay Users");
		return "users/index";
	}
	
	@GetMapping("/users/{id}")
	public String getUser(@PathVariable Integer id,Model model) {
		Users user = usersService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "View User");
		return "users/index";
	}

	@GetMapping("/users/edit/{id}")
	public String updateUser(@PathVariable Integer id,Model model) {
		Users user = usersService.getUser(id);
			model.addAttribute("user",user );
			model.addAttribute("title", "Edit User");
			return "users/edit";
	}

	@GetMapping("/users/create")
	public String createUser(Model model) {
		model.addAttribute("title", "Create User");
		return "users/add";
	}
	
	@PostMapping("/users/create")
	public String add(HttpServletRequest req, Model model) {
		Users u = new Users();
		u.setName(req.getParameter("name"));
		u.setPhone(req.getParameter("phone"));
		u.setTestosterone(req.getParameter("testosterone"));
		usersService.addUser(u);
		return "redirect:/";
	}
	
	@PostMapping("/users/update/{id}")
	public String editUser(HttpServletRequest req, @PathVariable Integer id ,Model model) {
		Users u = new Users();
		u.setId(id);
		u.setName(req.getParameter("name"));
		u.setPhone(req.getParameter("phone"));
		u.setTestosterone(req.getParameter("testosterone"));
		usersService.updateUser(u);
		return "redirect:/";
	}
	
	@GetMapping("/users/delete/{id}")
	public String update(@PathVariable Integer id,Model model) {
		usersService.deleteUser(id);
		return "redirect:/";
	}
}
