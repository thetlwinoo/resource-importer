package bieebox.resource.importer.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ProductPhoto.
 */
@Entity
@Table(name = "product_photo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "thumb_nail_photo")
    private String thumbNailPhoto;

    @Column(name = "thumb_nail_photo_file_name")
    private String thumbNailPhotoFileName;

    @Column(name = "large_photo")
    private String largePhoto;

    @Column(name = "large_photo_file_name")
    private String largePhotoFileName;

    @Column(name = "priority")
    private Integer priority;

    @ManyToOne
    @JsonIgnoreProperties("productPhotos")
    private Products product;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbNailPhoto() {
        return thumbNailPhoto;
    }

    public ProductPhoto thumbNailPhoto(String thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
        return this;
    }

    public void setThumbNailPhoto(String thumbNailPhoto) {
        this.thumbNailPhoto = thumbNailPhoto;
    }

    public String getThumbNailPhotoFileName() {
        return thumbNailPhotoFileName;
    }

    public ProductPhoto thumbNailPhotoFileName(String thumbNailPhotoFileName) {
        this.thumbNailPhotoFileName = thumbNailPhotoFileName;
        return this;
    }

    public void setThumbNailPhotoFileName(String thumbNailPhotoFileName) {
        this.thumbNailPhotoFileName = thumbNailPhotoFileName;
    }

    public String getLargePhoto() {
        return largePhoto;
    }

    public ProductPhoto largePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
        return this;
    }

    public void setLargePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoFileName() {
        return largePhotoFileName;
    }

    public ProductPhoto largePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
        return this;
    }

    public void setLargePhotoFileName(String largePhotoFileName) {
        this.largePhotoFileName = largePhotoFileName;
    }

    public Integer getPriority() {
        return priority;
    }

    public ProductPhoto priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Products getProduct() {
        return product;
    }

    public ProductPhoto product(Products products) {
        this.product = products;
        return this;
    }

    public void setProduct(Products products) {
        this.product = products;
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
        ProductPhoto productPhoto = (ProductPhoto) o;
        if (productPhoto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productPhoto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductPhoto{" +
            "id=" + getId() +
            ", thumbNailPhoto='" + getThumbNailPhoto() + "'" +
            ", thumbNailPhotoFileName='" + getThumbNailPhotoFileName() + "'" +
            ", largePhoto='" + getLargePhoto() + "'" +
            ", largePhotoFileName='" + getLargePhotoFileName() + "'" +
            ", priority=" + getPriority() +
            "}";
    }
}
