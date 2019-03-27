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
 * A StockItemHoldings.
 */
@Entity
@Table(name = "stock_item_holdings")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StockItemHoldings implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "quantity_on_hand", nullable = false)
    private Integer quantityOnHand;

    @NotNull
    @Column(name = "bin_location", nullable = false)
    private String binLocation;

    @NotNull
    @Column(name = "last_stocktake_quantity", nullable = false)
    private Integer lastStocktakeQuantity;

    @NotNull
    @Column(name = "last_cost_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal lastCostPrice;

    @NotNull
    @Column(name = "reorder_level", nullable = false)
    private Integer reorderLevel;

    @NotNull
    @Column(name = "targer_stock_level", nullable = false)
    private Integer targerStockLevel;

    @ManyToOne
    @JsonIgnoreProperties("stockItemHoldings")
    private StockItems stockItem;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public StockItemHoldings quantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
        return this;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public String getBinLocation() {
        return binLocation;
    }

    public StockItemHoldings binLocation(String binLocation) {
        this.binLocation = binLocation;
        return this;
    }

    public void setBinLocation(String binLocation) {
        this.binLocation = binLocation;
    }

    public Integer getLastStocktakeQuantity() {
        return lastStocktakeQuantity;
    }

    public StockItemHoldings lastStocktakeQuantity(Integer lastStocktakeQuantity) {
        this.lastStocktakeQuantity = lastStocktakeQuantity;
        return this;
    }

    public void setLastStocktakeQuantity(Integer lastStocktakeQuantity) {
        this.lastStocktakeQuantity = lastStocktakeQuantity;
    }

    public BigDecimal getLastCostPrice() {
        return lastCostPrice;
    }

    public StockItemHoldings lastCostPrice(BigDecimal lastCostPrice) {
        this.lastCostPrice = lastCostPrice;
        return this;
    }

    public void setLastCostPrice(BigDecimal lastCostPrice) {
        this.lastCostPrice = lastCostPrice;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public StockItemHoldings reorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
        return this;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Integer getTargerStockLevel() {
        return targerStockLevel;
    }

    public StockItemHoldings targerStockLevel(Integer targerStockLevel) {
        this.targerStockLevel = targerStockLevel;
        return this;
    }

    public void setTargerStockLevel(Integer targerStockLevel) {
        this.targerStockLevel = targerStockLevel;
    }

    public StockItems getStockItem() {
        return stockItem;
    }

    public StockItemHoldings stockItem(StockItems stockItems) {
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
        StockItemHoldings stockItemHoldings = (StockItemHoldings) o;
        if (stockItemHoldings.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockItemHoldings.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockItemHoldings{" +
            "id=" + getId() +
            ", quantityOnHand=" + getQuantityOnHand() +
            ", binLocation='" + getBinLocation() + "'" +
            ", lastStocktakeQuantity=" + getLastStocktakeQuantity() +
            ", lastCostPrice=" + getLastCostPrice() +
            ", reorderLevel=" + getReorderLevel() +
            ", targerStockLevel=" + getTargerStockLevel() +
            "}";
    }
}
