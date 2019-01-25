package com.roysambu.kev.intellij.service;

import java.util.List;
import java.util.Optional;

import com.roysambu.kev.intellij.models.Users;
import com.roysambu.kev.intellij.repositories.UsersRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersService {
	
	@Autowired
	UsersRespository usersRepository;
	
	public List<Users> getAllUsers(){
		return (List<Users>) usersRepository.findAll();
		
	}
	
	public Users getUser(Integer id) {
		return usersRepository.getOne(id);
	}
	
	public void addUser(Users user) {
		usersRepository.save(user);
	}
	
	public void updateUser(Users user) {
		usersRepository.save(user);
	}
	
	public void deleteUser(Integer id) {
		usersRepository.deleteById(id);
	}
}
