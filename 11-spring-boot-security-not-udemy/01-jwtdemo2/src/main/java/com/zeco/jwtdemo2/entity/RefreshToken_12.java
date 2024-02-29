package com.zeco.jwtdemo2.entity;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.Optional;

@Entity
@Table(name = "refresh_tokens")
public class RefreshToken_12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "exp_date")
    private Instant exp_date;

    @OneToOne
    @JoinColumn(name  = "user_id" , referencedColumnName = "id")
    private Users_01 user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExp_date() {
        return exp_date;
    }

    public void setExp_date(Instant exp_date) {
        this.exp_date = exp_date;
    }

    public Users_01 getUser() {
        return user;
    }

    public void setUser(Users_01 user) {
        this.user = user;
    }


}
