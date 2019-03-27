package bieebox.resource.importer.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the InvoiceLines entity.
 */
public class InvoiceLinesDTO implements Serializable {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Integer quantity;

    private BigDecimal unitPrice;

    @NotNull
    private BigDecimal taxRate;

    @NotNull
    private BigDecimal taxAmount;

    @NotNull
    private BigDecimal lineProfit;

    @NotNull
    private BigDecimal extendedPrice;


    private Long packageTypeId;

    private String packageTypePackageTypeName;

    private Long invoiceId;

    private Long stockItemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getLineProfit() {
        return lineProfit;
    }

    public void setLineProfit(BigDecimal lineProfit) {
        this.lineProfit = lineProfit;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(BigDecimal extendedPrice) {
        this.extendedPrice = extendedPrice;
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

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoicesId) {
        this.invoiceId = invoicesId;
    }

    public Long getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Long stockItemsId) {
        this.stockItemId = stockItemsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InvoiceLinesDTO invoiceLinesDTO = (InvoiceLinesDTO) o;
        if (invoiceLinesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoiceLinesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvoiceLinesDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", quantity=" + getQuantity() +
            ", unitPrice=" + getUnitPrice() +
            ", taxRate=" + getTaxRate() +
            ", taxAmount=" + getTaxAmount() +
            ", lineProfit=" + getLineProfit() +
            ", extendedPrice=" + getExtendedPrice() +
            ", packageType=" + getPackageTypeId() +
            ", packageType='" + getPackageTypePackageTypeName() + "'" +
            ", invoice=" + getInvoiceId() +
            ", stockItem=" + getStockItemId() +
            "}";
    }
}
