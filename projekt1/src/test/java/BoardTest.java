import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {


    Board board1, board2;

    @BeforeEach
    void setUp() {
        board1 = new Board(SizeOfBoard.three);
        board2 = new Board(SizeOfBoard.five);


        board1.initBoard();
        board2.initBoard();
    }

    @AfterEach
    void tearDown() {
        board1 = null;
        board2 = null;
    }

    @Test
    void testIfTheBoardHasSize3x3(){
        assertThat(board1).hasFieldOrPropertyWithValue("rows", 3).hasFieldOrPropertyWithValue("columns", 3);

    }

    @Test
    void testIfTheBoardHasSize5x5(){
        assertThat(board2).hasFieldOrPropertyWithValue("rows", 5).hasFieldOrPropertyWithValue("columns", 5);

    }


    @Test
    void testIfTheBoardContainsOfBoxes(){
        assertThat(board1).hasFieldOrProperty("borad");
    }

    @Test
    void testIfTheBoardIsPrinted(){
        boolean ifPrinted;
        tie3x3(board1);
        ifPrinted = board1.boardIsFull();

        assertTrue(ifPrinted);
    }

    @Test
    void testIfCrossHasWonOn3x3Board(){
        boolean condition;
        Sign sign = Sign.cross;
        wonInRow(board1,sign,0);

        condition = board1.checkWhoHasWon(sign);

        assertTrue(condition);
    }

    @Test
    void testIfCrossHasWonOn5x5Board(){
        boolean condition;
        Sign sign = Sign.cross;
        wonInRow(board2,sign,0);
        condition = board2.checkWhoHasWon(sign);


        assertTrue(condition);
    }

    @Test
    void testIfCircleHasWonOn3x3Board(){
        boolean condition;
        Sign sign = Sign.circle;
        wonInRow(board1,sign,0);
        condition = board1.checkWhoHasWon(sign);

        assertTrue(condition);
    }

    @Test
    void testIfCircleHasWonOn5x5Board(){
        boolean condition;
        Sign sign = Sign.circle;
        wonInRow(board2,sign,0);
        condition = board2.checkWhoHasWon(sign);

        assertTrue(condition);
    }

    @Test
    void testIfThereIsTieOn3x3Board(){

        boolean condition_circle;
        boolean condition_cross;
        boolean condition;

        Sign sign_circle = Sign.circle;
        Sign sign_cross = Sign.cross;


        tie3x3(board1);
        condition_circle = board1.checkWhoHasWon(sign_circle);
        condition_cross = board1.checkWhoHasWon(sign_cross);

        condition = condition_circle && condition_cross;
        assertFalse(condition);
    }


    @Test
    void test3CrossesInRow(){
        boolean condition;
        int column = 0;
        Sign sign = Sign.cross;

        wonInRow(board1, sign, column);
        condition = board1.enoughtInRow(column, sign);

        assertTrue(condition);
    }

    @Test
    void test5CircleInColumn(){
        boolean condition;
        int row = 0;
        Sign sign = Sign.circle;

        wonInColumn(board2, sign, row);
        condition = board2.enoughtInColumn(row, sign);

        assertTrue(condition);
    }

    @Test
    void test3Diagonally(){
        boolean condition;

        Sign sign = Sign.cross;

        wonDiagonally(board1,sign);
        condition = board1.enoughtDiagonaly(Sign.cross);

        assertTrue(condition);
    }


    //helpers methods

    private void wonInRow(Board borad, Sign sign, int column) {
        for(int i=0; i<borad.columns;i++){
            borad.borad[column][i].sign = sign;
        }

    }

    private Board wonInColumn(Board borad, Sign sign, int row) {

        for(int i=0; i<borad.rows;i++){
            borad.borad[i][row].sign = sign;
        }
        return  borad;

    }

    private Board wonDiagonally(Board borad, Sign sign) {

        for(int i=0; i<borad.rows;i++){
            borad.borad[i][i].sign = sign;
        }
        return  borad;

    }

    private void tie3x3(Board borad) {

        borad.borad[0][0].sign = Sign.circle;
        borad.borad[1][0].sign = Sign.circle;
        borad.borad[2][0].sign = Sign.cross;

        borad.borad[0][1].sign = Sign.circle;
        borad.borad[1][1].sign = Sign.cross;
        borad.borad[2][1].sign = Sign.circle;

        borad.borad[0][2].sign = Sign.cross;
        borad.borad[1][2].sign = Sign.cross;
        borad.borad[2][2].sign = Sign.circle;


    }


}
