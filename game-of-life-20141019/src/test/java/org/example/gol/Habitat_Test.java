package org.example.gol;

import static org.example.gol.HabitatBuilder.AnyHabitatWithoutNeighbours;
import static org.example.gol.HabitatBuilder.PlanHabitat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Habitat_Test {

    @Test
    public void habitatIsAliveIfItsCellIsAlive() throws Exception {
        Habitat habitat = PlanHabitat().alive().build();

        assertThat("alive cell should result in an alive habitat", habitat.alive());
    }

    @Test
    public void habitatIsDeadIfItsCellIsDead() throws Exception {
        Habitat habitat = PlanHabitat().dead().build();

        assertThat("dead cell should result in a dead habitat", habitat.dead());
    }

    @Test
    public void aHabitatWithZeroNeighboursHasNoAliveNeighbours() throws Exception {
        Habitat habitat = AnyHabitatWithoutNeighbours().build();

        assertThat(habitat.numberOfAliveNeighbours(), is(0));
    }

    @Test
    public void countAliveNeighbours() throws Exception {
        Habitat habitat = AnyHabitatWithoutNeighbours()
                .addAliveNeighbour()
                .build();

        assertThat(habitat.numberOfAliveNeighbours(), is(1));
    }

    @Test
    public void excludeDeadNeighboursFromTheAliveNeighbourCount() throws Exception {
        Habitat habitat = AnyHabitatWithoutNeighbours()
                .addAliveNeighbour()
                .addDeadNeighbour()
                .addAliveNeighbour()
                .build();

        assertThat(habitat.numberOfAliveNeighbours(), is(2));
    }
}
