package com.project.oms.model;

import com.project.oms.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String role;

    public User() {
    }

    public User(long id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    private User(UserBuilder builder) {
        this.id = builder.id;
        this.userName = builder.username;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static class UserBuilder {
        private Long id;
        private String username;
        private String password;
        private String role;

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    public static UserBuilder builder() {
        return new UserBuilder();
    }
    public UserDTO toDTO() {
        return new UserDTO(this.id, this.userName, this.role);
    }

}
