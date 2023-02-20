package com.avanade.interns.sample;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Items")
public class Item {
    
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private LocalDate dateAdded;

    @Getter @Setter
    @JsonBackReference
    // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    @ManyToOne
    @JoinColumn(name = "sampleId")
    private Sample sample;

    public Item(){}

    public Item(String name, LocalDate dateAdded, Sample sample) {
        this.name = name;
        this.dateAdded = dateAdded;
        this.sample = sample;
    }

    public Item(Long id, String name, LocalDate dateAdded, Sample sample) {
        this.id = id;
        this.name = name;
        this.dateAdded = dateAdded;
        this.sample = sample;
    }
}
