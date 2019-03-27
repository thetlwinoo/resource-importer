package bieebox.resource.importer.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SystemParameters entity.
 */
public class SystemParametersDTO implements Serializable {

    private Long id;

    @NotNull
    private String deliveryAddressLine1;

    private String deliveryAddressLine2;

    @NotNull
    private String deliveryPostalCode;

    @NotNull
    private String deliveryLocation;

    @NotNull
    private String postalAddressLine1;

    private String postalAddressLine2;

    @NotNull
    private String postalPostalCode;

    @NotNull
    private String applicationSettings;


    private Long deliveryCityId;

    private String deliveryCityCityName;

    private Long postalCityId;

    private String postalCityCityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddressLine1() {
        return deliveryAddressLine1;
    }

    public void setDeliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
    }

    public String getDeliveryAddressLine2() {
        return deliveryAddressLine2;
    }

    public void setDeliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
    }

    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getPostalAddressLine1() {
        return postalAddressLine1;
    }

    public void setPostalAddressLine1(String postalAddressLine1) {
        this.postalAddressLine1 = postalAddressLine1;
    }

    public String getPostalAddressLine2() {
        return postalAddressLine2;
    }

    public void setPostalAddressLine2(String postalAddressLine2) {
        this.postalAddressLine2 = postalAddressLine2;
    }

    public String getPostalPostalCode() {
        return postalPostalCode;
    }

    public void setPostalPostalCode(String postalPostalCode) {
        this.postalPostalCode = postalPostalCode;
    }

    public String getApplicationSettings() {
        return applicationSettings;
    }

    public void setApplicationSettings(String applicationSettings) {
        this.applicationSettings = applicationSettings;
    }

    public Long getDeliveryCityId() {
        return deliveryCityId;
    }

    public void setDeliveryCityId(Long citiesId) {
        this.deliveryCityId = citiesId;
    }

    public String getDeliveryCityCityName() {
        return deliveryCityCityName;
    }

    public void setDeliveryCityCityName(String citiesCityName) {
        this.deliveryCityCityName = citiesCityName;
    }

    public Long getPostalCityId() {
        return postalCityId;
    }

    public void setPostalCityId(Long citiesId) {
        this.postalCityId = citiesId;
    }

    public String getPostalCityCityName() {
        return postalCityCityName;
    }

    public void setPostalCityCityName(String citiesCityName) {
        this.postalCityCityName = citiesCityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SystemParametersDTO systemParametersDTO = (SystemParametersDTO) o;
        if (systemParametersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), systemParametersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SystemParametersDTO{" +
            "id=" + getId() +
            ", deliveryAddressLine1='" + getDeliveryAddressLine1() + "'" +
            ", deliveryAddressLine2='" + getDeliveryAddressLine2() + "'" +
            ", deliveryPostalCode='" + getDeliveryPostalCode() + "'" +
            ", deliveryLocation='" + getDeliveryLocation() + "'" +
            ", postalAddressLine1='" + getPostalAddressLine1() + "'" +
            ", postalAddressLine2='" + getPostalAddressLine2() + "'" +
            ", postalPostalCode='" + getPostalPostalCode() + "'" +
            ", applicationSettings='" + getApplicationSettings() + "'" +
            ", deliveryCity=" + getDeliveryCityId() +
            ", deliveryCity='" + getDeliveryCityCityName() + "'" +
            ", postalCity=" + getPostalCityId() +
            ", postalCity='" + getPostalCityCityName() + "'" +
            "}";
    }
}
