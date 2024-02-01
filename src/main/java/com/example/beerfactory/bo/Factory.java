package com.example.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factory {
    private Long id;
    private String nom;
    private String address;
    private Long latitude;
    private Long longitude;
    private LocalDate openDate;

}
