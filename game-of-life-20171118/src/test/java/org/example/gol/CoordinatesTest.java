package org.example.gol;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.gol.Coordinates.xy;

public class CoordinatesTest {

    @Test
    public void twoCoordinatesAreEqualIfThereXandYvaluesMatch() throws Exception {
        Coordinates coordinate = xy(0, 0);
        Set<Coordinates> coordinates = new LinkedHashSet<>();
        coordinates.add(coordinate);

        assertThat(coordinates).contains(xy(0, 0)).doesNotContain(xy(1, 1));
    }

    @Test
    public void topLeftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, -1));
    }

    @Test
    public void topIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(0, -1));
    }

    @Test
    public void topRightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, -1));
    }

    @Test
    public void rightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, 0));
    }

    @Test
    public void bottomRightIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(1, 1));
    }

    @Test
    public void bottomIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(0, 1));
    }

    @Test
    public void bottomLeftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, 1));
    }

    @Test
    public void leftIsAdjacent() throws Exception {
        assertThat(xy(0, 0).adjacentCoordinates()).contains(xy(-1, 0));
    }
}
