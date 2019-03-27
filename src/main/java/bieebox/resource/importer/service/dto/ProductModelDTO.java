package bieebox.resource.importer.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductModel entity.
 */
public class ProductModelDTO implements Serializable {

    private Long id;

    @NotNull
    private String productModelName;

    private String calalogDescription;

    private String instructions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductModelName() {
        return productModelName;
    }

    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
    }

    public String getCalalogDescription() {
        return calalogDescription;
    }

    public void setCalalogDescription(String calalogDescription) {
        this.calalogDescription = calalogDescription;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductModelDTO productModelDTO = (ProductModelDTO) o;
        if (productModelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productModelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductModelDTO{" +
            "id=" + getId() +
            ", productModelName='" + getProductModelName() + "'" +
            ", calalogDescription='" + getCalalogDescription() + "'" +
            ", instructions='" + getInstructions() + "'" +
            "}";
    }
}
