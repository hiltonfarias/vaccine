package com.hiltonfarias.app.vaccine.controller;

import com.hiltonfarias.app.vaccine.domain.Application;
import com.hiltonfarias.app.vaccine.requests.requestApplication.ApplicationRequestsBody;
import com.hiltonfarias.app.vaccine.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("application")
@RequiredArgsConstructor
public class ApplicationController {

    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<Application>> list() {
        return new ResponseEntity<>(applicationService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Application> find(@PathVariable Long id) {
        return new ResponseEntity<>(applicationService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Application> save(@RequestBody ApplicationRequestsBody applicationRequestsBody) {
        return new ResponseEntity<>(applicationService.save(applicationRequestsBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        applicationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ApplicationRequestsBody applicationRequestsBody){
        applicationService.replace(applicationRequestsBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
