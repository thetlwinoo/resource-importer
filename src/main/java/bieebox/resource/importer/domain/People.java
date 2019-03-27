package bieebox.resource.importer.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A People.
 */
@Entity
@Table(name = "people")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @NotNull
    @Column(name = "preferred_name", nullable = false)
    private String preferredName;

    @NotNull
    @Column(name = "search_name", nullable = false)
    private String searchName;

    @NotNull
    @Column(name = "is_permitted_to_logon", nullable = false)
    private Boolean isPermittedToLogon;

    @Column(name = "logon_name")
    private String logonName;

    @NotNull
    @Column(name = "is_external_logon_provider", nullable = false)
    private Boolean isExternalLogonProvider;

    @Column(name = "hashed_password")
    private String hashedPassword;

    @NotNull
    @Column(name = "is_system_user", nullable = false)
    private Boolean isSystemUser;

    @NotNull
    @Column(name = "is_employee", nullable = false)
    private Boolean isEmployee;

    @NotNull
    @Column(name = "is_sales_person", nullable = false)
    private Boolean isSalesPerson;

    @Column(name = "user_preferences")
    private String userPreferences;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "photo")
    private String photo;

    @Column(name = "custom_fields")
    private String customFields;

    @Column(name = "other_languages")
    private String otherLanguages;

    @NotNull
    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @NotNull
    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public People fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public People preferredName(String preferredName) {
        this.preferredName = preferredName;
        return this;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getSearchName() {
        return searchName;
    }

    public People searchName(String searchName) {
        this.searchName = searchName;
        return this;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Boolean isIsPermittedToLogon() {
        return isPermittedToLogon;
    }

    public People isPermittedToLogon(Boolean isPermittedToLogon) {
        this.isPermittedToLogon = isPermittedToLogon;
        return this;
    }

    public void setIsPermittedToLogon(Boolean isPermittedToLogon) {
        this.isPermittedToLogon = isPermittedToLogon;
    }

    public String getLogonName() {
        return logonName;
    }

    public People logonName(String logonName) {
        this.logonName = logonName;
        return this;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public Boolean isIsExternalLogonProvider() {
        return isExternalLogonProvider;
    }

    public People isExternalLogonProvider(Boolean isExternalLogonProvider) {
        this.isExternalLogonProvider = isExternalLogonProvider;
        return this;
    }

    public void setIsExternalLogonProvider(Boolean isExternalLogonProvider) {
        this.isExternalLogonProvider = isExternalLogonProvider;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public People hashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Boolean isIsSystemUser() {
        return isSystemUser;
    }

    public People isSystemUser(Boolean isSystemUser) {
        this.isSystemUser = isSystemUser;
        return this;
    }

    public void setIsSystemUser(Boolean isSystemUser) {
        this.isSystemUser = isSystemUser;
    }

    public Boolean isIsEmployee() {
        return isEmployee;
    }

    public People isEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
        return this;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Boolean isIsSalesPerson() {
        return isSalesPerson;
    }

    public People isSalesPerson(Boolean isSalesPerson) {
        this.isSalesPerson = isSalesPerson;
        return this;
    }

    public void setIsSalesPerson(Boolean isSalesPerson) {
        this.isSalesPerson = isSalesPerson;
    }

    public String getUserPreferences() {
        return userPreferences;
    }

    public People userPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
        return this;
    }

    public void setUserPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public People phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public People faxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
        return this;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public People emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoto() {
        return photo;
    }

    public People photo(String photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCustomFields() {
        return customFields;
    }

    public People customFields(String customFields) {
        this.customFields = customFields;
        return this;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public String getOtherLanguages() {
        return otherLanguages;
    }

    public People otherLanguages(String otherLanguages) {
        this.otherLanguages = otherLanguages;
        return this;
    }

    public void setOtherLanguages(String otherLanguages) {
        this.otherLanguages = otherLanguages;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public People validFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public People validTo(LocalDate validTo) {
        this.validTo = validTo;
        return this;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
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
        People people = (People) o;
        if (people.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), people.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "People{" +
            "id=" + getId() +
            ", fullName='" + getFullName() + "'" +
            ", preferredName='" + getPreferredName() + "'" +
            ", searchName='" + getSearchName() + "'" +
            ", isPermittedToLogon='" + isIsPermittedToLogon() + "'" +
            ", logonName='" + getLogonName() + "'" +
            ", isExternalLogonProvider='" + isIsExternalLogonProvider() + "'" +
            ", hashedPassword='" + getHashedPassword() + "'" +
            ", isSystemUser='" + isIsSystemUser() + "'" +
            ", isEmployee='" + isIsEmployee() + "'" +
            ", isSalesPerson='" + isIsSalesPerson() + "'" +
            ", userPreferences='" + getUserPreferences() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", customFields='" + getCustomFields() + "'" +
            ", otherLanguages='" + getOtherLanguages() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            "}";
    }
}
