package org.example.gol;

import static org.example.gol.CellBuilder.o;
import static org.example.gol.CellBuilder.x;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class GameOfLife_Test {

    private final GridBuilder grid = new GridBuilder().height(3).width(3);

    @Before
    public void setUp() throws Exception {
        grid.add(x, x, o);
        grid.add(o, o, x);
        grid.add(o, o, o);
    }

    @Test
    public void testName() throws Exception {
        assertThat("should be dead; cell with less than two live neighbours dies", gridAfterTick().cellAt(0, 0).isDead());
    }

    @Test
    public void testName2() throws Exception {
        assertThat("should be alive; cell with two live neighbours stays alive", gridAfterTick().cellAt(1, 0).isAlive());
    }

    @Test
    public void print() throws Exception {
        GridBuilder oscillator = new GridBuilder().width(3).height(3);
        oscillator.add(o, o, o);
        oscillator.add(x, x, x);
        oscillator.add(o, o, o);

        Grid grid = oscillator.build();

        for(int i=0; i< 10; ++i) {
            grid = tick(grid);
            System.out.println(grid);
            System.out.println("---");
        }

    }

    private Grid gridAfterTick() {
        return tick(grid.build());
    }

    private Grid tick(Grid grid) {
        List<Cell> cells = Lists.transform(grid.habitats(), input -> {
            boolean alive = Rules_EvolutionTest.willBeAlive(input.alive(), input.numberOfAliveNeighbours());
            if (alive) {
                return Cell.CreateAliveCell();
            }
            return Cell.CreateDeadCell();
        });
        return new Grid(grid.width(), grid.height(), cells);
    }
}
