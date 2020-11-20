import java.util.*;

public class TicTacToe {
    //Fields
    static Scanner console = new Scanner(System.in);

    //Current Player
    final static int CPU_TURN = 0;
    final static int PLAYER_TURN = 1;

    //Player winning situation
    static ArrayList<Integer> playerPos = new ArrayList<>();
    static ArrayList<Integer> cpuPos = new ArrayList<>();


    //Players
    Random random;
    int playerX, playerY;
    
    //Constructor
    public TicTacToe() {

        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(board);
        while (true) {
            gamePlaying(PLAYER_TURN, board);
            gamePlaying(CPU_TURN, board);
            checkWinner();
        }

    }

    //Print the game board
    public void printGameBoard(char[][] board) {
        for (char[] b : board) {
            System.out.println(b);
        }
        System.out.println("--------");
    }

    //Playing
    public void gamePlaying(int turn, char[][] board) {

        if (turn == PLAYER_TURN) {
            System.out.print("Enter a place to set: ");
            playerX = console.nextInt();
            if (playerPos.contains(playerX) || cpuPos.contains(playerY)) {
                System.out.print("Place is already taken, try another: ");
                playerX = console.nextInt();
            }
            switch (playerX) {
                case 1:
                    board[0][0] = 'X';
                    break;

                case 2:
                    board[0][2] = 'X';
                    break;

                case 3:
                    board[0][4] = 'X';
                    break;

                case 4:
                    board[2][0] = 'X';
                    break;

                case 5:
                    board[2][2] = 'X';
                    break;

                case 6:
                    board[2][4] = 'X';
                    break;

                case 7:
                    board[4][0] = 'X';
                    break;

                case 8:
                    board[4][2] = 'X';
                    break;

                case 9:
                    board[4][4] = 'X';
                    break;

                default:
                    System.out.print("Enter right number [1 - 9]:");
                    playerX = console.nextInt();
                    break;
            }
            playerPos.add(playerX);
            printGameBoard(board);



        } else if (turn == CPU_TURN) {
            random = new Random();
            playerY = random.nextInt(9) + 1;
            if (playerPos.contains(playerY) || cpuPos.contains(playerY) || (playerPos.contains(playerX) || cpuPos.contains(playerX))) {
                playerY = random.nextInt(9) + 1;
            }
            switch (playerY) {
                case 1:
                    board[0][0] = 'O';
                    break;

                case 2:
                    board[0][2] = 'O';
                    break;

                case 3:
                    board[0][4] = 'O';
                    break;

                case 4:
                    board[2][0] = 'O';
                    break;

                case 5:
                    board[2][2] = 'O';
                    break;

                case 6:
                    board[2][4] = 'O';
                    break;

                case 7:
                    board[4][0] = 'O';
                    break;

                case 8:
                    board[4][2] = 'O';
                    break;

                case 9:
                    board[4][4] = 'O';
                    break;

                default:
                    break;
            }
            cpuPos.add(playerY);
            printGameBoard(board);

        }


    }

    //Check which player is winner of game
    public void checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPos.containsAll(l)) {
                System.out.println("You Won!");
                System.exit(0);
            } else if (cpuPos.containsAll(l)) {
                System.out.println("You Lose!");
                System.exit(0);
            } else if (playerPos.size() + cpuPos.size() == 9) {
                System.out.println("Draw!");
            }
        }

    }

    
    //Main methid
    public static void main(String[] args) {
        new TicTacToe();
    }


}
