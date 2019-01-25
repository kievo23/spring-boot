package com.roysambu.kev.intellij.repositories;

import com.roysambu.kev.intellij.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRespository extends JpaRepository<Users,Integer> {


	
}
