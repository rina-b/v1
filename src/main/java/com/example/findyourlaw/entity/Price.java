package com.example.findyourlaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "price")
    private Lawyer lawyer;

    @Column(nullable = false)
    private Float consultationPrice;

    private Float documentRevuePrice;

    private Float representationInCourtPrice;

    private Float allInPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAllInPrice() {
        return allInPrice;
    }

    public void setAllInPrice(Float allInPrice) {
        this.allInPrice = allInPrice;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Float getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(Float consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public Float getDocumentRevuePrice() {
        return documentRevuePrice;
    }

    public void setDocumentRevuePrice(Float documentRevuePrice) {
        this.documentRevuePrice = documentRevuePrice;
    }

    public Float getRepresentationInCourtPrice() {
        return representationInCourtPrice;
    }

    public void setRepresentationInCourtPrice(Float representationInCourtPrice) {
        this.representationInCourtPrice = representationInCourtPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return id.equals(price.id) && lawyer.equals(price.lawyer) && Objects.equals(consultationPrice, price.consultationPrice) && Objects.equals(documentRevuePrice, price.documentRevuePrice) && Objects.equals(representationInCourtPrice, price.representationInCourtPrice) && Objects.equals(allInPrice, price.allInPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lawyer, consultationPrice, documentRevuePrice, representationInCourtPrice, allInPrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", lawyer=" + lawyer +
                ", consultationPrice=" + consultationPrice +
                ", documentRevuePrice=" + documentRevuePrice +
                ", representationInCourtPrice=" + representationInCourtPrice +
                ", allInPrice=" + allInPrice +
                '}';
    }
}
