public class Box {
    int row;
    int column;
    public Sign sign ;


    public void isRowProper(int row) throws IllegalArgumentException {
        if (row < 0 || row > 6) {
            throw new IllegalArgumentException("Row must be greater than zero and smaller than six ");
        }
    }

    public void isColumnProper(int column) throws IllegalArgumentException {
        if (column < 0 || column > 6) {
            throw new IllegalArgumentException("Column must be greater than zero and smaller than six.");
        }
    }


    public Box(int row, int column) {
        try {

            this.row = row;
            this.column = column;
            clearBox();
            isRowProper(this.row);
            isColumnProper(this.column);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    public void clearBox() {
        this.sign = Sign.empty;
    }

    public String printSymbol() {
        switch (sign) {
            case empty:
                return " ";
            case cross:
                return "X";
            case circle:
                return "O";
            default:
                return null;
        }

    }
}
