package bieebox.resource.importer.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ProductModel.
 */
@Entity
@Table(name = "product_model")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "product_model_name", nullable = false)
    private String productModelName;

    @Column(name = "calalog_description")
    private String calalogDescription;

    @Column(name = "instructions")
    private String instructions;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductModelName() {
        return productModelName;
    }

    public ProductModel productModelName(String productModelName) {
        this.productModelName = productModelName;
        return this;
    }

    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
    }

    public String getCalalogDescription() {
        return calalogDescription;
    }

    public ProductModel calalogDescription(String calalogDescription) {
        this.calalogDescription = calalogDescription;
        return this;
    }

    public void setCalalogDescription(String calalogDescription) {
        this.calalogDescription = calalogDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public ProductModel instructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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
        ProductModel productModel = (ProductModel) o;
        if (productModel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productModel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductModel{" +
            "id=" + getId() +
            ", productModelName='" + getProductModelName() + "'" +
            ", calalogDescription='" + getCalalogDescription() + "'" +
            ", instructions='" + getInstructions() + "'" +
            "}";
    }
}
