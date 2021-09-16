package com.example.findyourlaw.entity;

import com.example.findyourlaw.entity.enumerated.BranchOfLaw;
import com.example.findyourlaw.entity.enumerated.Degree;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lawyers")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "lawyer_email", nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column()
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private Degree degree;

    private String workExperience;

    @Enumerated(EnumType.ORDINAL)
    private BranchOfLaw branchOfLaw;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "lawyer_id")
    private Price price;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Lawyer() {}

    public Lawyer(String email, String name, String phoneNumber, Degree degree,
                  String workExperience, BranchOfLaw branchOfLaw, Price price, Location location){
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.degree = degree;
        this.branchOfLaw = branchOfLaw;
        this.workExperience = workExperience;
        this.price = price;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBranchOfLaw(BranchOfLaw branchOfLaw) {
        this.branchOfLaw = branchOfLaw;
    }

    public BranchOfLaw getBranchOfLaw() {
        return branchOfLaw;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lawyer)) return false;
        Lawyer lawyer = (Lawyer) o;
        return email.equals(lawyer.email) && name.equals(lawyer.name) && phoneNumber.equals(lawyer.phoneNumber) && degree == lawyer.degree && Objects.equals(workExperience, lawyer.workExperience) && branchOfLaw == lawyer.branchOfLaw && Objects.equals(price, lawyer.price) && Objects.equals(location, lawyer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, phoneNumber, degree, workExperience, branchOfLaw, price, location);
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", degree=" + degree +
                ", workExperience='" + workExperience + '\'' +
                ", branchOfLaw=" + branchOfLaw +
                ", price=" + price +
                ", location=" + location +
                '}';
    }
}
