package org.example.gol;

import static org.example.gol.CellBuilder.aliveCell;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Habitat_Test {

    private Cell cell = CellBuilder.anyCell();
    private final List<Cell> neighbours = Lists.newArrayList();


    @Test
    public void aHabitatOfAnAliveCellIsAlive() throws Exception {
        cell = aliveCell();
        assertThat(habitat().alive(), is(Constants.Alive));
    }

    @Test
    public void aHabitatOfADeadCellIsDead() throws Exception {
        cell = Cell.CreateDeadCell();
        assertThat(habitat().alive(), is(Constants.Dead));
    }

    @Test
    public void habitatWithNoNeighboursAsNoAliveNeighbours() throws Exception {
        assertThat(habitat().numberOfAliveNeighbours(), is(0));
    }

    @Test
    public void habitatWithOneAliveCellNeighbour() throws Exception {
        neighbours.add(aliveCell());

        assertThat(habitat().numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void habitatWithTwoAliveAndOneDeadCellCellNeighbour() throws Exception {
        neighbours.add(aliveCell());
        neighbours.add(Cell.CreateDeadCell());
        neighbours.add(aliveCell());

        assertThat(habitat().numberOfAliveNeighbours(), is(2));
    }

    private Habitat habitat() {
        return new Habitat(this.cell, this.neighbours);
    }

}