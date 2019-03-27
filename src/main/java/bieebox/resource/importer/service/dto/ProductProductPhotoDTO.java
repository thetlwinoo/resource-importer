package bieebox.resource.importer.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductProductPhoto entity.
 */
public class ProductProductPhotoDTO implements Serializable {

    private Long id;

    @NotNull
    private Boolean firstPriority;

    @NotNull
    private Boolean secondPriority;

    @NotNull
    private Boolean thirdPriority;

    @NotNull
    private Boolean fourthPriority;

    @NotNull
    private Boolean fixthPriority;

    @NotNull
    private Boolean sixthPriority;


    private Long productPhotoId;

    private Long productId;

    private String productProductName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isFirstPriority() {
        return firstPriority;
    }

    public void setFirstPriority(Boolean firstPriority) {
        this.firstPriority = firstPriority;
    }

    public Boolean isSecondPriority() {
        return secondPriority;
    }

    public void setSecondPriority(Boolean secondPriority) {
        this.secondPriority = secondPriority;
    }

    public Boolean isThirdPriority() {
        return thirdPriority;
    }

    public void setThirdPriority(Boolean thirdPriority) {
        this.thirdPriority = thirdPriority;
    }

    public Boolean isFourthPriority() {
        return fourthPriority;
    }

    public void setFourthPriority(Boolean fourthPriority) {
        this.fourthPriority = fourthPriority;
    }

    public Boolean isFixthPriority() {
        return fixthPriority;
    }

    public void setFixthPriority(Boolean fixthPriority) {
        this.fixthPriority = fixthPriority;
    }

    public Boolean isSixthPriority() {
        return sixthPriority;
    }

    public void setSixthPriority(Boolean sixthPriority) {
        this.sixthPriority = sixthPriority;
    }

    public Long getProductPhotoId() {
        return productPhotoId;
    }

    public void setProductPhotoId(Long productPhotoId) {
        this.productPhotoId = productPhotoId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productsId) {
        this.productId = productsId;
    }

    public String getProductProductName() {
        return productProductName;
    }

    public void setProductProductName(String productsProductName) {
        this.productProductName = productsProductName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductProductPhotoDTO productProductPhotoDTO = (ProductProductPhotoDTO) o;
        if (productProductPhotoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productProductPhotoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductProductPhotoDTO{" +
            "id=" + getId() +
            ", firstPriority='" + isFirstPriority() + "'" +
            ", secondPriority='" + isSecondPriority() + "'" +
            ", thirdPriority='" + isThirdPriority() + "'" +
            ", fourthPriority='" + isFourthPriority() + "'" +
            ", fixthPriority='" + isFixthPriority() + "'" +
            ", sixthPriority='" + isSixthPriority() + "'" +
            ", productPhoto=" + getProductPhotoId() +
            ", product=" + getProductId() +
            ", product='" + getProductProductName() + "'" +
            "}";
    }
}
