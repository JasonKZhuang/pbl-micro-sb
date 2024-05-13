package com.zkz.microservice.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User implements Serializable {

    //@GeneratedValue //reference: https://www.baeldung.com/hibernate-identifiers
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate", nullable = false)
    private Date updatedDate;

    @Size(min = 3, max = 120, message = "The length of email must between 3 and 120.")
    @Column(name = "username", nullable = false, length = 120, unique = true)
    private String username;

    @NotNull(message = "Email must not be null.")
    @Size(min = 5, max = 255, message = "The length of email must between 5 and 120.")
    @Column(name = "userEmail", nullable = false, length = 120, unique = true)
    private String userEmail;

    @NotNull(message = "Password must not be null.")
    @Size(min = 6, max = 50, message = "The length of password must between 6 and 50.")
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @NotNull(message = "User Name must not be null.")
    @Size(min = 2, max = 255, message = "The length of user first name must between 2 and 50.")
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @NotNull(message = "User Name must not be null.")
    @Size(min = 2, max = 255, message = "The length of user last name must between 2 and 50.")
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "avatarURI", length = 500, nullable = true)
    private String avatarURI;

    @Column(name = "emailVerificationToken", nullable = true, length = 1024)
    @Size(min = 8, max = 255)
    private String emailVerificationToken;

    @Column(name = "emailVerificationStatus", nullable = false)
    private Boolean emailVerificationStatus = false;

    @Column(name = "systemOriginated", nullable = true, length = 100)
    private String systemOriginated;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
}

