package org.example.gol;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class Rules_EvolutionTest {

    @Test
    public void staysAliveWithTwoNeighbours() throws Exception {
        assertThat("Alive cell with two neighbours should stay alive", staysAlive(2));
    }

    @Test
    public void staysAliveWithThreeNeighbours() throws Exception {
        assertThat("Alive cell with three neighbours should stay alive", staysAlive(3));
    }

    @Test
    public void diesWithLessThanTwoNeighbours() throws Exception {
        assertThat("Alive cell with less than two neighbours should die", !staysAlive(0));
    }

    @Test
    public void diesWithMoreThanThreeNeighbours() throws Exception {
        assertThat("Alive cell with four neighbours should die", !staysAlive(4));
        assertThat("Alive cell with five neighbours should die", !staysAlive(5));
    }

    @Test
    public void becomesAliveWithThreeNeighbours() throws Exception {
        assertThat("dead cell with three neighbours becomes alive", becomesAlive(3));
    }

    @Test
    public void staysDeadWith_2_orLessNeighbours() throws Exception {
        assertThat("dead cell with three neighbours becomes alive", !becomesAlive(2));
    }

    @Test
    public void staysDeadWith_4_orMoreNeighbours() throws Exception {
        assertThat("dead cell with three neighbours becomes alive", !becomesAlive(4));
    }

    @Test
    public void deadCellWithThreeNeighboursShouldBecomeAlive() throws Exception {
        assertThat("dead cell with three neighbours should become alive", willBeAlive(false, 3));
    }

    @Test
    public void deadCellWithOneNeighboursShouldStayDead() throws Exception {
        assertThat("dead cell with three neighbours should become alive", !willBeAlive(false, 1));
    }

    @Test
    public void aliveCellWithEightNeighboursShouldDie() throws Exception {
        assertThat("alive cell with eight neighbours should die", !willBeAlive(true, 8));
    }


    public static boolean willBeAlive(boolean alive, int numberOfAliveNeighbours) {
        if (alive) {
            return staysAlive(numberOfAliveNeighbours);
        }
        return becomesAlive(numberOfAliveNeighbours);
    }

    private static boolean becomesAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 3;
    }

    public static boolean staysAlive(int numberOfAliveNeighbours) {
        return numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3;
    }
}
