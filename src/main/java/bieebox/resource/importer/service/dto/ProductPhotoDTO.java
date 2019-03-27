package bieebox.resource.importer.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductPhoto entity.
 */
public class ProductPhotoDTO implements Serializable {

    private Long id;

    private String thumbNailPhoto;

    private String thumbNailPhotoFileName;

    private String largePhoto;

    private String largePhotoFileName;

    private Integer priority;


    private Long productId;

    private String productProductName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    public void setThumbNailPhoto(String thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
    }

    public String getThumbNailPhotoFileName() {
        return thumbNailPhotoFileName;
    }

    public void setThumbNailPhotoFileName(String thumbNailPhotoFileName) {
        this.thumbNailPhotoFileName = thumbNailPhotoFileName;
    }

    public String getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoFileName() {
        return largePhotoFileName;
    }

    public void setLargePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

        ProductPhotoDTO productPhotoDTO = (ProductPhotoDTO) o;
        if (productPhotoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productPhotoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductPhotoDTO{" +
            "id=" + getId() +
            ", thumbNailPhoto='" + getThumbNailPhoto() + "'" +
            ", thumbNailPhotoFileName='" + getThumbNailPhotoFileName() + "'" +
            ", largePhoto='" + getLargePhoto() + "'" +
            ", largePhotoFileName='" + getLargePhotoFileName() + "'" +
            ", priority=" + getPriority() +
            ", product=" + getProductId() +
            ", product='" + getProductProductName() + "'" +
            "}";
    }
}
