package org.example.gol;

import static org.example.gol.CellBuilder.anyCell;
import static org.example.gol.CellBuilder.o;
import static org.example.gol.CellBuilder.x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class Grid_ToHabitat_1x1_Test {

    private final GridBuilder builder = new GridBuilder().width(1).height(1);

    @Test
    public void convertCellToHabitat() throws Exception {
        builder.add(anyCell());
        assertThat(builder.build().toHabitats(), hasSize(1));
    }

    @Test
    public void placePassedCellAsInhabitantOfTheHabitat() throws Exception {
        builder.add(x);

        assertThat(builder.build().toHabitats().get(0).alive(), is(true));
    }

    @Test
    public void placePassedCellAsInhabitantOfTheHabitatReally() throws Exception {
        builder.add(o);

        assertThat(builder.build().toHabitats().get(0).alive(), is(false));
    }
}
