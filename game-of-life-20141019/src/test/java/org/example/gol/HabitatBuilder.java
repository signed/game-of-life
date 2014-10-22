package org.example.gol;

import java.util.List;

import com.google.common.collect.Lists;

public class HabitatBuilder {

    public static HabitatBuilder PlanHabitat() {
        return new HabitatBuilder();
    }

    public static HabitatBuilder AnyHabitatWithoutNeighbours(){
        return new HabitatBuilder().dead();
    }

    private Cell cell;
    private List<Cell> neighbours = Lists.newArrayList();

    public HabitatBuilder homeTo(Cell cell){
        this.cell = cell;
        return this;
    }

    public HabitatBuilder alive() {
        cell = Cell.CreateAliveCell();
        return this;
    }

    public HabitatBuilder dead() {
        cell = Cell.CreateDeadCell();
        return this;
    }

    public HabitatBuilder addAliveNeighbour(){
        neighbours.add(Cell.CreateAliveCell());
        return this;
    }

    public HabitatBuilder addDeadNeighbour() {
        neighbours.add(Cell.CreateDeadCell());
        return this;
    }

    public Habitat build() {
        return new Habitat(cell, neighbours);
    }
}
