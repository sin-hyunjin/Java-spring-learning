package com.cos.jwt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles; // USER, ADMIN

    /** roles가 두가지 이상 이라면  리스트로 담음 */
    public List<String> getRoleList() {
        if (!this.roles.isEmpty()) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
