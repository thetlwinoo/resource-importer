package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Customers.
 */
@Entity
@Table(name = "customers")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "credit_limit", precision = 10, scale = 2)
    private BigDecimal creditLimit;

    @NotNull
    @Column(name = "account_opened_date", nullable = false)
    private LocalDate accountOpenedDate;

    @NotNull
    @Column(name = "standard_discount_percentage", precision = 10, scale = 2, nullable = false)
    private BigDecimal standardDiscountPercentage;

    @NotNull
    @Column(name = "is_statement_sent", nullable = false)
    private Boolean isStatementSent;

    @NotNull
    @Column(name = "is_on_credit_hold", nullable = false)
    private Boolean isOnCreditHold;

    @NotNull
    @Column(name = "payment_days", nullable = false)
    private Integer paymentDays;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "fax_number", nullable = false)
    private String faxNumber;

    @Column(name = "delivery_run")
    private String deliveryRun;

    @Column(name = "run_position")
    private String runPosition;

    @NotNull
    @Column(name = "website_url", nullable = false)
    private String websiteURL;

    @NotNull
    @Column(name = "delivery_address_line_1", nullable = false)
    private String deliveryAddressLine1;

    @Column(name = "delivery_address_line_2")
    private String deliveryAddressLine2;

    @NotNull
    @Column(name = "delivery_postal_code", nullable = false)
    private String deliveryPostalCode;

    @Column(name = "delivery_location")
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
    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @NotNull
    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private People primaryContactPerson;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private People alternateContactPerson;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private CustomerCategories customerCategory;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private BuyingGroups buyingGroup;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private Customers billToCustomer;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private Cities deliveryCity;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private Cities postalCity;

    @ManyToOne
    @JsonIgnoreProperties("customers")
    private DeliveryMethods deliveryMethod;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customers customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public Customers creditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
        return this;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public LocalDate getAccountOpenedDate() {
        return accountOpenedDate;
    }

    public Customers accountOpenedDate(LocalDate accountOpenedDate) {
        this.accountOpenedDate = accountOpenedDate;
        return this;
    }

    public void setAccountOpenedDate(LocalDate accountOpenedDate) {
        this.accountOpenedDate = accountOpenedDate;
    }

    public BigDecimal getStandardDiscountPercentage() {
        return standardDiscountPercentage;
    }

    public Customers standardDiscountPercentage(BigDecimal standardDiscountPercentage) {
        this.standardDiscountPercentage = standardDiscountPercentage;
        return this;
    }

    public void setStandardDiscountPercentage(BigDecimal standardDiscountPercentage) {
        this.standardDiscountPercentage = standardDiscountPercentage;
    }

    public Boolean isIsStatementSent() {
        return isStatementSent;
    }

    public Customers isStatementSent(Boolean isStatementSent) {
        this.isStatementSent = isStatementSent;
        return this;
    }

    public void setIsStatementSent(Boolean isStatementSent) {
        this.isStatementSent = isStatementSent;
    }

    public Boolean isIsOnCreditHold() {
        return isOnCreditHold;
    }

    public Customers isOnCreditHold(Boolean isOnCreditHold) {
        this.isOnCreditHold = isOnCreditHold;
        return this;
    }

    public void setIsOnCreditHold(Boolean isOnCreditHold) {
        this.isOnCreditHold = isOnCreditHold;
    }

    public Integer getPaymentDays() {
        return paymentDays;
    }

    public Customers paymentDays(Integer paymentDays) {
        this.paymentDays = paymentDays;
        return this;
    }

    public void setPaymentDays(Integer paymentDays) {
        this.paymentDays = paymentDays;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Customers phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public Customers faxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getDeliveryRun() {
        return deliveryRun;
    }

    public Customers deliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
        return this;
    }

    public void setDeliveryRun(String deliveryRun) {
        this.deliveryRun = deliveryRun;
    }

    public String getRunPosition() {
        return runPosition;
    }

    public Customers runPosition(String runPosition) {
        this.runPosition = runPosition;
        return this;
    }

    public void setRunPosition(String runPosition) {
        this.runPosition = runPosition;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public Customers websiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
        return this;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getDeliveryAddressLine1() {
        return deliveryAddressLine1;
    }

    public Customers deliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
        return this;
    }

    public void setDeliveryAddressLine1(String deliveryAddressLine1) {
        this.deliveryAddressLine1 = deliveryAddressLine1;
    }

    public String getDeliveryAddressLine2() {
        return deliveryAddressLine2;
    }

    public Customers deliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
        return this;
    }

    public void setDeliveryAddressLine2(String deliveryAddressLine2) {
        this.deliveryAddressLine2 = deliveryAddressLine2;
    }

    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }

    public Customers deliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
        return this;
    }

    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public Customers deliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
        return this;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getPostalAddressLine1() {
        return postalAddressLine1;
    }

    public Customers postalAddressLine1(String postalAddressLine1) {
        this.postalAddressLine1 = postalAddressLine1;
        return this;
    }

    public void setPostalAddressLine1(String postalAddressLine1) {
        this.postalAddressLine1 = postalAddressLine1;
    }

    public String getPostalAddressLine2() {
        return postalAddressLine2;
    }

    public Customers postalAddressLine2(String postalAddressLine2) {
        this.postalAddressLine2 = postalAddressLine2;
        return this;
    }

    public void setPostalAddressLine2(String postalAddressLine2) {
        this.postalAddressLine2 = postalAddressLine2;
    }

    public String getPostalPostalCode() {
        return postalPostalCode;
    }

    public Customers postalPostalCode(String postalPostalCode) {
        this.postalPostalCode = postalPostalCode;
        return this;
    }

    public void setPostalPostalCode(String postalPostalCode) {
        this.postalPostalCode = postalPostalCode;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public Customers validFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public Customers validTo(LocalDate validTo) {
        this.validTo = validTo;
        return this;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public People getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public Customers primaryContactPerson(People people) {
        this.primaryContactPerson = people;
        return this;
    }

    public void setPrimaryContactPerson(People people) {
        this.primaryContactPerson = people;
    }

    public People getAlternateContactPerson() {
        return alternateContactPerson;
    }

    public Customers alternateContactPerson(People people) {
        this.alternateContactPerson = people;
        return this;
    }

    public void setAlternateContactPerson(People people) {
        this.alternateContactPerson = people;
    }

    public CustomerCategories getCustomerCategory() {
        return customerCategory;
    }

    public Customers customerCategory(CustomerCategories customerCategories) {
        this.customerCategory = customerCategories;
        return this;
    }

    public void setCustomerCategory(CustomerCategories customerCategories) {
        this.customerCategory = customerCategories;
    }

    public BuyingGroups getBuyingGroup() {
        return buyingGroup;
    }

    public Customers buyingGroup(BuyingGroups buyingGroups) {
        this.buyingGroup = buyingGroups;
        return this;
    }

    public void setBuyingGroup(BuyingGroups buyingGroups) {
        this.buyingGroup = buyingGroups;
    }

    public Customers getBillToCustomer() {
        return billToCustomer;
    }

    public Customers billToCustomer(Customers customers) {
        this.billToCustomer = customers;
        return this;
    }

    public void setBillToCustomer(Customers customers) {
        this.billToCustomer = customers;
    }

    public Cities getDeliveryCity() {
        return deliveryCity;
    }

    public Customers deliveryCity(Cities cities) {
        this.deliveryCity = cities;
        return this;
    }

    public void setDeliveryCity(Cities cities) {
        this.deliveryCity = cities;
    }

    public Cities getPostalCity() {
        return postalCity;
    }

    public Customers postalCity(Cities cities) {
        this.postalCity = cities;
        return this;
    }

    public void setPostalCity(Cities cities) {
        this.postalCity = cities;
    }

    public DeliveryMethods getDeliveryMethod() {
        return deliveryMethod;
    }

    public Customers deliveryMethod(DeliveryMethods deliveryMethods) {
        this.deliveryMethod = deliveryMethods;
        return this;
    }

    public void setDeliveryMethod(DeliveryMethods deliveryMethods) {
        this.deliveryMethod = deliveryMethods;
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
        Customers customers = (Customers) o;
        if (customers.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customers.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Customers{" +
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
            "}";
    }
}
