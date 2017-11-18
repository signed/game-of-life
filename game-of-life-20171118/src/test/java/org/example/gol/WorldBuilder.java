package org.example.gol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.gol.Coordinates.xy;

class WorldBuilder {

    static final Boolean x = true;
    static final Boolean o = false;

    private final List<List<Boolean>> rows = new ArrayList<>();

    void row(Boolean... cells) {
        rows.add(Arrays.asList(cells));
    }

    World build() {

        Set<Coordinates> aliveCells = new HashSet<>();

        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            List<Boolean> row = rows.get(rowIndex);
            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                if (row.get(columnIndex)) {
                    aliveCells.add(xy(columnIndex, rowIndex));
                }
            }
        }

        return new World(aliveCells);
    }
}
