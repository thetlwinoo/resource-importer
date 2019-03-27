package bieebox.resource.importer.web.rest;
import bieebox.resource.importer.service.ProductProductPhotoService;
import bieebox.resource.importer.web.rest.errors.BadRequestAlertException;
import bieebox.resource.importer.web.rest.util.HeaderUtil;
import bieebox.resource.importer.service.dto.ProductProductPhotoDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ProductProductPhoto.
 */
@RestController
@RequestMapping("/api")
public class ProductProductPhotoResource {

    private final Logger log = LoggerFactory.getLogger(ProductProductPhotoResource.class);

    private static final String ENTITY_NAME = "importerProductProductPhoto";

    private final ProductProductPhotoService productProductPhotoService;

    public ProductProductPhotoResource(ProductProductPhotoService productProductPhotoService) {
        this.productProductPhotoService = productProductPhotoService;
    }

    /**
     * POST  /product-product-photos : Create a new productProductPhoto.
     *
     * @param productProductPhotoDTO the productProductPhotoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productProductPhotoDTO, or with status 400 (Bad Request) if the productProductPhoto has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-product-photos")
    public ResponseEntity<ProductProductPhotoDTO> createProductProductPhoto(@Valid @RequestBody ProductProductPhotoDTO productProductPhotoDTO) throws URISyntaxException {
        log.debug("REST request to save ProductProductPhoto : {}", productProductPhotoDTO);
        if (productProductPhotoDTO.getId() != null) {
            throw new BadRequestAlertException("A new productProductPhoto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductProductPhotoDTO result = productProductPhotoService.save(productProductPhotoDTO);
        return ResponseEntity.created(new URI("/api/product-product-photos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /product-product-photos : Updates an existing productProductPhoto.
     *
     * @param productProductPhotoDTO the productProductPhotoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productProductPhotoDTO,
     * or with status 400 (Bad Request) if the productProductPhotoDTO is not valid,
     * or with status 500 (Internal Server Error) if the productProductPhotoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-product-photos")
    public ResponseEntity<ProductProductPhotoDTO> updateProductProductPhoto(@Valid @RequestBody ProductProductPhotoDTO productProductPhotoDTO) throws URISyntaxException {
        log.debug("REST request to update ProductProductPhoto : {}", productProductPhotoDTO);
        if (productProductPhotoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProductProductPhotoDTO result = productProductPhotoService.save(productProductPhotoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, productProductPhotoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /product-product-photos : get all the productProductPhotos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productProductPhotos in body
     */
    @GetMapping("/product-product-photos")
    public List<ProductProductPhotoDTO> getAllProductProductPhotos() {
        log.debug("REST request to get all ProductProductPhotos");
        return productProductPhotoService.findAll();
    }

    /**
     * GET  /product-product-photos/:id : get the "id" productProductPhoto.
     *
     * @param id the id of the productProductPhotoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productProductPhotoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/product-product-photos/{id}")
    public ResponseEntity<ProductProductPhotoDTO> getProductProductPhoto(@PathVariable Long id) {
        log.debug("REST request to get ProductProductPhoto : {}", id);
        Optional<ProductProductPhotoDTO> productProductPhotoDTO = productProductPhotoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productProductPhotoDTO);
    }

    /**
     * DELETE  /product-product-photos/:id : delete the "id" productProductPhoto.
     *
     * @param id the id of the productProductPhotoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-product-photos/{id}")
    public ResponseEntity<Void> deleteProductProductPhoto(@PathVariable Long id) {
        log.debug("REST request to delete ProductProductPhoto : {}", id);
        productProductPhotoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
