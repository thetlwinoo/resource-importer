package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the CustomerTransactions entity.
 */
public class CustomerTransactionsDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate transactionDate;

    @NotNull
    private BigDecimal amountExcludingTax;

    @NotNull
    private BigDecimal taxAmount;

    @NotNull
    private BigDecimal transactionAmount;

    @NotNull
    private BigDecimal outstandingBalance;

    private LocalDate finalizationDate;

    private Boolean isFinalized;


    private Long customerId;

    private String customerCustomerName;

    private Long paymentMethodId;

    private String paymentMethodPaymentMethodName;

    private Long transactionTypeId;

    private Long invoiceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmountExcludingTax() {
        return amountExcludingTax;
    }

    public void setAmountExcludingTax(BigDecimal amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public LocalDate getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(LocalDate finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public Boolean isIsFinalized() {
        return isFinalized;
    }

    public void setIsFinalized(Boolean isFinalized) {
        this.isFinalized = isFinalized;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customersId) {
        this.customerId = customersId;
    }

    public String getCustomerCustomerName() {
        return customerCustomerName;
    }

    public void setCustomerCustomerName(String customersCustomerName) {
        this.customerCustomerName = customersCustomerName;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodsId) {
        this.paymentMethodId = paymentMethodsId;
    }

    public String getPaymentMethodPaymentMethodName() {
        return paymentMethodPaymentMethodName;
    }

    public void setPaymentMethodPaymentMethodName(String paymentMethodsPaymentMethodName) {
        this.paymentMethodPaymentMethodName = paymentMethodsPaymentMethodName;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypesId) {
        this.transactionTypeId = transactionTypesId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoicesId) {
        this.invoiceId = invoicesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerTransactionsDTO customerTransactionsDTO = (CustomerTransactionsDTO) o;
        if (customerTransactionsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customerTransactionsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CustomerTransactionsDTO{" +
            "id=" + getId() +
            ", transactionDate='" + getTransactionDate() + "'" +
            ", amountExcludingTax=" + getAmountExcludingTax() +
            ", taxAmount=" + getTaxAmount() +
            ", transactionAmount=" + getTransactionAmount() +
            ", outstandingBalance=" + getOutstandingBalance() +
            ", finalizationDate='" + getFinalizationDate() + "'" +
            ", isFinalized='" + isIsFinalized() + "'" +
            ", customer=" + getCustomerId() +
            ", customer='" + getCustomerCustomerName() + "'" +
            ", paymentMethod=" + getPaymentMethodId() +
            ", paymentMethod='" + getPaymentMethodPaymentMethodName() + "'" +
            ", transactionType=" + getTransactionTypeId() +
            ", invoice=" + getInvoiceId() +
            "}";
    }
}
