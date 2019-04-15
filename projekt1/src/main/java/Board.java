public class Board {
    public  int rows;
    public  int columns;
    public  Box[][] borad;
    public  SizeOfBoard size;


    public Board(SizeOfBoard size){
        this.size = size;
        this.rows = getLevelOfDifficulty();
        this.columns = getLevelOfDifficulty();
        this.borad = new Box[columns][rows];
        initBoard();


    }

    public void initBoard(){
        for(int j=0;j<columns;j++){
            for(int i=0;i<rows;i++){
               borad[j][i] = new Box(i,j);
            }
        }
    }

    public  boolean enoughtInColumn(int row, Sign sign){
        for (int i = 0; i < columns; i++) {
             if (borad[i][row].sign != sign) {
                return false;
            }
        }
        return true;

    }

    public  boolean enoughtInRow(int column, Sign sign){
        for (int i = 0; i < rows; ++i) {
            if (borad[column][i].sign != sign) {
                return false;
            }
        }
        return true;

    }
    public  boolean enoughtDiagonaly(Sign sign){
        Boolean conditionForword=true;
        Boolean conditionBackword=true;
        for (int i = 0; i < rows; i++) {
            if (borad[i][i].sign != sign) {
                conditionForword = false;
            }
        }
        for (int i = rows-1; i >= 0; i--) {
            if (borad[i][i].sign != sign) {
                conditionBackword = false;
            }
        }
        if(conditionForword && conditionBackword)
            return true;
        else
            return false;

    }

    public boolean checkWhoHasWon(Sign sign){

        boolean condition = false;

        for(int i=0;i<columns;i++){
            condition = enoughtInColumn(i,sign);
           if(condition==true)
               return true;
        }

        for(int i=0;i<rows;i++){
            condition = enoughtInRow(i,sign);
            if(condition==true)
                return true;
        }

        condition = enoughtDiagonaly(sign);

        if(condition==true)
            return true;
        else
            return false;
    }

    public  boolean boardIsFull() {
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {

                if(borad[j][i].sign == Sign.empty)
                    return false;

                }
            }
        return true;
    }

    public  int getLevelOfDifficulty() {
        switch (size) {
            case three:
                return 3;
            case five:
                return 5;
            default:
                 return 0;
        }

    }
}
