package com.example.findyourlaw.entity;

import com.example.findyourlaw.entity.enumerated.BranchOfLaw;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "case_descriptions")
public class CaseDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private BranchOfLaw branchOfLaw;

    private String description;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    public CaseDescription(){}

    public CaseDescription(Long id, BranchOfLaw branchOfLaw, String description, Costumer costumer){
        this.id = id;
        this.branchOfLaw = branchOfLaw;
        this.description = description;
        this.costumer = costumer;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public void setBranchOfLaw(BranchOfLaw branchOfLaw) {
        this.branchOfLaw = branchOfLaw;
    }

    public BranchOfLaw getBranchOfLaw() {
        return branchOfLaw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaseDescription)) return false;
        CaseDescription that = (CaseDescription) o;
        return id.equals(that.id) && branchOfLaw == that.branchOfLaw && Objects.equals(description, that.description) && costumer.equals(that.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchOfLaw, description, costumer);
    }

    @Override
    public String toString() {
        return "CaseDescription{" +
                "id=" + id +
                ", branchOfLaw=" + branchOfLaw +
                ", description='" + description + '\'' +
                ", costumer=" + costumer +
                '}';
    }
}
