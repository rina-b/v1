package com.example.findyourlaw.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;

    private Float latitude;

    private Float longitude;

    @OneToMany(mappedBy = "location", orphanRemoval = true)
    private List<Lawyer> lawyers;

    @OneToMany(mappedBy = "location", orphanRemoval = true)
    private List<Costumer> costumers;

    public List<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<Costumer> costumers) {
        this.costumers = costumers;
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return id.equals(location.id) && address.equals(location.address) && latitude.equals(location.latitude) && longitude.equals(location.longitude) && Objects.equals(lawyers, location.lawyers) && Objects.equals(costumers, location.costumers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, latitude, longitude, lawyers, costumers);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", lawyers=" + lawyers +
                ", costumers=" + costumers +
                '}';
    }
}
