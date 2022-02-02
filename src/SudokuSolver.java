public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {

        int[][] boards = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        if(solveBoards(boards)) {
            System.out.println("Solved successfully!");
        } else {
            System.out.println("Unsolvable boards :(");
        }

        printBoards(boards);
    }

    private static void printBoards(int[][] boards) {
        for(int row = 0; row < GRID_SIZE; row++) {
            if(row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for(int column = 0; column < GRID_SIZE; column++) {
                if(column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(boards[row][column]);
            }
            System.out.println();
        }
    }

    private static boolean isNumberInRow(int[][] boards, int number, int row) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(boards[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] boards, int number, int column) {
        for(int i = 0; i < GRID_SIZE; i++) {
            if(boards[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] boards, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++) {
            for( int j = localBoxColumn; j < localBoxColumn + 3; j++) {
                if(boards[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] boards, int number, int row, int column) {
        return  !isNumberInRow(boards, number, row) &&
                !isNumberInColumn(boards, number, column) &&
                !isNumberInBox(boards, number, row, column);
    }

    private static boolean solveBoards(int[][] boards) {
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int column = 0; column < GRID_SIZE; column++) {
                if(boards[row][column] == 0) {
                    for(int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if(isValidPlacement(boards, numberToTry, row, column)) {
                            boards[row][column] = numberToTry;

                            if(solveBoards(boards)){
                                return true;
                            } else {
                                boards[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}