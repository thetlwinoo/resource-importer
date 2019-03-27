package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Customers entity.
 */
public class CustomersDTO implements Serializable {

    private Long id;

    @NotNull
    private String customerName;

    private BigDecimal creditLimit;

    @NotNull
    private LocalDate accountOpenedDate;

    @NotNull
    private BigDecimal standardDiscountPercentage;

    @NotNull
    private Boolean isStatementSent;

    @NotNull
    private Boolean isOnCreditHold;

    @NotNull
    private Integer paymentDays;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String faxNumber;

    private String deliveryRun;

    private String runPosition;

    @NotNull
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

    private Long customerCategoryId;

    private String customerCategoryCustomerCategoryName;

    private Long buyingGroupId;

    private String buyingGroupBuyingGroupName;

    private Long billToCustomerId;

    private String billToCustomerCustomerName;

    private Long deliveryCityId;

    private String deliveryCityCityName;

    private Long postalCityId;

    private String postalCityCityName;

    private Long deliveryMethodId;

    private String deliveryMethodDeliveryMethodName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public LocalDate getAccountOpenedDate() {
        return accountOpenedDate;
    }

    public void setAccountOpenedDate(LocalDate accountOpenedDate) {
        this.accountOpenedDate = accountOpenedDate;
    }

    public BigDecimal getStandardDiscountPercentage() {
        return standardDiscountPercentage;
    }

    public void setStandardDiscountPercentage(BigDecimal standardDiscountPercentage) {
        this.standardDiscountPercentage = standardDiscountPercentage;
    }

    public Boolean isIsStatementSent() {
        return isStatementSent;
    }

    public void setIsStatementSent(Boolean isStatementSent) {
        this.isStatementSent = isStatementSent;
    }

    public Boolean isIsOnCreditHold() {
        return isOnCreditHold;
    }

    public void setIsOnCreditHold(Boolean isOnCreditHold) {
        this.isOnCreditHold = isOnCreditHold;
    }

    public Integer getPaymentDays() {
        return paymentDays;
    }

    public void setPaymentDays(Integer paymentDays) {
        this.paymentDays = paymentDays;
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

    public String getDeliveryRun() {
        return deliveryRun;
    }

    public void setDeliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
    }

    public String getRunPosition() {
        return runPosition;
    }

    public void setRunPosition(String runPosition) {
        this.runPosition = runPosition;
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

    public Long getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(Long customerCategoriesId) {
        this.customerCategoryId = customerCategoriesId;
    }

    public String getCustomerCategoryCustomerCategoryName() {
        return customerCategoryCustomerCategoryName;
    }

    public void setCustomerCategoryCustomerCategoryName(String customerCategoriesCustomerCategoryName) {
        this.customerCategoryCustomerCategoryName = customerCategoriesCustomerCategoryName;
    }

    public Long getBuyingGroupId() {
        return buyingGroupId;
    }

    public void setBuyingGroupId(Long buyingGroupsId) {
        this.buyingGroupId = buyingGroupsId;
    }

    public String getBuyingGroupBuyingGroupName() {
        return buyingGroupBuyingGroupName;
    }

    public void setBuyingGroupBuyingGroupName(String buyingGroupsBuyingGroupName) {
        this.buyingGroupBuyingGroupName = buyingGroupsBuyingGroupName;
    }

    public Long getBillToCustomerId() {
        return billToCustomerId;
    }

    public void setBillToCustomerId(Long customersId) {
        this.billToCustomerId = customersId;
    }

    public String getBillToCustomerCustomerName() {
        return billToCustomerCustomerName;
    }

    public void setBillToCustomerCustomerName(String customersCustomerName) {
        this.billToCustomerCustomerName = customersCustomerName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomersDTO customersDTO = (CustomersDTO) o;
        if (customersDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customersDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CustomersDTO{" +
            "id=" + getId() +
            ", customerName='" + getCustomerName() + "'" +
            ", creditLimit=" + getCreditLimit() +
            ", accountOpenedDate='" + getAccountOpenedDate() + "'" +
            ", standardDiscountPercentage=" + getStandardDiscountPercentage() +
            ", isStatementSent='" + isIsStatementSent() + "'" +
            ", isOnCreditHold='" + isIsOnCreditHold() + "'" +
            ", paymentDays=" + getPaymentDays() +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", deliveryRun='" + getDeliveryRun() + "'" +
            ", runPosition='" + getRunPosition() + "'" +
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
            ", customerCategory=" + getCustomerCategoryId() +
            ", customerCategory='" + getCustomerCategoryCustomerCategoryName() + "'" +
            ", buyingGroup=" + getBuyingGroupId() +
            ", buyingGroup='" + getBuyingGroupBuyingGroupName() + "'" +
            ", billToCustomer=" + getBillToCustomerId() +
            ", billToCustomer='" + getBillToCustomerCustomerName() + "'" +
            ", deliveryCity=" + getDeliveryCityId() +
            ", deliveryCity='" + getDeliveryCityCityName() + "'" +
            ", postalCity=" + getPostalCityId() +
            ", postalCity='" + getPostalCityCityName() + "'" +
            ", deliveryMethod=" + getDeliveryMethodId() +
            ", deliveryMethod='" + getDeliveryMethodDeliveryMethodName() + "'" +
            "}";
    }
}
