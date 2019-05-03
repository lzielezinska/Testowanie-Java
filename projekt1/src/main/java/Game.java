import java.io.*;
import java.rmi.UnknownHostException;
import java.util.Scanner;




public class Game {
    public Board board;
    public GameStatus status;

    public Game() {
        this.board  = new Board(chooseSizeOfBoard());
        this.status = GameStatus.play;
    }
    


    public void play(){
        int size = board.getLevelOfDifficulty();
        Sign sign = Sign.cross ;
        int watcher = 0;
        int IdCounter = 1;
        boolean condition = false;
        SavedGameplay savedGameplay = null;
        try{
             savedGameplay = new SavedGameplay();
             savedGameplay.removeAllMoves();
        }catch(UnknownHostException e) {
            e.printStackTrace();
        }
    
        do{
            printBoard();
            while(!condition)
                condition=chooseField(size, sign, IdCounter, savedGameplay);
            watcher++;
            sign = getSign(watcher);
            condition = false;
            IdCounter++;

        }while(!(board.boardIsFull() || board.checkWhoHasWon(sign)));

        status = changeStatus(sign);
        System.out.println(status);
        savedGameplay.getAllMoves();


    }

    private boolean chooseField(int size, Sign sign, int id, SavedGameplay savedGameplay) {
            Move move;
            Scanner input = new Scanner(System.in);
            System.out.println("In which row you want to put "+sign);
            int row = getInput(input, size);
            System.out.println("In which column you want to put "+sign);
            int column = getInput(input, size);
            if(board.borad[column][row].sign==Sign.empty){
                board.borad[column][row].sign = sign;
                move = new Move(row, column, id, sign);
                savedGameplay.add(move);
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
        int i;
        try{
            i = input.nextInt();
            isSizeProper(i);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
       
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

    public void isLocationProper(int input, int size) throws IllegalArgumentException {
        if (input < 0 || input > size-1) {
            throw new IllegalArgumentException("Input must be greater or equal 0 and smaller than "+size);
        }
    }
    
    public void isSizeProper(int input) throws IllegalArgumentException {
        if (input < 0 || input > 1) {
            throw new IllegalArgumentException("Input must be 0 or 1!");
        }
    }

    private int getInput(Scanner input, int size) {
       int location;
       try {
           location = input.nextInt();
           isLocationProper(location, size);
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
    
    private void printFloor(){
        System.out.print(" -----+");
        for(int i =1; i<board.rows-1;i++){
            System.out.print("----+");
        }
        System.out.println("-----");
    }
    


    private  void printBoard() {
        for (int j = 0; j < board.rows; j++) {
            printFloor();
            for (int i = 0; i < board.columns; i++) {
                System.out.print(" | "+board.borad[j][i].printSymbol()+" ");
            }
            System.out.println(" |");
        }
       printFloor();
        System.out.println();

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
