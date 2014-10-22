package org.example.gol;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class Grid_Habitats_1x1GridTest {

    @Test
    public void returnOneHabitat() throws Exception {
        List<Cell> cells = Lists.newArrayList();
        cells.add(Cell.x);

        assertThat(new Grid(cells, 1).habitats(), hasSize(1));
    }
}