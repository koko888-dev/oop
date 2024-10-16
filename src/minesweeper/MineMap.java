package minesweeper;
// "import static" constants allow us to refer to as
//   ROWS (shorthand) instead of MineSweeperConstants.ROWS
import static minesweeper.MineSweeperConstants.ROWS;
import static minesweeper.MineSweeperConstants.COLS;
/**
 * Define the locations of mines
 */
public class MineMap {
   // package access
   int numMines;
   boolean[][] isMined = new boolean[ROWS][COLS];
         // default is false

   // Constructor
   public MineMap() {
      super();
   }

   // Allow user to change the rows and cols
   public void newMineMap(int numMines) {
      this.numMines = numMines;
      // Hardcoded for illustration and testing, assume numMines=10
      isMined[0][0] = true;
      isMined[5][2] = true;
      isMined[9][5] = true;
      isMined[6][7] = true;
      isMined[8][2] = true;
      isMined[2][4] = true;
      isMined[5][7] = true;
      isMined[7][7] = true;
      isMined[3][6] = true;
      isMined[4][8] = true;
   }
}