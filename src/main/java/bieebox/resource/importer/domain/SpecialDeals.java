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
 * A SpecialDeals.
 */
@Entity
@Table(name = "special_deals")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SpecialDeals implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "deal_description", nullable = false)
    private String dealDescription;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "discount_amount", precision = 10, scale = 2)
    private BigDecimal discountAmount;

    @Column(name = "discount_percentage")
    private Float discountPercentage;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @ManyToOne
    @JsonIgnoreProperties("specialDeals")
    private BuyingGroups buyingGroup;

    @ManyToOne
    @JsonIgnoreProperties("specialDeals")
    private CustomerCategories customerCategory;

    @ManyToOne
    @JsonIgnoreProperties("specialDeals")
    private Customers customer;

    @ManyToOne
    @JsonIgnoreProperties("specialDeals")
    private StockGroups stockGroup;

    @ManyToOne
    @JsonIgnoreProperties("specialDeals")
    private StockItems stockItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public SpecialDeals dealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
        return this;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public SpecialDeals startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SpecialDeals endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public SpecialDeals discountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public SpecialDeals discountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
        return this;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public SpecialDeals unitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BuyingGroups getBuyingGroup() {
        return buyingGroup;
    }

    public SpecialDeals buyingGroup(BuyingGroups buyingGroups) {
        this.buyingGroup = buyingGroups;
        return this;
    }

    public void setBuyingGroup(BuyingGroups buyingGroups) {
        this.buyingGroup = buyingGroups;
    }

    public CustomerCategories getCustomerCategory() {
        return customerCategory;
    }

    public SpecialDeals customerCategory(CustomerCategories customerCategories) {
        this.customerCategory = customerCategories;
        return this;
    }

    public void setCustomerCategory(CustomerCategories customerCategories) {
        this.customerCategory = customerCategories;
    }

    public Customers getCustomer() {
        return customer;
    }

    public SpecialDeals customer(Customers customers) {
        this.customer = customers;
        return this;
    }

    public void setCustomer(Customers customers) {
        this.customer = customers;
    }

    public StockGroups getStockGroup() {
        return stockGroup;
    }

    public SpecialDeals stockGroup(StockGroups stockGroups) {
        this.stockGroup = stockGroups;
        return this;
    }

    public void setStockGroup(StockGroups stockGroups) {
        this.stockGroup = stockGroups;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public SpecialDeals stockItem(StockItems stockItems) {
        this.stockItem = stockItems;
        return this;
    }

    public void setStockItem(StockItems stockItems) {
        this.stockItem = stockItems;
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
        SpecialDeals specialDeals = (SpecialDeals) o;
        if (specialDeals.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), specialDeals.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SpecialDeals{" +
            "id=" + getId() +
            ", dealDescription='" + getDealDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", discountAmount=" + getDiscountAmount() +
            ", discountPercentage=" + getDiscountPercentage() +
            ", unitPrice=" + getUnitPrice() +
            "}";
    }
}
