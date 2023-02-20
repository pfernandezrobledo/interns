package com.avanade.interns.sample;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "api/v1/sample")
public class SampleController {

    private SampleService service;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.service = sampleService;
    }

    @GetMapping("/string")
    public ResponseEntity<List<String>> GetAllStrings() {

        return new ResponseEntity<List<String>>(
                List.of("Uno", "Dos", "Tres"),
                HttpStatusCode.valueOf(200));
    }

    @GetMapping("/entities")
    public ResponseEntity<List<Sample>> GetAllSamples() throws IllegalAccessException {

        /*
         * return ResponseEntity.ok(List.of(
         * new SampleEntity("Pedro", LocalDate.parse("1981-10-01"), "pedro@email.com"),
         * new SampleEntity("Haydee", LocalDate.parse("1980-07-14"),
         * "haydee@email.com"),
         * new SampleEntity("Gael", LocalDate.parse("2012-12-12"), "gael@email.com")));
         */

        // SampleService service = new SampleService();

        var samples = service.GetAllSamples();

        return ResponseEntity.ok(samples);
    }

    @GetMapping(path = "/entity/{id}")
    public ResponseEntity<Sample> GetSampleByIdName(@PathVariable("id") Long id) {

        var sample = service.GetSampleById(id);

        return ResponseEntity.ok(sample);

    }

    @GetMapping(path = "/entity")
    public ResponseEntity<Sample> GetSampleByName(@RequestParam(required = false) String name) {

        var sample = service.GetSampleByName(name);

        return ResponseEntity.ok(sample);

    }

    @PostMapping(path = "/entity")
    public ResponseEntity<Sample> AddNewSample(@RequestBody Sample sample) {

        var created = service.AddNewSample(sample);

        // return ResponseEntity.created(URI.create(String.format("",
        // created.getId()))).build();

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(created.getId())
                                .toUri())
                .build();
    }
}
