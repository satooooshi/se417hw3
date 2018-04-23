package com.ebookstore.restservice.api;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;

import java.util.List;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class EndWords implements Serializable{

    private static final long serialVersionUID = 1L;
    private String startingWord;
    private String endingWord;

    public String getStaringWord(){
        return this.startingWord;
    }

    public String getEndingWord(){
        return this.startingWord;
    }


    public String toString(){
        return "sw = " + this.startingWord + " ew = " + this.endingWord;
    }

}