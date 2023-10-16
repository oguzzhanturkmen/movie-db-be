package com.moviedb.moviedbapp.repos;

import com.moviedb.moviedbapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
