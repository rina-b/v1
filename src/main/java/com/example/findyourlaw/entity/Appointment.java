package com.example.findyourlaw.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)


    private Long id;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "case_description_id")
    private CaseDescription caseDescription;

    @Column(name = "time", unique = true)
    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public CaseDescription getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(CaseDescription caseDescription) {
        this.caseDescription = caseDescription;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return id.equals(that.id) && lawyer.equals(that.lawyer) && caseDescription.equals(that.caseDescription) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lawyer, caseDescription, time);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", lawyer=" + lawyer +
                ", caseDescription=" + caseDescription +
                ", time=" + time +
                '}';
    }
}
