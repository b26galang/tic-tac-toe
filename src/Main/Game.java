package Main;

import java.util.Scanner;

enum Status {
    // there is a row, column or diagonal consisting of only player1's game pieces:
    PLAYER1_WON,
    // there is a row, column or diagonal consisting of only player2's game pieces:
    PLAYER2_WON,
    // there is no row, column, or diagonal consisting of a single player's pieces:
    TIE,
    // there are spots on the board which are uninitialized;
    UNFINISHED
}

public class Game {
    Player player1;
    Player player2;
    Board board;

    // this function should prompt the players for names and gamePiece and assign it
    // to the player objects:
    private void initPlayers() {
        System.out.println("Player 1: What is your name?");
        Scanner NameInput = new Scanner(System.in);
        String name1 = NameInput.nextLine();
        System.out.println();
        Scanner CharInput = new Scanner(System.in);
        System.out.println("Player 1: Pick a game piece: ");
        char gamePiece1 = CharInput.next().charAt(0);
        this.player1 = new Player(name1, gamePiece1);
        System.out.println();

        System.out.println("Player 2: What is your name?");
        String name2 = NameInput.nextLine();
        System.out.println();
        System.out.println("Player 2: Pick a game piece: ");
        char gamePiece2 = CharInput.next().charAt(0);
        this.player2 = new Player(name2, gamePiece2);
        System.out.println();
    }

    // this method should let each player pick a spot and also print the board between selections:
    private void round() {
        Scanner spotInput = new Scanner(System.in);
        System.out.println("Player 1: " + player1.getName() + " Game Piece: "+ player1.getGamePiece() + "\n" + "Input a row number:");
        int rowInput1 = spotInput.nextInt();
        System.out.println();
        System.out.println("Player 1: " + player1.getName() + " Game Piece: "+ player1.getGamePiece() + "\n" + "Input a column number");
        int columnInput1 = spotInput.nextInt();
        board.updateBoard(rowInput1, columnInput1, player1.getGamePiece());
        System.out.println();

        while (board.taken){
            System.out.println(board.toString());
            System.out.println("Player 1: " + player1.getName() + " Game Piece: " + player1.getGamePiece() + "\n" + "Input a row number:");
            int retryRowInput = spotInput.nextInt();
            System.out.println();
            System.out.println("Player 1: " + player1.getName() + " Game Piece: " + player1.getGamePiece() + "\n" + "Input a column number");
            int retryColumnInput = spotInput.nextInt();
            System.out.println();
            board.updateBoard(retryRowInput, retryColumnInput, player1.getGamePiece());
        }
        System.out.println(board.toString());

        if (getStatus().equals(Status.PLAYER1_WON)) {
            System.out.println("Player 1: " + player1.getName() + " won!");
        } else if (getStatus().equals(Status.TIE)){
            System.out.println("It's a Tie!");
        } else if (getStatus().equals(Status.UNFINISHED)) {
            System.out.println("Player 2: " + player2.getName() + " Game Piece: " + player2.getGamePiece() + "\n" + "Input a row number:");
            int rowInput2 = spotInput.nextInt();
            System.out.println();
            System.out.println("Player 2: " + player2.getName() + " Game Piece: " + player2.getGamePiece() + "\n" + "Input a column number:");
            int columnInput2 = spotInput.nextInt();
            System.out.println();
            board.updateBoard(rowInput2, columnInput2, player2.getGamePiece());
            while (board.taken){
                System.out.println(board.toString());
                System.out.println("Player 2: " + player2.getName() + " Game Piece: " + player2.getGamePiece() + "\n" + "Input a row number:");
                int retryRowInput = spotInput.nextInt();
                System.out.println();
                System.out.println("Player 2: " + player2.getName() + " Game Piece: " + player2.getGamePiece() + "\n" + "Input a column number:");
                int retryColumnInput = spotInput.nextInt();
                System.out.println();
                board.updateBoard(retryRowInput, retryColumnInput, player2.getGamePiece());
            }
            System.out.println(board.toString());
        }

        if (getStatus().equals(Status.PLAYER2_WON)){
            System.out.println("Player 2: " + player2.getName() + " won!");
        } else if (getStatus().equals(Status.TIE)){
            System.out.println("It's a Tie!");
        }
    }

    // This should return a status of the board, using the enum Status:
    // need to check status of game at the end of each round to display a specific message based on result
    private Status getStatus() {
        if (board.board[0][0] == player1.getGamePiece() && board.board[0][1] == player1.getGamePiece() && board.board[0][2] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[1][0] == player1.getGamePiece() && board.board[1][1] == player1.getGamePiece() && board.board[1][2] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[2][0] == player1.getGamePiece() && board.board[2][1] == player1.getGamePiece() && board.board[2][2] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[0][0] == player1.getGamePiece() && board.board[1][0] == player1.getGamePiece() && board.board[2][0] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[0][1] == player1.getGamePiece() && board.board[1][1] == player1.getGamePiece() && board.board[2][1] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[0][2] == player1.getGamePiece() && board.board[1][2] == player1.getGamePiece() && board.board[2][2] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[0][0] == player1.getGamePiece() && board.board[1][1] == player1.getGamePiece() && board.board[2][2] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
        } else if (board.board[0][2] == player1.getGamePiece() && board.board[1][1] == player1.getGamePiece() && board.board[2][0] == player1.getGamePiece()) {
            return Status.PLAYER1_WON;
            // Player 2 wins
        }else if (board.board[0][0] == player2.getGamePiece() && board.board[0][1] == player2.getGamePiece() && board.board[0][2] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[1][0] == player2.getGamePiece() && board.board[1][1] == player2.getGamePiece() && board.board[1][2] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[2][0] == player2.getGamePiece() && board.board[2][1] == player2.getGamePiece() && board.board[2][2] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[0][0] == player2.getGamePiece() && board.board[1][0] == player2.getGamePiece() && board.board[2][0] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[0][1] == player2.getGamePiece() && board.board[1][1] == player2.getGamePiece() && board.board[2][1] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[0][2] == player2.getGamePiece() && board.board[1][2] == player2.getGamePiece() && board.board[2][2] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[0][0] == player2.getGamePiece() && board.board[1][1] == player2.getGamePiece() && board.board[2][2] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if (board.board[0][2] == player2.getGamePiece() && board.board[1][1] == player2.getGamePiece() && board.board[2][0] == player2.getGamePiece()) {
            return Status.PLAYER2_WON;
        } else if(board.board[0][0] != 0 && board.board[0][1] != 0 && board.board[0][2] != 0 && board.board[1][0] != 0 && board.board[1][1] != 0 &&
                board.board[1][2] != 0 && board.board[2][0] != 0 && board.board[2][1] != 0 &&
                board.board[2][2] != 0){
            return Status.TIE;
        }
        else {
            return Status.UNFINISHED;
            }
        }

        // 1. Set up, ask players for names and game piece
        // 2. For each round, let each player pick a spot
        // 3. Print the board after each move:
        // 4. When the game is over, announce the winner or that it is a tie
    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();
        game.board = new Board();
        System.out.println(game.board.toString());
        while (game.getStatus().equals(Status.UNFINISHED)){
            game.round();
        }
    }
}
