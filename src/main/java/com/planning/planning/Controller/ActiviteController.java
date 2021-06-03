package com.planning.planning.Controller;

import com.planning.planning.Model.Activite;
import com.planning.planning.service.Activite.IActiviteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActiviteController {
    IActiviteService activiteService;

    public ActiviteController(IActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    @PostMapping("/activite")
    public ResponseEntity<?> addActivite(@RequestBody Activite activite) {
        return new ResponseEntity<>(activiteService.addActivite(activite), HttpStatus.CREATED);
    }

    @PutMapping("/activite/{id}")
    public ResponseEntity<?> updateActivite(@PathVariable Long id, @RequestBody Activite activite) {
        Activite activiteToUpdate = activiteService.getActivite(id);
        if (activiteToUpdate != null) {
            return new ResponseEntity<> (activiteService.updateActivite(activiteToUpdate, activite), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/activite/{id}")
    public ResponseEntity<?> getActivite(@PathVariable Long id) {
        Activite activite = activiteService.getActivite(id);
        HttpStatus responseStatus = activite != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(activite, responseStatus);
    }

    @GetMapping("/activites")
    public ResponseEntity<?> getActivites() {
        return new ResponseEntity<>(activiteService.getActivities(), HttpStatus.OK);
    }

    @DeleteMapping("/activite/{id}")
    public ResponseEntity<?> deleteActivite(@PathVariable Long id) {
        activiteService.deleteActivite(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
