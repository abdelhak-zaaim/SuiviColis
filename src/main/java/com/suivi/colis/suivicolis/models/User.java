/*
 * *
 *  * @project : SuiviColis
 *  * @created : 23/04/2024, 17:51
 *  * @modified : 23/04/2024, 17:51
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  *
 */

package com.suivi.colis.suivicolis.models;

import com.suivi.colis.suivicolis.models.enums.Role;
import com.suivi.colis.suivicolis.models.enums.UserStatus;
import com.suivi.colis.suivicolis.validations.uservalidate.UserValidate;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity

@DiscriminatorColumn(name = Role.USER_ROLE_NAME, discriminatorType = DiscriminatorType.STRING)
@UserValidate
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;
    private String password;
    @Column(name = Role.USER_ROLE_NAME, insertable = false, updatable = false , nullable = false)
    private String role;

    private String phone;
    @ManyToOne
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column(unique = true)
    private String token;
    @Column(unique = true)
    private String refreshToken;
    @Column(unique = true)
    private String cin;

    private Date dateOfBirth;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return status != UserStatus.EXPIRED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status != UserStatus.LOCKED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return status != UserStatus.EXPIRED;
    }

    @Override
    public boolean isEnabled() {
        return status == UserStatus.ACTIVE;
    }


}