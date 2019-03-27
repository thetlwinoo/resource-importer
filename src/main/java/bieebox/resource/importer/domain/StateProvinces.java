package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A StateProvinces.
 */
@Entity
@Table(name = "state_provinces")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StateProvinces implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "state_province_code", nullable = false)
    private String stateProvinceCode;

    @NotNull
    @Column(name = "state_province_name", nullable = false)
    private String stateProvinceName;

    @NotNull
    @Column(name = "sales_territory", nullable = false)
    private String salesTerritory;

    @Column(name = "border")
    private String border;

    @Column(name = "latest_recorded_population")
    private Long latestRecordedPopulation;

    @NotNull
    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @NotNull
    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    @ManyToOne
    @JsonIgnoreProperties("stateProvinces")
    private Countries country;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateProvinceCode() {
        return stateProvinceCode;
    }

    public StateProvinces stateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
        return this;
    }

    public void setStateProvinceCode(String stateProvinceCode) {
        this.stateProvinceCode = stateProvinceCode;
    }

    public String getStateProvinceName() {
        return stateProvinceName;
    }

    public StateProvinces stateProvinceName(String stateProvinceName) {
        this.stateProvinceName = stateProvinceName;
        return this;
    }

    public void setStateProvinceName(String stateProvinceName) {
        this.stateProvinceName = stateProvinceName;
    }

    public String getSalesTerritory() {
        return salesTerritory;
    }

    public StateProvinces salesTerritory(String salesTerritory) {
        this.salesTerritory = salesTerritory;
        return this;
    }

    public void setSalesTerritory(String salesTerritory) {
        this.salesTerritory = salesTerritory;
    }

    public String getBorder() {
        return border;
    }

    public StateProvinces border(String border) {
        this.border = border;
        return this;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public Long getLatestRecordedPopulation() {
        return latestRecordedPopulation;
    }

    public StateProvinces latestRecordedPopulation(Long latestRecordedPopulation) {
        this.latestRecordedPopulation = latestRecordedPopulation;
        return this;
    }

    public void setLatestRecordedPopulation(Long latestRecordedPopulation) {
        this.latestRecordedPopulation = latestRecordedPopulation;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public StateProvinces validFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public StateProvinces validTo(LocalDate validTo) {
        this.validTo = validTo;
        return this;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Countries getCountry() {
        return country;
    }

    public StateProvinces country(Countries countries) {
        this.country = countries;
        return this;
    }

    public void setCountry(Countries countries) {
        this.country = countries;
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
        StateProvinces stateProvinces = (StateProvinces) o;
        if (stateProvinces.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stateProvinces.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StateProvinces{" +
            "id=" + getId() +
            ", stateProvinceCode='" + getStateProvinceCode() + "'" +
            ", stateProvinceName='" + getStateProvinceName() + "'" +
            ", salesTerritory='" + getSalesTerritory() + "'" +
            ", border='" + getBorder() + "'" +
            ", latestRecordedPopulation=" + getLatestRecordedPopulation() +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            "}";
    }
}
