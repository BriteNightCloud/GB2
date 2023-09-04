package com.britenight.Model;

import java.util.Objects;

public class Toy implements Comparable<Toy> {
    private int id;
    private int weight;
    private String name;

    public Toy(int id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return id + "," + weight + "," + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id == toy.id &&
                weight == toy.weight &&
                Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, name);
    }
}