package ssi.webapplication.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(length = 50)
    private String username;

    @Column(length = 150)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(name = "enabled")
    private Boolean locked;

    @OneToMany(mappedBy = "user")
    private List<AuthoritiesEntity> authoritiesEntities;

    @OneToOne(mappedBy = "user")
    private UserInfoEntity userDetails;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<AuthoritiesEntity> getAuthoritiesEntities() {
        return authoritiesEntities;
    }

    public void setAuthoritiesEntities(List<AuthoritiesEntity> authoritiesEntities) {
        this.authoritiesEntities = authoritiesEntities;
    }

    public UserInfoEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserInfoEntity userDetails) {
        this.userDetails = userDetails;
    }
}