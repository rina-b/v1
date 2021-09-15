package com.example.findyourlaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    private int stars;

    private String comment;

    public String getComment() {
        return comment;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        Mark mark = (Mark) o;
        return stars == mark.stars && id.equals(mark.id) && Objects.equals(costumer, mark.costumer) && Objects.equals(lawyer, mark.lawyer) && Objects.equals(comment, mark.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, costumer, lawyer, stars, comment);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", costumer=" + costumer +
                ", lawyer=" + lawyer +
                ", stars=" + stars +
                ", comment='" + comment + '\'' +
                '}';
    }
}
