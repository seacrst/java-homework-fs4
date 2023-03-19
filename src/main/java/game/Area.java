package game;

import java.util.Arrays;

public class Area {
    static record Storage (int rowPosition, int colPosition) {};
    public final char[][] area;
    private int[] drop = new int[] {0, 0};


    public Area(int height, int width) {
        area = new char[height][width];
    }

    public Area markAt(int y, int x, char marker) {
        int outer = y - 1;
        int inner = x - 1;

        if (outer >= area.length || inner >= area[0].length || y <= 0 || x <= 0) {
            System.out.println("Cannot be marked at non-existing coordinates");
            return this;
        }

        area[inner][outer] = marker;

        return this;
    }

    public Area fill(char marker) {
        for (char[] y : area) {
            Arrays.fill(y, marker);
        }

        return this;
    }

    public void store(int col, int row) {
        drop[0] = col;
        drop[1] = row;
    }

    public int[] getStored() {
        return drop;
    }
    public int getStored(int pos) {
        if (pos > 1 || pos < 0) throw new IllegalStateException("Invalid entry position");
        return drop[pos];
    }

    private void printRow(char[] cells) {

        for (char c : cells) {
            System.out.print(" | ");
            System.out.print(c);
        }
        System.out.println(" |");
    }


    public void display() {
        for (char[] row : area) {
            printRow(row);
        }
    }


}
