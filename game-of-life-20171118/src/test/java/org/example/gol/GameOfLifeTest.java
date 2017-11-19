package org.example.gol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.WorldBuilder.o;
import static org.example.gol.WorldBuilder.x;

public class GameOfLifeTest {

    @Test
    public void oscillator() throws Exception {
        WorldBuilder oscillator = new WorldBuilder();
        oscillator.row(o, o, o);
        oscillator.row(x, x, x);
        oscillator.row(o, o, o);

        World initialWorld = oscillator.build();

        assertThat(initialWorld.evolve().evolve()).isEqualTo(initialWorld);
    }

    @Test
    public void biggerExample() throws Exception {
        WorldBuilder world = new WorldBuilder();
        world.row(o, x, o, o, o, x, o);
        world.row(o, x, o, o, o, x, o);
        world.row(o, x, o, o, o, x, o);

        WorldBuilder expectedWorld = new WorldBuilder();
        expectedWorld.row(o, o, o, o, o, o, o);
        expectedWorld.row(x, x, x, o, x, x, x);
        expectedWorld.row(o, o, o, o, o, o, o);

        assertThat(world.build().evolve()).isEqualTo(expectedWorld.build());
    }
}
