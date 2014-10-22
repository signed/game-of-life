package org.example.gol;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Rule_DeadCellTest {

    @Test
    public void staysDeadWithTwoAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.DeadCell.becomesAlive(2), is(Constants.Dead));
    }

    @Test
    public void staysDeadWithFourAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.DeadCell.becomesAlive(4), is(Constants.Dead));
    }

    @Test
    public void becomesAliveWithThreeAliveNeighbours() throws Exception {
        assertThat(EvolutionRule.DeadCell.becomesAlive(3), is(Constants.Alive));
    }

}
