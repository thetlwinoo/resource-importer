package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ProductProductPhoto.
 */
@Entity
@Table(name = "product_product_photo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductProductPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "first_priority", nullable = false)
    private Boolean firstPriority;

    @NotNull
    @Column(name = "second_priority", nullable = false)
    private Boolean secondPriority;

    @NotNull
    @Column(name = "third_priority", nullable = false)
    private Boolean thirdPriority;

    @NotNull
    @Column(name = "fourth_priority", nullable = false)
    private Boolean fourthPriority;

    @NotNull
    @Column(name = "fixth_priority", nullable = false)
    private Boolean fixthPriority;

    @NotNull
    @Column(name = "sixth_priority", nullable = false)
    private Boolean sixthPriority;

    @ManyToOne
    @JsonIgnoreProperties("productProductPhotos")
    private ProductPhoto productPhoto;

    @ManyToOne
    @JsonIgnoreProperties("productProductPhotos")
    private Products product;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isFirstPriority() {
        return firstPriority;
    }

    public ProductProductPhoto firstPriority(Boolean firstPriority) {
        this.firstPriority = firstPriority;
        return this;
    }

    public void setFirstPriority(Boolean firstPriority) {
        this.firstPriority = firstPriority;
    }

    public Boolean isSecondPriority() {
        return secondPriority;
    }

    public ProductProductPhoto secondPriority(Boolean secondPriority) {
        this.secondPriority = secondPriority;
        return this;
    }

    public void setSecondPriority(Boolean secondPriority) {
        this.secondPriority = secondPriority;
    }

    public Boolean isThirdPriority() {
        return thirdPriority;
    }

    public ProductProductPhoto thirdPriority(Boolean thirdPriority) {
        this.thirdPriority = thirdPriority;
        return this;
    }

    public void setThirdPriority(Boolean thirdPriority) {
        this.thirdPriority = thirdPriority;
    }

    public Boolean isFourthPriority() {
        return fourthPriority;
    }

    public ProductProductPhoto fourthPriority(Boolean fourthPriority) {
        this.fourthPriority = fourthPriority;
        return this;
    }

    public void setFourthPriority(Boolean fourthPriority) {
        this.fourthPriority = fourthPriority;
    }

    public Boolean isFixthPriority() {
        return fixthPriority;
    }

    public ProductProductPhoto fixthPriority(Boolean fixthPriority) {
        this.fixthPriority = fixthPriority;
        return this;
    }

    public void setFixthPriority(Boolean fixthPriority) {
        this.fixthPriority = fixthPriority;
    }

    public Boolean isSixthPriority() {
        return sixthPriority;
    }

    public ProductProductPhoto sixthPriority(Boolean sixthPriority) {
        this.sixthPriority = sixthPriority;
        return this;
    }

    public void setSixthPriority(Boolean sixthPriority) {
        this.sixthPriority = sixthPriority;
    }

    public ProductPhoto getProductPhoto() {
        return productPhoto;
    }

    public ProductProductPhoto productPhoto(ProductPhoto productPhoto) {
        this.productPhoto = productPhoto;
        return this;
    }

    public void setProductPhoto(ProductPhoto productPhoto) {
        this.productPhoto = productPhoto;
    }

    public Products getProduct() {
        return product;
    }

    public ProductProductPhoto product(Products products) {
        this.product = products;
        return this;
    }

    public void setProduct(Products products) {
        this.product = products;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductProductPhoto productProductPhoto = (ProductProductPhoto) o;
        if (productProductPhoto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productProductPhoto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductProductPhoto{" +
            "id=" + getId() +
            ", firstPriority='" + isFirstPriority() + "'" +
            ", secondPriority='" + isSecondPriority() + "'" +
            ", thirdPriority='" + isThirdPriority() + "'" +
            ", fourthPriority='" + isFourthPriority() + "'" +
            ", fixthPriority='" + isFixthPriority() + "'" +
            ", sixthPriority='" + isSixthPriority() + "'" +
            "}";
    }
}
