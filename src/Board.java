import java.util.Random;

public class Board {
    private  static final double FACTOR = 0.15;
    private  Cell [][] cells;
    private final int height;
    private final int width;

    private int mineNumber;



    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
        this.mineNumber = (int) Math.round(height * width * FACTOR);
    }

    public Board(int height, int width, int mineNumber) {
        // 异常情况处理
        // TODO: 地雷个数大于棋盘单元格数量异常情况处理
        if(mineNumber >= height * width){
            // error?
        }
        this.height = height;
        this.width = width;
        this.mineNumber = mineNumber;
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
    private void  intMines(){
        Random random = new Random();
        // Step 1: 随机生成坐标，然后放置地雷
        // Step 2: 计算每个非地雷周围地雷数量

        // Step 1
        for(int i = 0;i<mineNumber;i++){
            int x,y;
             // 确保不会在同一位置重复放置地雷 需要先检查是否有雷
            // 如果有雷就跳过继续选择新的位置 直到选择出新的位置 设置为true
            do{
                 x = random.nextInt(height);
                 y = random.nextInt(width);
            }while (cells[x][y].isMine());

            cells[x][y].setMine(true);
        }

        // Step 2
        for(int i = 0;i<height;i++){
            for(int j = 0; j<width; j++){
                Cell curCell = cells[i][j];
                if(!curCell.isMine()){
                    int mineCount = 0;
                    // 坐标移动 (8个方向）dx =  {-1,0,1} dy = {-1,0,1}
                    for(int dx = -1; dx <= 1; dx++){
                        for(int dy = -1; dy <= 1; dy++){
                            int newX = i + dx;
                            int newY = j + dy;
                            if(checkMine(newX, newY)){
                                mineCount ++;
                            }
                        }
                    }
                    curCell.setAdjacentMines(mineCount);
                }
            }
        }
    }

    private boolean checkMine(int newX, int newY) {
        return newX >= 0 && newY >= 0
                && newX < height && newY < width
                && cells[newX][newY].isMine();
    }
}
