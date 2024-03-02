package com.cos.security1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role; // ROLE_USER, ROLE_ADMIN

    private String provider; // google
    private String providerId; // sub=107072109731784464688
    @CreationTimestamp // java.sql
    private Timestamp createData;

    @Builder
    public User(int id, String username, String password, String email, String role, String provider, String providerId, Timestamp createData) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createData = createData;
    }


}
