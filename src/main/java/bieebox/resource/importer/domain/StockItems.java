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
 * A StockItems.
 */
@Entity
@Table(name = "stock_items")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockItems implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "stock_item_name")
    private String stockItemName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "jhi_size")
    private String size;

    @NotNull
    @Column(name = "lead_time_days", nullable = false)
    private Integer leadTimeDays;

    @NotNull
    @Column(name = "quantity_per_outer", nullable = false)
    private Integer quantityPerOuter;

    @NotNull
    @Column(name = "is_chiller_stock", nullable = false)
    private Boolean isChillerStock;

    @Column(name = "barcode")
    private String barcode;

    @NotNull
    @Column(name = "tax_rate", precision = 10, scale = 2, nullable = false)
    private BigDecimal taxRate;

    @NotNull
    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "recommended_retail_price", precision = 10, scale = 2)
    private BigDecimal recommendedRetailPrice;

    @NotNull
    @Column(name = "typical_weight_per_unit", precision = 10, scale = 2, nullable = false)
    private BigDecimal typicalWeightPerUnit;

    @Column(name = "marketing_comments")
    private String marketingComments;

    @Column(name = "internal_comments")
    private String internalComments;

    @Column(name = "photo")
    private String photo;

    @Column(name = "custom_fields")
    private String customFields;

    @Column(name = "tags")
    private String tags;

    @NotNull
    @Column(name = "search_details", nullable = false)
    private String searchDetails;

    @NotNull
    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @NotNull
    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    @OneToOne
    @JoinColumn(unique = true)
    private Products product;

    @ManyToOne
    @JsonIgnoreProperties("stockItems")
    private PackageTypes unitPackage;

    @ManyToOne
    @JsonIgnoreProperties("stockItems")
    private PackageTypes outerPackage;

    @ManyToOne
    @JsonIgnoreProperties("stockItems")
    private Suppliers supplier;

    @ManyToOne
    @JsonIgnoreProperties("stockItems")
    private Colors color;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public StockItems stockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
        return this;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public String getBrand() {
        return brand;
    }

    public StockItems brand(String brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public StockItems size(String size) {
        this.size = size;
        return this;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getLeadTimeDays() {
        return leadTimeDays;
    }

    public StockItems leadTimeDays(Integer leadTimeDays) {
        this.leadTimeDays = leadTimeDays;
        return this;
    }

    public void setLeadTimeDays(Integer leadTimeDays) {
        this.leadTimeDays = leadTimeDays;
    }

    public Integer getQuantityPerOuter() {
        return quantityPerOuter;
    }

    public StockItems quantityPerOuter(Integer quantityPerOuter) {
        this.quantityPerOuter = quantityPerOuter;
        return this;
    }

    public void setQuantityPerOuter(Integer quantityPerOuter) {
        this.quantityPerOuter = quantityPerOuter;
    }

    public Boolean isIsChillerStock() {
        return isChillerStock;
    }

    public StockItems isChillerStock(Boolean isChillerStock) {
        this.isChillerStock = isChillerStock;
        return this;
    }

    public void setIsChillerStock(Boolean isChillerStock) {
        this.isChillerStock = isChillerStock;
    }

    public String getBarcode() {
        return barcode;
    }

    public StockItems barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public StockItems taxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public StockItems unitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public StockItems recommendedRetailPrice(BigDecimal recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
        return this;
    }

    public void setRecommendedRetailPrice(BigDecimal recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public BigDecimal getTypicalWeightPerUnit() {
        return typicalWeightPerUnit;
    }

    public StockItems typicalWeightPerUnit(BigDecimal typicalWeightPerUnit) {
        this.typicalWeightPerUnit = typicalWeightPerUnit;
        return this;
    }

    public void setTypicalWeightPerUnit(BigDecimal typicalWeightPerUnit) {
        this.typicalWeightPerUnit = typicalWeightPerUnit;
    }

    public String getMarketingComments() {
        return marketingComments;
    }

    public StockItems marketingComments(String marketingComments) {
        this.marketingComments = marketingComments;
        return this;
    }

    public void setMarketingComments(String marketingComments) {
        this.marketingComments = marketingComments;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public StockItems internalComments(String internalComments) {
        this.internalComments = internalComments;
        return this;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getPhoto() {
        return photo;
    }

    public StockItems photo(String photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCustomFields() {
        return customFields;
    }

    public StockItems customFields(String customFields) {
        this.customFields = customFields;
        return this;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public String getTags() {
        return tags;
    }

    public StockItems tags(String tags) {
        this.tags = tags;
        return this;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSearchDetails() {
        return searchDetails;
    }

    public StockItems searchDetails(String searchDetails) {
        this.searchDetails = searchDetails;
        return this;
    }

    public void setSearchDetails(String searchDetails) {
        this.searchDetails = searchDetails;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public StockItems validFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public StockItems validTo(LocalDate validTo) {
        this.validTo = validTo;
        return this;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Products getProduct() {
        return product;
    }

    public StockItems product(Products products) {
        this.product = products;
        return this;
    }

    public void setProduct(Products products) {
        this.product = products;
    }

    public PackageTypes getUnitPackage() {
        return unitPackage;
    }

    public StockItems unitPackage(PackageTypes packageTypes) {
        this.unitPackage = packageTypes;
        return this;
    }

    public void setUnitPackage(PackageTypes packageTypes) {
        this.unitPackage = packageTypes;
    }

    public PackageTypes getOuterPackage() {
        return outerPackage;
    }

    public StockItems outerPackage(PackageTypes packageTypes) {
        this.outerPackage = packageTypes;
        return this;
    }

    public void setOuterPackage(PackageTypes packageTypes) {
        this.outerPackage = packageTypes;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public StockItems supplier(Suppliers suppliers) {
        this.supplier = suppliers;
        return this;
    }

    public void setSupplier(Suppliers suppliers) {
        this.supplier = suppliers;
    }

    public Colors getColor() {
        return color;
    }

    public StockItems color(Colors colors) {
        this.color = colors;
        return this;
    }

    public void setColor(Colors colors) {
        this.color = colors;
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
        StockItems stockItems = (StockItems) o;
        if (stockItems.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockItems.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockItems{" +
            "id=" + getId() +
            ", stockItemName='" + getStockItemName() + "'" +
            ", brand='" + getBrand() + "'" +
            ", size='" + getSize() + "'" +
            ", leadTimeDays=" + getLeadTimeDays() +
            ", quantityPerOuter=" + getQuantityPerOuter() +
            ", isChillerStock='" + isIsChillerStock() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", taxRate=" + getTaxRate() +
            ", unitPrice=" + getUnitPrice() +
            ", recommendedRetailPrice=" + getRecommendedRetailPrice() +
            ", typicalWeightPerUnit=" + getTypicalWeightPerUnit() +
            ", marketingComments='" + getMarketingComments() + "'" +
            ", internalComments='" + getInternalComments() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", customFields='" + getCustomFields() + "'" +
            ", tags='" + getTags() + "'" +
            ", searchDetails='" + getSearchDetails() + "'" +
            ", validFrom='" + getValidFrom() + "'" +
            ", validTo='" + getValidTo() + "'" +
            "}";
    }
}
