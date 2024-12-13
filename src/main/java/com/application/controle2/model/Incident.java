package com.application.controle2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    private String reference;
    private Date time;
    private String status;
    private Membre membre;

}
