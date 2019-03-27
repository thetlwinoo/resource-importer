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
 * A StockItemTransactions.
 */
@Entity
@Table(name = "stock_item_transactions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockItemTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "transaction_occurred_when", nullable = false)
    private LocalDate transactionOccurredWhen;

    @NotNull
    @Column(name = "quantity", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantity;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private Customers customer;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private Invoices invoice;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private PurchaseOrders purchaseOrder;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private StockItems stockItem;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private Suppliers supplier;

    @ManyToOne
    @JsonIgnoreProperties("stockItemTransactions")
    private TransactionTypes transactionType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransactionOccurredWhen() {
        return transactionOccurredWhen;
    }

    public StockItemTransactions transactionOccurredWhen(LocalDate transactionOccurredWhen) {
        this.transactionOccurredWhen = transactionOccurredWhen;
        return this;
    }

    public void setTransactionOccurredWhen(LocalDate transactionOccurredWhen) {
        this.transactionOccurredWhen = transactionOccurredWhen;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public StockItemTransactions quantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Customers getCustomer() {
        return customer;
    }

    public StockItemTransactions customer(Customers customers) {
        this.customer = customers;
        return this;
    }

    public void setCustomer(Customers customers) {
        this.customer = customers;
    }

    public Invoices getInvoice() {
        return invoice;
    }

    public StockItemTransactions invoice(Invoices invoices) {
        this.invoice = invoices;
        return this;
    }

    public void setInvoice(Invoices invoices) {
        this.invoice = invoices;
    }

    public PurchaseOrders getPurchaseOrder() {
        return purchaseOrder;
    }

    public StockItemTransactions purchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
        return this;
    }

    public void setPurchaseOrder(PurchaseOrders purchaseOrders) {
        this.purchaseOrder = purchaseOrders;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public StockItemTransactions stockItem(StockItems stockItems) {
        this.stockItem = stockItems;
        return this;
    }

    public void setStockItem(StockItems stockItems) {
        this.stockItem = stockItems;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public StockItemTransactions supplier(Suppliers suppliers) {
        this.supplier = suppliers;
        return this;
    }

    public void setSupplier(Suppliers suppliers) {
        this.supplier = suppliers;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public StockItemTransactions transactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
        return this;
    }

    public void setTransactionType(TransactionTypes transactionTypes) {
        this.transactionType = transactionTypes;
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
        StockItemTransactions stockItemTransactions = (StockItemTransactions) o;
        if (stockItemTransactions.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockItemTransactions.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockItemTransactions{" +
            "id=" + getId() +
            ", transactionOccurredWhen='" + getTransactionOccurredWhen() + "'" +
            ", quantity=" + getQuantity() +
            "}";
    }
}
