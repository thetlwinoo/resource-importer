package bieebox.resource.importer.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the StockItemStockGroups entity.
 */
public class StockItemStockGroupsDTO implements Serializable {

    private Long id;


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

        StockItemStockGroupsDTO stockItemStockGroupsDTO = (StockItemStockGroupsDTO) o;
        if (stockItemStockGroupsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), stockItemStockGroupsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StockItemStockGroupsDTO{" +
            "id=" + getId() +
            ", stockGroup=" + getStockGroupId() +
            ", stockGroup='" + getStockGroupStockGroupName() + "'" +
            ", stockItem=" + getStockItemId() +
            ", stockItem='" + getStockItemStockItemName() + "'" +
            "}";
    }
}
