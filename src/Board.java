public class Board {
    private Cell [][] cells;
    private int height;
    private int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
