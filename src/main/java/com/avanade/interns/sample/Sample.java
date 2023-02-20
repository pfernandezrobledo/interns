package com.avanade.interns.sample;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Samples")
public class Sample {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private LocalDate dob;

    @Getter @Setter
    private String email;


    /*  
    ! ERROR: its a good idea to change this mappedBy to Samples or items to see the error that occurs
    ! ERROR: Could not write JSON: JDBC exception executing SQL [select i1_0.sample_id,i1_0.id,i1_0.date_added,i1_0.name from items i1_0 where i1_0.sample_id=?]]
    !        By default the strategy of JPA is to separate camel/pascal case with underscores @_@
    */
    @Getter @Setter  
    @JsonManagedReference 
    // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    @OneToMany(mappedBy = "sample", cascade = CascadeType.PERSIST)
    private List<Item> items;

    public Sample() {
    }

    public Sample(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
    
    public Sample(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    

    public int GetAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

}
