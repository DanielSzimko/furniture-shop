package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;

@NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "select u from AppUser u where u.username=:username")
@Entity
@Table
public class AppUser extends AbstractEntity {
    public static final String FIND_BY_USERNAME = "AppUser.findByUsername";
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "password_hash")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
