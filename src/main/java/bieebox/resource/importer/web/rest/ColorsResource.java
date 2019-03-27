package bieebox.resource.importer.web.rest;
import bieebox.resource.importer.service.ColorsService;
import bieebox.resource.importer.web.rest.errors.BadRequestAlertException;
import bieebox.resource.importer.web.rest.util.HeaderUtil;
import bieebox.resource.importer.service.dto.ColorsDTO;
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
 * REST controller for managing Colors.
 */
@RestController
@RequestMapping("/api")
public class ColorsResource {

    private final Logger log = LoggerFactory.getLogger(ColorsResource.class);

    private static final String ENTITY_NAME = "importerColors";

    private final ColorsService colorsService;

    public ColorsResource(ColorsService colorsService) {
        this.colorsService = colorsService;
    }

    /**
     * POST  /colors : Create a new colors.
     *
     * @param colorsDTO the colorsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new colorsDTO, or with status 400 (Bad Request) if the colors has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/colors")
    public ResponseEntity<ColorsDTO> createColors(@Valid @RequestBody ColorsDTO colorsDTO) throws URISyntaxException {
        log.debug("REST request to save Colors : {}", colorsDTO);
        if (colorsDTO.getId() != null) {
            throw new BadRequestAlertException("A new colors cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ColorsDTO result = colorsService.save(colorsDTO);
        return ResponseEntity.created(new URI("/api/colors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /colors : Updates an existing colors.
     *
     * @param colorsDTO the colorsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated colorsDTO,
     * or with status 400 (Bad Request) if the colorsDTO is not valid,
     * or with status 500 (Internal Server Error) if the colorsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/colors")
    public ResponseEntity<ColorsDTO> updateColors(@Valid @RequestBody ColorsDTO colorsDTO) throws URISyntaxException {
        log.debug("REST request to update Colors : {}", colorsDTO);
        if (colorsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ColorsDTO result = colorsService.save(colorsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, colorsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /colors : get all the colors.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of colors in body
     */
    @GetMapping("/colors")
    public List<ColorsDTO> getAllColors() {
        log.debug("REST request to get all Colors");
        return colorsService.findAll();
    }

    /**
     * GET  /colors/:id : get the "id" colors.
     *
     * @param id the id of the colorsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the colorsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/colors/{id}")
    public ResponseEntity<ColorsDTO> getColors(@PathVariable Long id) {
        log.debug("REST request to get Colors : {}", id);
        Optional<ColorsDTO> colorsDTO = colorsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(colorsDTO);
    }

    /**
     * DELETE  /colors/:id : delete the "id" colors.
     *
     * @param id the id of the colorsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/colors/{id}")
    public ResponseEntity<Void> deleteColors(@PathVariable Long id) {
        log.debug("REST request to delete Colors : {}", id);
        colorsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
