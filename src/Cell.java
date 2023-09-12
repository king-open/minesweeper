public class Cell {
    private boolean mine;
    private boolean revealed;
    private boolean flagged;
    private  int adjacentMines;


    public Cell() {

    }

    public Cell(boolean isMine,
                boolean revealed,
                boolean flagged,
                int adjacentMines) {
        this.mine = isMine;
        this.revealed = revealed;
        this.flagged = flagged;
        this.adjacentMines = adjacentMines;
    }

    public boolean isMine() {
        return mine;
    }

    public Cell setMine(boolean mine) {
        this.mine = mine;
        return this;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public Cell setRevealed(boolean revealed) {
        this.revealed = revealed;
        return this;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public Cell setFlagged(boolean flagged) {
        this.flagged = flagged;
        return this;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public Cell setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
        return this;
    }
}
