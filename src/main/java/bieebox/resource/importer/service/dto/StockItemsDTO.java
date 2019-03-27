package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the StockItems entity.
 */
public class StockItemsDTO implements Serializable {

    private Long id;

    private String stockItemName;

    private String brand;

    private String size;

    @NotNull
    private Integer leadTimeDays;

    @NotNull
    private Integer quantityPerOuter;

    @NotNull
    private Boolean isChillerStock;

    private String barcode;

    @NotNull
    private BigDecimal taxRate;

    @NotNull
    private BigDecimal unitPrice;

    private BigDecimal recommendedRetailPrice;

    @NotNull
    private BigDecimal typicalWeightPerUnit;

    private String marketingComments;

    private String internalComments;

    private String photo;

    private String customFields;

    private String tags;

    @NotNull
    private String searchDetails;

    @NotNull
    private LocalDate validFrom;

    @NotNull
    private LocalDate validTo;


    private Long productId;

    private Long unitPackageId;

    private String unitPackagePackageTypeName;

    private Long outerPackageId;

    private String outerPackagePackageTypeName;

    private Long supplierId;

    private String supplierSupplierName;

    private Long colorId;

    private String colorColorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockItemName() {
        return stockItemName;
    }

    public void setStockItemName(String stockItemName) {
        this.stockItemName = stockItemName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getLeadTimeDays() {
        return leadTimeDays;
    }

    public void setLeadTimeDays(Integer leadTimeDays) {
        this.leadTimeDays = leadTimeDays;
    }

    public Integer getQuantityPerOuter() {
        return quantityPerOuter;
    }

    public void setQuantityPerOuter(Integer quantityPerOuter) {
        this.quantityPerOuter = quantityPerOuter;
    }

    public Boolean isIsChillerStock() {
        return isChillerStock;
    }

    public void setIsChillerStock(Boolean isChillerStock) {
        this.isChillerStock = isChillerStock;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public void setRecommendedRetailPrice(BigDecimal recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
    }

    public BigDecimal getTypicalWeightPerUnit() {
        return typicalWeightPerUnit;
    }

    public void setTypicalWeightPerUnit(BigDecimal typicalWeightPerUnit) {
        this.typicalWeightPerUnit = typicalWeightPerUnit;
    }

    public String getMarketingComments() {
        return marketingComments;
    }

    public void setMarketingComments(String marketingComments) {
        this.marketingComments = marketingComments;
    }

    public String getInternalComments() {
        return internalComments;
    }

    public void setInternalComments(String internalComments) {
        this.internalComments = internalComments;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCustomFields() {
        return customFields;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSearchDetails() {
        return searchDetails;
    }

    public void setSearchDetails(String searchDetails) {
        this.searchDetails = searchDetails;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productsId) {
        this.productId = productsId;
    }

    public Long getUnitPackageId() {
        return unitPackageId;
    }

    public void setUnitPackageId(Long packageTypesId) {
        this.unitPackageId = packageTypesId;
    }

    public String getUnitPackagePackageTypeName() {
        return unitPackagePackageTypeName;
    }

    public void setUnitPackagePackageTypeName(String packageTypesPackageTypeName) {
        this.unitPackagePackageTypeName = packageTypesPackageTypeName;
    }

    public Long getOuterPackageId() {
        return outerPackageId;
    }

    public void setOuterPackageId(Long packageTypesId) {
        this.outerPackageId = packageTypesId;
    }

    public String getOuterPackagePackageTypeName() {
        return outerPackagePackageTypeName;
    }

    public void setOuterPackagePackageTypeName(String packageTypesPackageTypeName) {
        this.outerPackagePackageTypeName = packageTypesPackageTypeName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long suppliersId) {
        this.supplierId = suppliersId;
    }

    public String getSupplierSupplierName() {
        return supplierSupplierName;
    }

    public void setSupplierSupplierName(String suppliersSupplierName) {
        this.supplierSupplierName = suppliersSupplierName;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorsId) {
        this.colorId = colorsId;
    }

    public String getColorColorName() {
        return colorColorName;
    }

    public void setColorColorName(String colorsColorName) {
        this.colorColorName = colorsColorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StockItemsDTO stockItemsDTO = (StockItemsDTO) o;
        if (stockItemsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockItemsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockItemsDTO{" +
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
            ", product=" + getProductId() +
            ", unitPackage=" + getUnitPackageId() +
            ", unitPackage='" + getUnitPackagePackageTypeName() + "'" +
            ", outerPackage=" + getOuterPackageId() +
            ", outerPackage='" + getOuterPackagePackageTypeName() + "'" +
            ", supplier=" + getSupplierId() +
            ", supplier='" + getSupplierSupplierName() + "'" +
            ", color=" + getColorId() +
            ", color='" + getColorColorName() + "'" +
            "}";
    }
}
