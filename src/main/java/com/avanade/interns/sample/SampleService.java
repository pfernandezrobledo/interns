package com.avanade.interns.sample;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class SampleService {

    private SampleRepository repository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.repository = sampleRepository;
    }

    public List<Sample> GetAllSamples() {

        /*
         * var samples = List.of(
         * new Sample("Pedro_Svc_Aw", LocalDate.parse("1981-10-01"), "pedro@email.com"),
         * new Sample("Haydee_Svc_Aw", LocalDate.parse("1980-07-14"),
         * "haydee@email.com"),
         * new Sample("Gael_Svc_Aw", LocalDate.parse("2012-12-12"), "gael@email.com"));
         */

        var samples = repository.findAll();

        return samples;

    }

    public Sample GetSampleById(Long id) {
        var sample = repository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException(String.format("Sample with ID '%d' does not exist.", id)));

        return sample;
    }

    public Sample GetSampleByName(String name) {

        var sample = repository
                .findByName(name)
                .orElseThrow(
                        () -> new IllegalStateException(String.format("Sample with name '%s' does not exist.", name)));

        return sample;
    }

    public Sample AddNewSample(Sample sample) {

        repository
                .findByName(sample.getName())
                .ifPresent((s) -> {
                    throw new IllegalStateException(
                            String.format("Sample with name '%s' already exists.", s.getName()));
                });

        var created = repository.save(sample);

        return created;
    }

}
