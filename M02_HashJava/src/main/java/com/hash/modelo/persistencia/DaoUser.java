package com.hash.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hash.modelo.entidad.User;

@Repository
public interface DaoUser extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPwd(String username, String pwd);

}
