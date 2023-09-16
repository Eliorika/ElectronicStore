package ru.rsreu.Babaian.ElectronicStore.Entities;

import lombok.Data;

@Data
public class Components {
    private int id;
    private String name;
    private Type type;

    public enum Type{
        DISPLAY,
        BATTERY,
        MEMORY
    }
}
