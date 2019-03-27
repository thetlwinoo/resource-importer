package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A InvoiceLines.
 */
@Entity
@Table(name = "invoice_lines")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InvoiceLines implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @NotNull
    @Column(name = "tax_rate", precision = 10, scale = 2, nullable = false)
    private BigDecimal taxRate;

    @NotNull
    @Column(name = "tax_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal taxAmount;

    @NotNull
    @Column(name = "line_profit", precision = 10, scale = 2, nullable = false)
    private BigDecimal lineProfit;

    @NotNull
    @Column(name = "extended_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal extendedPrice;

    @ManyToOne
    @JsonIgnoreProperties("invoiceLines")
    private PackageTypes packageType;

    @ManyToOne
    @JsonIgnoreProperties("invoiceLines")
    private Invoices invoice;

    @ManyToOne
    @JsonIgnoreProperties("invoiceLines")
    private StockItems stockItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public InvoiceLines description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public InvoiceLines quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public InvoiceLines unitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public InvoiceLines taxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public InvoiceLines taxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getLineProfit() {
        return lineProfit;
    }

    public InvoiceLines lineProfit(BigDecimal lineProfit) {
        this.lineProfit = lineProfit;
        return this;
    }

    public void setLineProfit(BigDecimal lineProfit) {
        this.lineProfit = lineProfit;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public InvoiceLines extendedPrice(BigDecimal extendedPrice) {
        this.extendedPrice = extendedPrice;
        return this;
    }

    public void setExtendedPrice(BigDecimal extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public PackageTypes getPackageType() {
        return packageType;
    }

    public InvoiceLines packageType(PackageTypes packageTypes) {
        this.packageType = packageTypes;
        return this;
    }

    public void setPackageType(PackageTypes packageTypes) {
        this.packageType = packageTypes;
    }

    public Invoices getInvoice() {
        return invoice;
    }

    public InvoiceLines invoice(Invoices invoices) {
        this.invoice = invoices;
        return this;
    }

    public void setInvoice(Invoices invoices) {
        this.invoice = invoices;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public InvoiceLines stockItem(StockItems stockItems) {
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
        InvoiceLines invoiceLines = (InvoiceLines) o;
        if (invoiceLines.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), invoiceLines.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InvoiceLines{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", quantity=" + getQuantity() +
            ", unitPrice=" + getUnitPrice() +
            ", taxRate=" + getTaxRate() +
            ", taxAmount=" + getTaxAmount() +
            ", lineProfit=" + getLineProfit() +
            ", extendedPrice=" + getExtendedPrice() +
            "}";
    }
}
