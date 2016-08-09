package com.example.controllers;

import com.example.domain.Teammate;
import com.example.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teammate/")
public class TeammateController {
    @Autowired
    TeammateRepository teammateRepository;

    @RequestMapping("/")
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
}
