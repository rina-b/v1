package com.example.findyourlaw.entity;

import com.example.findyourlaw.entity.enumerated.Role;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role = Role.ROLE_USER;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;



    @OneToMany(mappedBy = "costumer", orphanRemoval = true)
    private List<Mark> marks;

    @OneToMany(mappedBy = "costumer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CaseDescription> caseDescriptions;

    public Costumer(){}

    public Costumer(Long id, String name, String email, Role role, Location location){
        this.id = id;
        this.email = email;
        this.name = name;
        this.role = role;
        this.location = location;
    }

    public List<CaseDescription> getCaseDescriptions() {
        return caseDescriptions;
    }

    public void setCaseDescriptions(List<CaseDescription> caseDescriptions) {
        this.caseDescriptions = caseDescriptions;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Costumer)) return false;
        Costumer costumer = (Costumer) o;
        return id.equals(costumer.id) && name.equals(costumer.name) && email.equals(costumer.email) && role == costumer.role && Objects.equals(location, costumer.location) && Objects.equals(marks, costumer.marks) && Objects.equals(caseDescriptions, costumer.caseDescriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, role, location, marks, caseDescriptions);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", location=" + location +
                ", marks=" + marks +
                ", caseDescriptions=" + caseDescriptions +
                '}';
    }
}

