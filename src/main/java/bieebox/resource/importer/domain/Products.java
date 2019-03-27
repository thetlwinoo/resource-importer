package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * A Products.
 */
@Entity
@Table(name = "products")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotNull
    @Column(name = "make_flag", nullable = false)
    private Boolean makeFlag;

    @NotNull
    @Column(name = "finished_goods_flag", nullable = false)
    private Boolean finishedGoodsFlag;

    @Column(name = "color")
    private String color;

    @NotNull
    @Column(name = "safety_stock_level", nullable = false)
    private Integer safetyStockLevel;

    @NotNull
    @Column(name = "reorder_point", nullable = false)
    private Integer reorderPoint;

    @NotNull
    @Column(name = "standard_cost", precision = 10, scale = 2, nullable = false)
    private BigDecimal standardCost;

    @NotNull
    @Column(name = "list_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal listPrice;

    @Column(name = "jhi_size")
    private String size;

    @Column(name = "weight", precision = 10, scale = 2)
    private BigDecimal weight;

    @NotNull
    @Column(name = "days_to_manufacture", nullable = false)
    private Integer daysToManufacture;

    @Column(name = "product_line")
    private String productLine;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "style")
    private String style;

    @NotNull
    @Column(name = "sell_start_date", nullable = false)
    private LocalDate sellStartDate;

    @Column(name = "sell_end_date")
    private LocalDate sellEndDate;

    @Column(name = "discontinued_date")
    private LocalDate discontinuedDate;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private ProductSubCategory productSubCategory;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private UnitMeasure sizeUnitMeasureCode;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private UnitMeasure weightUnitMeasureCode;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private ProductModel productModel;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private StockItems stockItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public Products productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean isMakeFlag() {
        return makeFlag;
    }

    public Products makeFlag(Boolean makeFlag) {
        this.makeFlag = makeFlag;
        return this;
    }

    public void setMakeFlag(Boolean makeFlag) {
        this.makeFlag = makeFlag;
    }

    public Boolean isFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    public Products finishedGoodsFlag(Boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
        return this;
    }

    public void setFinishedGoodsFlag(Boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    public String getColor() {
        return color;
    }

    public Products color(String color) {
        this.color = color;
        return this;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public Products safetyStockLevel(Integer safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
        return this;
    }

    public void setSafetyStockLevel(Integer safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public Integer getReorderPoint() {
        return reorderPoint;
    }

    public Products reorderPoint(Integer reorderPoint) {
        this.reorderPoint = reorderPoint;
        return this;
    }

    public void setReorderPoint(Integer reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public Products standardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
        return this;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public Products listPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
        return this;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public Products size(String size) {
        this.size = size;
        return this;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Products weight(BigDecimal weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getDaysToManufacture() {
        return daysToManufacture;
    }

    public Products daysToManufacture(Integer daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
        return this;
    }

    public void setDaysToManufacture(Integer daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public Products productLine(String productLine) {
        this.productLine = productLine;
        return this;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getClassType() {
        return classType;
    }

    public Products classType(String classType) {
        this.classType = classType;
        return this;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getStyle() {
        return style;
    }

    public Products style(String style) {
        this.style = style;
        return this;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public LocalDate getSellStartDate() {
        return sellStartDate;
    }

    public Products sellStartDate(LocalDate sellStartDate) {
        this.sellStartDate = sellStartDate;
        return this;
    }

    public void setSellStartDate(LocalDate sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public LocalDate getSellEndDate() {
        return sellEndDate;
    }

    public Products sellEndDate(LocalDate sellEndDate) {
        this.sellEndDate = sellEndDate;
        return this;
    }

    public void setSellEndDate(LocalDate sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public LocalDate getDiscontinuedDate() {
        return discontinuedDate;
    }

    public Products discontinuedDate(LocalDate discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
        return this;
    }

    public void setDiscontinuedDate(LocalDate discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public ProductSubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public Products productSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
        return this;
    }

    public void setProductSubCategory(ProductSubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public UnitMeasure getSizeUnitMeasureCode() {
        return sizeUnitMeasureCode;
    }

    public Products sizeUnitMeasureCode(UnitMeasure unitMeasure) {
        this.sizeUnitMeasureCode = unitMeasure;
        return this;
    }

    public void setSizeUnitMeasureCode(UnitMeasure unitMeasure) {
        this.sizeUnitMeasureCode = unitMeasure;
    }

    public UnitMeasure getWeightUnitMeasureCode() {
        return weightUnitMeasureCode;
    }

    public Products weightUnitMeasureCode(UnitMeasure unitMeasure) {
        this.weightUnitMeasureCode = unitMeasure;
        return this;
    }

    public void setWeightUnitMeasureCode(UnitMeasure unitMeasure) {
        this.weightUnitMeasureCode = unitMeasure;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public Products productModel(ProductModel productModel) {
        this.productModel = productModel;
        return this;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public Products stockItem(StockItems stockItems) {
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
        Products products = (Products) o;
        if (products.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), products.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Products{" +
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
            "}";
    }
}
