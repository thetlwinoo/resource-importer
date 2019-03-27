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
 * A CustomerTransactions.
 */
@Entity
@Table(name = "customer_transactions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CustomerTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

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
    @JsonIgnoreProperties("customerTransactions")
    private Customers customer;

    @ManyToOne
    @JsonIgnoreProperties("customerTransactions")
    private PaymentMethods paymentMethod;

    @ManyToOne
    @JsonIgnoreProperties("customerTransactions")
    private TransactionTypes transactionType;

    @ManyToOne
    @JsonIgnoreProperties("customerTransactions")
    private Invoices invoice;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public CustomerTransactions transactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmountExcludingTax() {
        return amountExcludingTax;
    }

    public CustomerTransactions amountExcludingTax(BigDecimal amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
        return this;
    }

    public void setAmountExcludingTax(BigDecimal amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public CustomerTransactions taxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public CustomerTransactions transactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public CustomerTransactions outstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
        return this;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public LocalDate getFinalizationDate() {
        return finalizationDate;
    }

    public CustomerTransactions finalizationDate(LocalDate finalizationDate) {
        this.finalizationDate = finalizationDate;
        return this;
    }

    public void setFinalizationDate(LocalDate finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public Boolean isIsFinalized() {
        return isFinalized;
    }

    public CustomerTransactions isFinalized(Boolean isFinalized) {
        this.isFinalized = isFinalized;
        return this;
    }

    public void setIsFinalized(Boolean isFinalized) {
        this.isFinalized = isFinalized;
    }

    public Customers getCustomer() {
        return customer;
    }

    public CustomerTransactions customer(Customers customers) {
        this.customer = customers;
        return this;
    }

    public void setCustomer(Customers customers) {
        this.customer = customers;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public CustomerTransactions paymentMethod(PaymentMethods paymentMethods) {
        this.paymentMethod = paymentMethods;
        return this;
    }

    public void setPaymentMethod(PaymentMethods paymentMethods) {
        this.paymentMethod = paymentMethods;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public CustomerTransactions transactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
        return this;
    }

    public void setTransactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
    }

    public Invoices getInvoice() {
        return invoice;
    }

    public CustomerTransactions invoice(Invoices invoices) {
        this.invoice = invoices;
        return this;
    }

    public void setInvoice(Invoices invoices) {
        this.invoice = invoices;
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
        CustomerTransactions customerTransactions = (CustomerTransactions) o;
        if (customerTransactions.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customerTransactions.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CustomerTransactions{" +
            "id=" + getId() +
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
