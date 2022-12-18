package com.emn.loginapp.Repository;

import com.emn.loginapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

}
