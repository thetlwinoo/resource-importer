package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Suppliers entity.
 */
public class SuppliersDTO implements Serializable {

    private Long id;

    @NotNull
    private String supplierName;

    private String supplierReference;

    private String bankAccountName;

    private String bankAccountBranch;

    private String bankAccountCode;

    private String bankAccountNumber;

    private String bankInternationalCode;

    @NotNull
    private Integer paymentDays;

    private String internalComments;

    @NotNull
    private String phoneNumber;

    private String faxNumber;

    private String websiteURL;

    @NotNull
    private String deliveryAddressLine1;

    private String deliveryAddressLine2;

    @NotNull
    private String deliveryPostalCode;

    private String deliveryLocation;

    @NotNull
    private String postalAddressLine1;

    private String postalAddressLine2;

    @NotNull
    private String postalPostalCode;

    @NotNull
    private LocalDate validFrom;

    @NotNull
    private LocalDate validTo;


    private Long primaryContactPersonId;

    private String primaryContactPersonFullName;

    private Long alternateContactPersonId;

    private String alternateContactPersonFullName;

    private Long supplierCategoryId;

    private String supplierCategorySupplierCategoryName;

    private Long deliveryMethodId;

    private String deliveryMethodDeliveryMethodName;

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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountBranch() {
        return bankAccountBranch;
    }

    public void setBankAccountBranch(String bankAccountBranch) {
        this.bankAccountBranch = bankAccountBranch;
    }

    public String getBankAccountCode() {
        return bankAccountCode;
    }

    public void setBankAccountCode(String bankAccountCode) {
        this.bankAccountCode = bankAccountCode;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankInternationalCode() {
        return bankInternationalCode;
    }

    public void setBankInternationalCode(String bankInternationalCode) {
        this.bankInternationalCode = bankInternationalCode;
    }

    public Integer getPaymentDays() {
        return paymentDays;
    }

    public void setPaymentDays(Integer paymentDays) {
        this.paymentDays = paymentDays;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Long getPrimaryContactPersonId() {
        return primaryContactPersonId;
    }

    public void setPrimaryContactPersonId(Long peopleId) {
        this.primaryContactPersonId = peopleId;
    }

    public String getPrimaryContactPersonFullName() {
        return primaryContactPersonFullName;
    }

    public void setPrimaryContactPersonFullName(String peopleFullName) {
        this.primaryContactPersonFullName = peopleFullName;
    }

    public Long getAlternateContactPersonId() {
        return alternateContactPersonId;
    }

    public void setAlternateContactPersonId(Long peopleId) {
        this.alternateContactPersonId = peopleId;
    }

    public String getAlternateContactPersonFullName() {
        return alternateContactPersonFullName;
    }

    public void setAlternateContactPersonFullName(String peopleFullName) {
        this.alternateContactPersonFullName = peopleFullName;
    }

    public Long getSupplierCategoryId() {
        return supplierCategoryId;
    }

    public void setSupplierCategoryId(Long supplierCategoriesId) {
        this.supplierCategoryId = supplierCategoriesId;
    }

    public String getSupplierCategorySupplierCategoryName() {
        return supplierCategorySupplierCategoryName;
    }

    public void setSupplierCategorySupplierCategoryName(String supplierCategoriesSupplierCategoryName) {
        this.supplierCategorySupplierCategoryName = supplierCategoriesSupplierCategoryName;
    }

    public Long getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public void setDeliveryMethodId(Long deliveryMethodsId) {
        this.deliveryMethodId = deliveryMethodsId;
    }

    public String getDeliveryMethodDeliveryMethodName() {
        return deliveryMethodDeliveryMethodName;
    }

    public void setDeliveryMethodDeliveryMethodName(String deliveryMethodsDeliveryMethodName) {
        this.deliveryMethodDeliveryMethodName = deliveryMethodsDeliveryMethodName;
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

        SuppliersDTO suppliersDTO = (SuppliersDTO) o;
        if (suppliersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), suppliersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SuppliersDTO{" +
            "id=" + getId() +
            ", supplierName='" + getSupplierName() + "'" +
            ", supplierReference='" + getSupplierReference() + "'" +
            ", bankAccountName='" + getBankAccountName() + "'" +
            ", bankAccountBranch='" + getBankAccountBranch() + "'" +
            ", bankAccountCode='" + getBankAccountCode() + "'" +
            ", bankAccountNumber='" + getBankAccountNumber() + "'" +
            ", bankInternationalCode='" + getBankInternationalCode() + "'" +
            ", paymentDays=" + getPaymentDays() +
            ", internalComments='" + getInternalComments() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", websiteURL='" + getWebsiteURL() + "'" +
            ", deliveryAddressLine1='" + getDeliveryAddressLine1() + "'" +
            ", deliveryAddressLine2='" + getDeliveryAddressLine2() + "'" +
            ", deliveryPostalCode='" + getDeliveryPostalCode() + "'" +
            ", deliveryLocation='" + getDeliveryLocation() + "'" +
            ", postalAddressLine1='" + getPostalAddressLine1() + "'" +
            ", postalAddressLine2='" + getPostalAddressLine2() + "'" +
            ", postalPostalCode='" + getPostalPostalCode() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            ", primaryContactPerson=" + getPrimaryContactPersonId() +
            ", primaryContactPerson='" + getPrimaryContactPersonFullName() + "'" +
            ", alternateContactPerson=" + getAlternateContactPersonId() +
            ", alternateContactPerson='" + getAlternateContactPersonFullName() + "'" +
            ", supplierCategory=" + getSupplierCategoryId() +
            ", supplierCategory='" + getSupplierCategorySupplierCategoryName() + "'" +
            ", deliveryMethod=" + getDeliveryMethodId() +
            ", deliveryMethod='" + getDeliveryMethodDeliveryMethodName() + "'" +
            ", deliveryCity=" + getDeliveryCityId() +
            ", deliveryCity='" + getDeliveryCityCityName() + "'" +
            ", postalCity=" + getPostalCityId() +
            ", postalCity='" + getPostalCityCityName() + "'" +
            "}";
    }
}
