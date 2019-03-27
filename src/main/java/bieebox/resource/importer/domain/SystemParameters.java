package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A SystemParameters.
 */
@Entity
@Table(name = "system_parameters")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SystemParameters implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "delivery_address_line_1", nullable = false)
    private String deliveryAddressLine1;

    @Column(name = "delivery_address_line_2")
    private String deliveryAddressLine2;

    @NotNull
    @Column(name = "delivery_postal_code", nullable = false)
    private String deliveryPostalCode;

    @NotNull
    @Column(name = "delivery_location", nullable = false)
    private String deliveryLocation;

    @NotNull
    @Column(name = "postal_address_line_1", nullable = false)
    private String postalAddressLine1;

    @Column(name = "postal_address_line_2")
    private String postalAddressLine2;

    @NotNull
    @Column(name = "postal_postal_code", nullable = false)
    private String postalPostalCode;

    @NotNull
    @Column(name = "application_settings", nullable = false)
    private String applicationSettings;

    @ManyToOne
    @JsonIgnoreProperties("systemParameters")
    private Cities deliveryCity;

    @ManyToOne
    @JsonIgnoreProperties("systemParameters")
    private Cities postalCity;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddressLine1() {
        return deliveryAddressLine1;
    }

    public SystemParameters deliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
        return this;
    }

    public void setDeliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
    }

    public String getDeliveryAddressLine2() {
        return deliveryAddressLine2;
    }

    public SystemParameters deliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
        return this;
    }

    public void setDeliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
    }

    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    public SystemParameters deliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
        return this;
    }

    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public SystemParameters deliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
        return this;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getPostalAddressLine1() {
        return postalAddressLine1;
    }

    public SystemParameters postalAddressLine1(String postalAddressLine1) {
        this.postalAddressLine1 = postalAddressLine1;
        return this;
    }

    public void setPostalAddressLine1(String postalAddressLine1) {
        this.postalAddressLine1 = postalAddressLine1;
    }

    public String getPostalAddressLine2() {
        return postalAddressLine2;
    }

    public SystemParameters postalAddressLine2(String postalAddressLine2) {
        this.postalAddressLine2 = postalAddressLine2;
        return this;
    }

    public void setPostalAddressLine2(String postalAddressLine2) {
        this.postalAddressLine2 = postalAddressLine2;
    }

    public String getPostalPostalCode() {
        return postalPostalCode;
    }

    public SystemParameters postalPostalCode(String postalPostalCode) {
        this.postalPostalCode = postalPostalCode;
        return this;
    }

    public void setPostalPostalCode(String postalPostalCode) {
        this.postalPostalCode = postalPostalCode;
    }

    public String getApplicationSettings() {
        return applicationSettings;
    }

    public SystemParameters applicationSettings(String applicationSettings) {
        this.applicationSettings = applicationSettings;
        return this;
    }

    public void setApplicationSettings(String applicationSettings) {
        this.applicationSettings = applicationSettings;
    }

    public Cities getDeliveryCity() {
        return deliveryCity;
    }

    public SystemParameters deliveryCity(Cities cities) {
        this.deliveryCity = cities;
        return this;
    }

    public void setDeliveryCity(Cities cities) {
        this.deliveryCity = cities;
    }

    public Cities getPostalCity() {
        return postalCity;
    }

    public SystemParameters postalCity(Cities cities) {
        this.postalCity = cities;
        return this;
    }

    public void setPostalCity(Cities cities) {
        this.postalCity = cities;
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
        SystemParameters systemParameters = (SystemParameters) o;
        if (systemParameters.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), systemParameters.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SystemParameters{" +
            "id=" + getId() +
            ", deliveryAddressLine1='" + getDeliveryAddressLine1() + "'" +
            ", deliveryAddressLine2='" + getDeliveryAddressLine2() + "'" +
            ", deliveryPostalCode='" + getDeliveryPostalCode() + "'" +
            ", deliveryLocation='" + getDeliveryLocation() + "'" +
            ", postalAddressLine1='" + getPostalAddressLine1() + "'" +
            ", postalAddressLine2='" + getPostalAddressLine2() + "'" +
            ", postalPostalCode='" + getPostalPostalCode() + "'" +
            ", applicationSettings='" + getApplicationSettings() + "'" +
            "}";
    }
}
