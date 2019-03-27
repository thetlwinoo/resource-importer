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
 * A PurchaseOrderLines.
 */
@Entity
@Table(name = "purchase_order_lines")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PurchaseOrderLines implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "ordered_outers", nullable = false)
    private Integer orderedOuters;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "received_outers", nullable = false)
    private Integer receivedOuters;

    @Column(name = "expected_unit_price_per_outer", precision = 10, scale = 2)
    private BigDecimal expectedUnitPricePerOuter;

    @Column(name = "last_receipt_date")
    private LocalDate lastReceiptDate;

    @NotNull
    @Column(name = "is_order_line_finalized", nullable = false)
    private Boolean isOrderLineFinalized;

    @ManyToOne
    @JsonIgnoreProperties("purchaseOrderLines")
    private StockItems stockItem;

    @ManyToOne
    @JsonIgnoreProperties("purchaseOrderLines")
    private PackageTypes packageType;

    @ManyToOne
    @JsonIgnoreProperties("purchaseOrderLines")
    private PurchaseOrders purchaseOrder;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderedOuters() {
        return orderedOuters;
    }

    public PurchaseOrderLines orderedOuters(Integer orderedOuters) {
        this.orderedOuters = orderedOuters;
        return this;
    }

    public void setOrderedOuters(Integer orderedOuters) {
        this.orderedOuters = orderedOuters;
    }

    public String getDescription() {
        return description;
    }

    public PurchaseOrderLines description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReceivedOuters() {
        return receivedOuters;
    }

    public PurchaseOrderLines receivedOuters(Integer receivedOuters) {
        this.receivedOuters = receivedOuters;
        return this;
    }

    public void setReceivedOuters(Integer receivedOuters) {
        this.receivedOuters = receivedOuters;
    }

    public BigDecimal getExpectedUnitPricePerOuter() {
        return expectedUnitPricePerOuter;
    }

    public PurchaseOrderLines expectedUnitPricePerOuter(BigDecimal expectedUnitPricePerOuter) {
        this.expectedUnitPricePerOuter = expectedUnitPricePerOuter;
        return this;
    }

    public void setExpectedUnitPricePerOuter(BigDecimal expectedUnitPricePerOuter) {
        this.expectedUnitPricePerOuter = expectedUnitPricePerOuter;
    }

    public LocalDate getLastReceiptDate() {
        return lastReceiptDate;
    }

    public PurchaseOrderLines lastReceiptDate(LocalDate lastReceiptDate) {
        this.lastReceiptDate = lastReceiptDate;
        return this;
    }

    public void setLastReceiptDate(LocalDate lastReceiptDate) {
        this.lastReceiptDate = lastReceiptDate;
    }

    public Boolean isIsOrderLineFinalized() {
        return isOrderLineFinalized;
    }

    public PurchaseOrderLines isOrderLineFinalized(Boolean isOrderLineFinalized) {
        this.isOrderLineFinalized = isOrderLineFinalized;
        return this;
    }

    public void setIsOrderLineFinalized(Boolean isOrderLineFinalized) {
        this.isOrderLineFinalized = isOrderLineFinalized;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public PurchaseOrderLines stockItem(StockItems stockItems) {
        this.stockItem = stockItems;
        return this;
    }

    public void setStockItem(StockItems stockItems) {
        this.stockItem = stockItems;
    }

    public PackageTypes getPackageType() {
        return packageType;
    }

    public PurchaseOrderLines packageType(PackageTypes packageTypes) {
        this.packageType = packageTypes;
        return this;
    }

    public void setPackageType(PackageTypes packageTypes) {
        this.packageType = packageTypes;
    }

    public PurchaseOrders getPurchaseOrder() {
        return purchaseOrder;
    }

    public PurchaseOrderLines purchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
        return this;
    }

    public void setPurchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
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
        PurchaseOrderLines purchaseOrderLines = (PurchaseOrderLines) o;
        if (purchaseOrderLines.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), purchaseOrderLines.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PurchaseOrderLines{" +
            "id=" + getId() +
            ", orderedOuters=" + getOrderedOuters() +
            ", description='" + getDescription() + "'" +
            ", receivedOuters=" + getReceivedOuters() +
            ", expectedUnitPricePerOuter=" + getExpectedUnitPricePerOuter() +
            ", lastReceiptDate='" + getLastReceiptDate() + "'" +
            ", isOrderLineFinalized='" + isIsOrderLineFinalized() + "'" +
            "}";
    }
}
