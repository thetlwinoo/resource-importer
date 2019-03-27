package bieebox.resource.importer.service.dto;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the SpecialDeals entity.
 */
public class SpecialDealsDTO implements Serializable {

    private Long id;

    @NotNull
    private String dealDescription;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private BigDecimal discountAmount;

    private Float discountPercentage;

    private BigDecimal unitPrice;


    private Long buyingGroupId;

    private String buyingGroupBuyingGroupName;

    private Long customerCategoryId;

    private String customerCategoryCustomerCategoryName;

    private Long customerId;

    private String customerCustomerName;

    private Long stockGroupId;

    private String stockGroupStockGroupName;

    private Long stockItemId;

    private String stockItemStockItemName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(String dealDescription) {
        this.dealDescription = dealDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getBuyingGroupId() {
        return buyingGroupId;
    }

    public void setBuyingGroupId(Long buyingGroupsId) {
        this.buyingGroupId = buyingGroupsId;
    }

    public String getBuyingGroupBuyingGroupName() {
        return buyingGroupBuyingGroupName;
    }

    public void setBuyingGroupBuyingGroupName(String buyingGroupsBuyingGroupName) {
        this.buyingGroupBuyingGroupName = buyingGroupsBuyingGroupName;
    }

    public Long getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(Long customerCategoriesId) {
        this.customerCategoryId = customerCategoriesId;
    }

    public String getCustomerCategoryCustomerCategoryName() {
        return customerCategoryCustomerCategoryName;
    }

    public void setCustomerCategoryCustomerCategoryName(String customerCategoriesCustomerCategoryName) {
        this.customerCategoryCustomerCategoryName = customerCategoriesCustomerCategoryName;
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

    public Long getStockGroupId() {
        return stockGroupId;
    }

    public void setStockGroupId(Long stockGroupsId) {
        this.stockGroupId = stockGroupsId;
    }

    public String getStockGroupStockGroupName() {
        return stockGroupStockGroupName;
    }

    public void setStockGroupStockGroupName(String stockGroupsStockGroupName) {
        this.stockGroupStockGroupName = stockGroupsStockGroupName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SpecialDealsDTO specialDealsDTO = (SpecialDealsDTO) o;
        if (specialDealsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), specialDealsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SpecialDealsDTO{" +
            "id=" + getId() +
            ", dealDescription='" + getDealDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", discountAmount=" + getDiscountAmount() +
            ", discountPercentage=" + getDiscountPercentage() +
            ", unitPrice=" + getUnitPrice() +
            ", buyingGroup=" + getBuyingGroupId() +
            ", buyingGroup='" + getBuyingGroupBuyingGroupName() + "'" +
            ", customerCategory=" + getCustomerCategoryId() +
            ", customerCategory='" + getCustomerCategoryCustomerCategoryName() + "'" +
            ", customer=" + getCustomerId() +
            ", customer='" + getCustomerCustomerName() + "'" +
            ", stockGroup=" + getStockGroupId() +
            ", stockGroup='" + getStockGroupStockGroupName() + "'" +
            ", stockItem=" + getStockItemId() +
            ", stockItem='" + getStockItemStockItemName() + "'" +
            "}";
    }
}
