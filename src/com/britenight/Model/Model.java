package com.britenight.Model;

import java.io.*;
import java.util.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class Model {
    private PriorityQueue<Toy> toys;

    public Model() {
        toys = new PriorityQueue<>();
    }

    public void put(int id, int weight, String name) {
        Toy toy = new Toy(id, weight, name);
        toys.add(toy);
    }

    public int get() {
        if (toys.isEmpty()) {
            return -1; // Вернуть -1, если игрушек нет
        }

        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        int randomWeight = random.nextInt(totalWeight) + 1;

        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomWeight <= currentWeight) {
                return toy.getId();
            }
        }

        return -1; // Вернуть -1, если игрушек нет
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Toy toy : toys) {
                writer.write(toy.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}