package org.example.gol;

public class EvolutionRule {

    public static boolean isAlive(boolean alive, int numberOfAliveNeighbours) {
        if (!alive) {
            return DeadCell.becomesAlive(numberOfAliveNeighbours);
        }
        return AliveCell.staysAlive(numberOfAliveNeighbours);
    }

    public static class AliveCell {

        public static boolean staysAlive(int numberOfAliveNeighbours) {
            return 2 == numberOfAliveNeighbours || 3 == numberOfAliveNeighbours;
        }
    }

    public static class DeadCell {

        public static boolean becomesAlive(int numberOfAliveNeighbours) {
            return 3 == numberOfAliveNeighbours;
        }
    }
}
