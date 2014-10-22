package org.example.gol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Rule_AliveCellTest {

    @Test
    public void diesWithLessThanTwoAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.AliveCell.staysAlive(1), is(Constants.Dead));
    }

    @Test
    public void diesWithMoreThanThreeAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.AliveCell.staysAlive(4), is(Constants.Dead));
    }

    @Test
    public void livesOnWithTwoAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.AliveCell.staysAlive(2), is(Constants.Alive));
    }

    @Test
    public void livesOnWithThreeAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.AliveCell.staysAlive(3), is(Constants.Alive));
    }

}
