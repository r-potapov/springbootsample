package com.example.controllers;

import com.example.domain.Teammate;
import com.example.dto.TeammateDTO;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeammateDTO teammate(@PathVariable("id") Long id) {
        return new TeammateDTO(teammateRepository.findOne(id));
    }

    @RequestMapping(value="/", method = RequestMethod.POST, produces={"application/json"})
    public ResponseEntity newTeammate(@RequestBody Teammate teammate) {
        try {
            teammateRepository.save(teammate);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeammate(@PathVariable("id") Long id) {

        if(id==null || id<=0){
            new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }

        try {
            teammateRepository.delete(id);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
