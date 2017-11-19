package org.example.gol;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.WorldBuilder.o;
import static org.example.gol.WorldBuilder.x;


public class World_ToStringTest {

    private final WorldBuilder world = new WorldBuilder();

    @Test
    public void allDead() throws Exception {
        assertThat(world.build().toString()).isEqualTo("");
    }

    @Test
    public void oneAlive() throws Exception {
         world.row(x);

        assertThat(world.build().toString()).contains("x");
    }

    @Test
    public void twoAliveInX() throws Exception {
         world.row(x,o, x);

        assertThat(world.build().toString()).contains("xox");
    }

    @Test
    public void twoAliveInY() throws Exception {
         world.row(x);
         world.row(o);
         world.row(x);

        assertThat(world.build().toString()).contains("x\no\nx");
    }

}