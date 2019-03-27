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
 * A SupplierTransactions.
 */
@Entity
@Table(name = "supplier_transactions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SupplierTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "supplier_invoice_number")
    private String supplierInvoiceNumber;

    @NotNull
    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @NotNull
    @Column(name = "amount_excluding_tax", precision = 10, scale = 2, nullable = false)
    private BigDecimal amountExcludingTax;

    @NotNull
    @Column(name = "tax_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal taxAmount;

    @NotNull
    @Column(name = "transaction_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal transactionAmount;

    @NotNull
    @Column(name = "outstanding_balance", precision = 10, scale = 2, nullable = false)
    private BigDecimal outstandingBalance;

    @Column(name = "finalization_date")
    private LocalDate finalizationDate;

    @Column(name = "is_finalized")
    private Boolean isFinalized;

    @ManyToOne
    @JsonIgnoreProperties("supplierTransactions")
    private Suppliers supplier;

    @ManyToOne
    @JsonIgnoreProperties("supplierTransactions")
    private TransactionTypes transactionType;

    @ManyToOne
    @JsonIgnoreProperties("supplierTransactions")
    private PurchaseOrders purchaseOrder;

    @ManyToOne
    @JsonIgnoreProperties("supplierTransactions")
    private PaymentMethods paymentMethod;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierInvoiceNumber() {
        return supplierInvoiceNumber;
    }

    public SupplierTransactions supplierInvoiceNumber(String supplierInvoiceNumber) {
        this.supplierInvoiceNumber = supplierInvoiceNumber;
        return this;
    }

    public void setSupplierInvoiceNumber(String supplierInvoiceNumber) {
        this.supplierInvoiceNumber = supplierInvoiceNumber;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public SupplierTransactions transactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmountExcludingTax() {
        return amountExcludingTax;
    }

    public SupplierTransactions amountExcludingTax(BigDecimal amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
        return this;
    }

    public void setAmountExcludingTax(BigDecimal amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public SupplierTransactions taxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public SupplierTransactions transactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public SupplierTransactions outstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
        return this;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public LocalDate getFinalizationDate() {
        return finalizationDate;
    }

    public SupplierTransactions finalizationDate(LocalDate finalizationDate) {
        this.finalizationDate = finalizationDate;
        return this;
    }

    public void setFinalizationDate(LocalDate finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public Boolean isIsFinalized() {
        return isFinalized;
    }

    public SupplierTransactions isFinalized(Boolean isFinalized) {
        this.isFinalized = isFinalized;
        return this;
    }

    public void setIsFinalized(Boolean isFinalized) {
        this.isFinalized = isFinalized;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public SupplierTransactions supplier(Suppliers suppliers) {
        this.supplier = suppliers;
        return this;
    }

    public void setSupplier(Suppliers suppliers) {
        this.supplier = suppliers;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public SupplierTransactions transactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
        return this;
    }

    public void setTransactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
    }

    public PurchaseOrders getPurchaseOrder() {
        return purchaseOrder;
    }

    public SupplierTransactions purchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
        return this;
    }

    public void setPurchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public SupplierTransactions paymentMethod(PaymentMethods paymentMethods) {
        this.paymentMethod = paymentMethods;
        return this;
    }

    public void setPaymentMethod(PaymentMethods paymentMethods) {
        this.paymentMethod = paymentMethods;
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
        SupplierTransactions supplierTransactions = (SupplierTransactions) o;
        if (supplierTransactions.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), supplierTransactions.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SupplierTransactions{" +
            "id=" + getId() +
            ", supplierInvoiceNumber='" + getSupplierInvoiceNumber() + "'" +
            ", transactionDate='" + getTransactionDate() + "'" +
            ", amountExcludingTax=" + getAmountExcludingTax() +
            ", taxAmount=" + getTaxAmount() +
            ", transactionAmount=" + getTransactionAmount() +
            ", outstandingBalance=" + getOutstandingBalance() +
            ", finalizationDate='" + getFinalizationDate() + "'" +
            ", isFinalized='" + isIsFinalized() + "'" +
            "}";
    }
}
