package Main;

public class Board {
    // a 2D array to represent the pieces on the board:
    char [][] board;
    boolean taken;

    // should instantiate the board to be a 3x3 array:
    public Board() {
        this.board = new char[3][3];
    }

    // this method should take in a row, column, and a newChar and update the board accordingly:
    public void updateBoard(int row, int column, char newChar) {
        if (board[row][column] == 0){
            this.board[row][column] = newChar;
            taken = false;
        } else {
            System.out.println("You can not place your game piece over an existing one. Please choose another spot!");
            System.out.println();
            taken = true;
        }
    }

    // this method should return a string representation of the board:
    public String toString() {
        String boardDisplay = "";
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                boardDisplay = boardDisplay + this.board[i][j] + " ";
            }
            boardDisplay += "\n";
        }
        return boardDisplay;
    }
}
