package lab.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column()
    private String password;

    @Column(nullable = false)
    private boolean isActive;

    @Column
    private String imageUrl;

    @ManyToMany
    private Set<Role> roles;

//    @Column
//    private LocalDateTime created;
//
//    @Column
//    private LocalDateTime modified;
//
//    @OneToMany(mappedBy = "seller")
//    private Set<Offer> offers;

    public UserEntity() {
//        this.offers = new HashSet<>();
        this.roles = new HashSet<>();
    }

//    public Set<Offer> getOffers() {
//        return offers;
//    }
//
//    public void setOffers(Set<Offer> offers) {
//        this.offers = offers;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//    public LocalDateTime getModified() {
//        return modified;
//    }
//
//    public void setModified(LocalDateTime modified) {
//        this.modified = modified;
//    }
}
