package com.example.demo.model.enumerated;

import java.util.Arrays;

public enum Workplaces {
    TELETRABAJO("Teletrabajo"),
    OFICINA("Oficina"),
    CLIENTE("Cliente");

    private final String displayValue;


    private Workplaces(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
//    public static Workplaces getWorPlaces(String value){
//        return Arrays.stream(Workplaces.values())
//                .filter(Workplaces -> com.example.demo.model.enumerated.Workplaces.TELETRABAJO.name() ==value)
//                .findFirst().orElse(Workplaces.TELETRABAJO);
//    }
}
