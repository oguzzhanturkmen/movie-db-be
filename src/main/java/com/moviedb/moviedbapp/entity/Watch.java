package com.moviedb.moviedbapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "watch")
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long movieId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore // to avoid infinite recursion -- derste serializationda problem yaşamamak için dedi
    User user;
}
