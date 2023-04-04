package com.example.demo.model;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class BaseModel<T> {
    public ArrayList<String> getCabeceras(T clase){
        ArrayList<String> cabeceras= new ArrayList<String>();
        Field[] campos = clase.getClass().getDeclaredFields();
        for (Field campo: campos) {
            cabeceras.add( campo.getName());
        }
        return cabeceras;
    }
}
