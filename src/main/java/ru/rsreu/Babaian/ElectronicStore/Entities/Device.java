package ru.rsreu.Babaian.ElectronicStore.Entities;

import lombok.Data;

import java.util.List;

@Data
public class Device {
    private int id;
    private String name;
    private List<Components> componentsList;
}
