package com.example.controllers;

import com.example.domain.Teammate;
import com.example.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teammate/")
public class TeammateController {
    @Autowired
    TeammateRepository teammateRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    Iterable<Teammate> teammates() {
        return teammateRepository.findAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Teammate teammateOld(@RequestParam(value="id") Long id) {
        return teammateRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Teammate teammate(@PathVariable("id") Long id) {
        return teammateRepository.findOne(id);
    }

    @RequestMapping(value="/", method = RequestMethod.POST, produces={"application/json"})
    public ResponseEntity newTeammate(@RequestBody Teammate teammate) {
        try {

        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
