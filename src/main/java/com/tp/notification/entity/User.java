package com.tp.notification.entity;

import com.tp.notification.annotation.constraints.CharacterLimitation;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_seq", initialValue = 2, allocationSize = 1)
    private Long id;

    @NotBlank(message = "Поле не может быть пустым")
    @Length(max = 20, message = "Длина не может превышать 20 символов")
    @CharacterLimitation
    private String username;

    @NotBlank(message = "Поле не может быть пустым")
    private String password;

    @Column(columnDefinition="boolean default false")
    private boolean active;

    private String activationCode;

    private Date dateOfCreation;

    @NotBlank(message = "Поле не может быть пустым")
    @Email(message = "Email некорректный")
    @Length(max = 100, message = "Длина не может превышать 100 символов")
    private String email;

    private String firstName;

    private String lastName;

    private String company;

    @Column(columnDefinition="boolean default false")
    private boolean approved;

    private Date expiryDateOfApproval;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Column(columnDefinition="boolean default false")
    private boolean askedForApproval;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<FileInf> fileInf;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private PasswordResetToken passwordResetToken;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isAskedForApproval() {
        return askedForApproval;
    }

    public void setAskedForApproval(boolean askedForApproval) {
        this.askedForApproval = askedForApproval;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getExpiryDateOfApproval() {
        return expiryDateOfApproval;
    }

    public void setExpiryDateOfApproval(Date expiryDateOfApproval) {
        this.expiryDateOfApproval = expiryDateOfApproval;
    }

    public List<FileInf> getFileInf() {
        return fileInf;
    }

    public void setFileInf(List<FileInf> fileInf) {
        this.fileInf = fileInf;
    }

    public PasswordResetToken getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(PasswordResetToken passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }
}