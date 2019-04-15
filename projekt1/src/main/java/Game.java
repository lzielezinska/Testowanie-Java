import java.io.*;
import java.util.Scanner;

public class Game {
    public Board board;
    public GameStatus status;

    public Game() {
        this.board  = new Board(chooseSizeOfBoard());
        this.status = GameStatus.play;
    }

    Scanner input = new Scanner(System.in);


    public void play(){
        int size = board.getLevelOfDifficulty();
        Sign sign = Sign.cross ;
        int watcher = 0;
        boolean condition = false;
        do{
            printBoard();
            while(condition!=true)
                condition=chooseField(size, sign);
            watcher++;
            sign = getSign(watcher);
            condition = false;

        }while(!(board.boardIsFull() || board.checkWhoHasWon(sign)));

        status = changeStatus(sign);
        System.out.println(status);


    }

    private boolean chooseField(int size, Sign sign) {
        System.out.println("In which row you want to put "+sign);
        int row = getInput(input, size);
        System.out.println("In which column you want to put "+sign);
        int column = getInput(input, size);
        if(board.borad[column][row].sign==Sign.empty){
            board.borad[column][row].sign = sign;
            String message = sign+" was written in location row = "+row+" column = "+column+"\n";
            writeTheGameToFile(message);
            return true;
        }else {
            System.out.println("You have chosen a filed, which has been already occupied");
            return false;
        }


    }

    private SizeOfBoard chooseSizeOfBoard(){
        System.out.println("Choose the size of board\n[0]-3x3\n[1]-5x5");
        Scanner input = new Scanner(System.in);
       int i = input.nextInt();
       switch (i) {
            case 0:
                return SizeOfBoard.three;

            case 1:
                return SizeOfBoard.five;

            default:
                return SizeOfBoard.three;
        }

    }


    private GameStatus changeStatus(Sign sign) {
        if (sign==Sign.cross && board.checkWhoHasWon(sign)){
            return GameStatus.crossWon;

        }else if(sign==Sign.circle && board.checkWhoHasWon(sign)){
            return  GameStatus.circleWon;
        }else {
            return GameStatus.tie;
        }
    }

    public void isInputProper(int input, int size) throws IllegalArgumentException {
        if (input < 0 || input > size) {
            throw new IllegalArgumentException("Input must be greater than 0 and smaller than "+size+1);
        }
    }

    private int getInput(Scanner input, int size) {
       int location;
       try {
           location = input.nextInt();
           isInputProper(location, size);
       }catch (IllegalArgumentException e) {
           throw new IllegalArgumentException(e.getMessage());
       }
       return location;
    }

    private Sign getSign(int watcher) {
        Sign sign;
        if(watcher % 2 ==0)
            sign = Sign.cross;
        else
            sign = Sign.circle;
        return sign;
    }


    private  void printBoard() {
        for (int j = 0; j < board.rows; j++) {
            for (int i = 0; i < board.columns; i++) {
                System.out.print(" | "+board.borad[j][i].printSymbol()+" | ");
            }
            System.out.println();
        }

    }

    private  void writeTheGameToFile(String message){

        try {
            FileOutputStream output = new FileOutputStream("Game_Journal.txt", true);
            FileWriter save;
            save = new FileWriter("Game_Journal.txt", true);
            save.write(message);
            save.close();
        }
        catch(IOException e){
            System.out.print("The file hasn't been creates\nError: "+e);
        }

    }

}
