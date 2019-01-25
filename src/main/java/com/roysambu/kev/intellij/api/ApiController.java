package com.roysambu.kev.intellij.api;

import java.util.List;
import java.util.Optional;

import com.roysambu.kev.intellij.models.Users;
import com.roysambu.kev.intellij.repositories.UsersRespository;
import com.roysambu.kev.intellij.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    UsersRespository usersRepository;
    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<Users> welcome() {
        return usersService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable Integer id) {
        return usersService.getUser(id);
    }

    @PostMapping("/users/create")
    public void add(@RequestBody Users user) {
        usersService.addUser(user);
    }

    @PostMapping("/users/update/{id}")
    public void update(@RequestBody Users user,@PathVariable Integer id  ) {
        usersService.updateUser(user);
    }

    @GetMapping("/users/delete/{id}")
    public void update(@PathVariable Integer id  ) {
        usersService.deleteUser(id);
    }
}