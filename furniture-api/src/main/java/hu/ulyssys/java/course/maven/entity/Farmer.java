package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Farmer  extends AbstractEntity{

    @Column(name = "full_name", unique = true)
    private String fullName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Farmer farmer = (Farmer) o;

        if (getId() != null ? !getId().equals(farmer.getId()) : farmer.getId() != null) return false;
        return fullName != null ? fullName.equals(farmer.fullName) : farmer.fullName == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
