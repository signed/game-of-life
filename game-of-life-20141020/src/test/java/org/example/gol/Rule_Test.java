package org.example.gol;

import static org.example.gol.Constants.Alive;
import static org.example.gol.Constants.Dead;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Rule_Test {

    @Test
    public void aliveCellWithZeroAliveNeighboursShouldDie() throws Exception {
        assertThat(EvolutionRule.isAlive(Alive, 0), is(Dead));
    }

    @Test
    public void deadCellWithThreeAliveNeighboursShouldBecomeAlive() throws Exception {
        assertThat(EvolutionRule.isAlive(Dead, 3), is(Alive));
    }

    @Test
    public void deadCellWithTwoAliveNeighboursShouldStayDead() throws Exception {
        assertThat(EvolutionRule.isAlive(Dead, 2), is(Dead));
    }

}
