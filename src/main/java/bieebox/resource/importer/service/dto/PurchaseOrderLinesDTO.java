package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the PurchaseOrderLines entity.
 */
public class PurchaseOrderLinesDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer orderedOuters;

    @NotNull
    private String description;

    @NotNull
    private Integer receivedOuters;

    private BigDecimal expectedUnitPricePerOuter;

    private LocalDate lastReceiptDate;

    @NotNull
    private Boolean isOrderLineFinalized;


    private Long stockItemId;

    private String stockItemStockItemName;

    private Long packageTypeId;

    private String packageTypePackageTypeName;

    private Long purchaseOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderedOuters() {
        return orderedOuters;
    }

    public void setOrderedOuters(Integer orderedOuters) {
        this.orderedOuters = orderedOuters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReceivedOuters() {
        return receivedOuters;
    }

    public void setReceivedOuters(Integer receivedOuters) {
        this.receivedOuters = receivedOuters;
    }

    public BigDecimal getExpectedUnitPricePerOuter() {
        return expectedUnitPricePerOuter;
    }

    public void setExpectedUnitPricePerOuter(BigDecimal expectedUnitPricePerOuter) {
        this.expectedUnitPricePerOuter = expectedUnitPricePerOuter;
    }

    public LocalDate getLastReceiptDate() {
        return lastReceiptDate;
    }

    public void setLastReceiptDate(LocalDate lastReceiptDate) {
        this.lastReceiptDate = lastReceiptDate;
    }

    public Boolean isIsOrderLineFinalized() {
        return isOrderLineFinalized;
    }

    public void setIsOrderLineFinalized(Boolean isOrderLineFinalized) {
        this.isOrderLineFinalized = isOrderLineFinalized;
    }

    public Long getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Long stockItemsId) {
        this.stockItemId = stockItemsId;
    }

    public String getStockItemStockItemName() {
        return stockItemStockItemName;
    }

    public void setStockItemStockItemName(String stockItemsStockItemName) {
        this.stockItemStockItemName = stockItemsStockItemName;
    }

    public Long getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Long packageTypesId) {
        this.packageTypeId = packageTypesId;
    }

    public String getPackageTypePackageTypeName() {
        return packageTypePackageTypeName;
    }

    public void setPackageTypePackageTypeName(String packageTypesPackageTypeName) {
        this.packageTypePackageTypeName = packageTypesPackageTypeName;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrdersId) {
        this.purchaseOrderId = purchaseOrdersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PurchaseOrderLinesDTO purchaseOrderLinesDTO = (PurchaseOrderLinesDTO) o;
        if (purchaseOrderLinesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), purchaseOrderLinesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PurchaseOrderLinesDTO{" +
            "id=" + getId() +
            ", orderedOuters=" + getOrderedOuters() +
            ", description='" + getDescription() + "'" +
            ", receivedOuters=" + getReceivedOuters() +
            ", expectedUnitPricePerOuter=" + getExpectedUnitPricePerOuter() +
            ", lastReceiptDate='" + getLastReceiptDate() + "'" +
            ", isOrderLineFinalized='" + isIsOrderLineFinalized() + "'" +
            ", stockItem=" + getStockItemId() +
            ", stockItem='" + getStockItemStockItemName() + "'" +
            ", packageType=" + getPackageTypeId() +
            ", packageType='" + getPackageTypePackageTypeName() + "'" +
            ", purchaseOrder=" + getPurchaseOrderId() +
            "}";
    }
}
