package com.moviedb.moviedbapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String userName;
    String password;
    String email;


}
