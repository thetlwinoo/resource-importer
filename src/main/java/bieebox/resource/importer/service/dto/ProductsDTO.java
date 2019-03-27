package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Products entity.
 */
public class ProductsDTO implements Serializable {

    private Long id;

    @NotNull
    private String productName;

    @NotNull
    private Boolean makeFlag;

    @NotNull
    private Boolean finishedGoodsFlag;

    private String color;

    @NotNull
    private Integer safetyStockLevel;

    @NotNull
    private Integer reorderPoint;

    @NotNull
    private BigDecimal standardCost;

    @NotNull
    private BigDecimal listPrice;

    private String size;

    private BigDecimal weight;

    @NotNull
    private Integer daysToManufacture;

    private String productLine;

    private String classType;

    private String style;

    @NotNull
    private LocalDate sellStartDate;

    private LocalDate sellEndDate;

    private LocalDate discontinuedDate;


    private Long productSubCategoryId;

    private Long sizeUnitMeasureCodeId;

    private String sizeUnitMeasureCodeUnitMeasureCode;

    private Long weightUnitMeasureCodeId;

    private String weightUnitMeasureCodeUnitMeasureCode;

    private Long productModelId;

    private String productModelProductModelName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean isMakeFlag() {
        return makeFlag;
    }

    public void setMakeFlag(Boolean makeFlag) {
        this.makeFlag = makeFlag;
    }

    public Boolean isFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    public void setFinishedGoodsFlag(Boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(Integer safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public Integer getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(Integer reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getDaysToManufacture() {
        return daysToManufacture;
    }

    public void setDaysToManufacture(Integer daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public LocalDate getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(LocalDate sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public LocalDate getSellEndDate() {
        return sellEndDate;
    }

    public void setSellEndDate(LocalDate sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public LocalDate getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(LocalDate discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public Long getProductSubCategoryId() {
        return productSubCategoryId;
    }

    public void setProductSubCategoryId(Long productSubCategoryId) {
        this.productSubCategoryId = productSubCategoryId;
    }

    public Long getSizeUnitMeasureCodeId() {
        return sizeUnitMeasureCodeId;
    }

    public void setSizeUnitMeasureCodeId(Long unitMeasureId) {
        this.sizeUnitMeasureCodeId = unitMeasureId;
    }

    public String getSizeUnitMeasureCodeUnitMeasureCode() {
        return sizeUnitMeasureCodeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCodeUnitMeasureCode(String unitMeasureUnitMeasureCode) {
        this.sizeUnitMeasureCodeUnitMeasureCode = unitMeasureUnitMeasureCode;
    }

    public Long getWeightUnitMeasureCodeId() {
        return weightUnitMeasureCodeId;
    }

    public void setWeightUnitMeasureCodeId(Long unitMeasureId) {
        this.weightUnitMeasureCodeId = unitMeasureId;
    }

    public String getWeightUnitMeasureCodeUnitMeasureCode() {
        return weightUnitMeasureCodeUnitMeasureCode;
    }

    public void setWeightUnitMeasureCodeUnitMeasureCode(String unitMeasureUnitMeasureCode) {
        this.weightUnitMeasureCodeUnitMeasureCode = unitMeasureUnitMeasureCode;
    }

    public Long getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(Long productModelId) {
        this.productModelId = productModelId;
    }

    public String getProductModelProductModelName() {
        return productModelProductModelName;
    }

    public void setProductModelProductModelName(String productModelProductModelName) {
        this.productModelProductModelName = productModelProductModelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductsDTO productsDTO = (ProductsDTO) o;
        if (productsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductsDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", makeFlag='" + isMakeFlag() + "'" +
            ", finishedGoodsFlag='" + isFinishedGoodsFlag() + "'" +
            ", color='" + getColor() + "'" +
            ", safetyStockLevel=" + getSafetyStockLevel() +
            ", reorderPoint=" + getReorderPoint() +
            ", standardCost=" + getStandardCost() +
            ", listPrice=" + getListPrice() +
            ", size='" + getSize() + "'" +
            ", weight=" + getWeight() +
            ", daysToManufacture=" + getDaysToManufacture() +
            ", productLine='" + getProductLine() + "'" +
            ", classType='" + getClassType() + "'" +
            ", style='" + getStyle() + "'" +
            ", sellStartDate='" + getSellStartDate() + "'" +
            ", sellEndDate='" + getSellEndDate() + "'" +
            ", discontinuedDate='" + getDiscontinuedDate() + "'" +
            ", productSubCategory=" + getProductSubCategoryId() +
            ", sizeUnitMeasureCode=" + getSizeUnitMeasureCodeId() +
            ", sizeUnitMeasureCode='" + getSizeUnitMeasureCodeUnitMeasureCode() + "'" +
            ", weightUnitMeasureCode=" + getWeightUnitMeasureCodeId() +
            ", weightUnitMeasureCode='" + getWeightUnitMeasureCodeUnitMeasureCode() + "'" +
            ", productModel=" + getProductModelId() +
            ", productModel='" + getProductModelProductModelName() + "'" +
            "}";
    }
}
