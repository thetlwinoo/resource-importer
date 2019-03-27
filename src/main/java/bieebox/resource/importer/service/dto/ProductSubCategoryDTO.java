package bieebox.resource.importer.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductSubCategory entity.
 */
public class ProductSubCategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String productSubCategoryName;


    private Long productCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSubCategoryName() {
        return productSubCategoryName;
    }

    public void setProductSubCategoryName(String productSubCategoryName) {
        this.productSubCategoryName = productSubCategoryName;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductSubCategoryDTO productSubCategoryDTO = (ProductSubCategoryDTO) o;
        if (productSubCategoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productSubCategoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductSubCategoryDTO{" +
            "id=" + getId() +
            ", productSubCategoryName='" + getProductSubCategoryName() + "'" +
            ", productCategory=" + getProductCategoryId() +
            "}";
    }
}
