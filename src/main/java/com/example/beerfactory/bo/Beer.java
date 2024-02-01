package com.example.beerfactory.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {
    private Long id;
    private String name;
    private String type;
    private String description;
    private Long alcoholPercenatge;
    private Long evaluation;
    private Factory factory;

}
