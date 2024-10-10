package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import static minesweeper.MineSweeperConstants.ROWS;
import static minesweeper.MineSweeperConstants.COLS;
/**
 * The Cell class model the cells of the MineSweeper, by customizing (subclass)
 *   the javax.swing.JButton to include row/column and states.
 */
public class Cell extends JButton {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // Define named constants for JButton's colors and fonts
   //  to be chosen based on cell's state
   public static final Color BG_NOT_REVEALED = Color.GRAY;
   public static final Color FG_NOT_REVEALED = Color.RED;    // flag, mines
   public static final Color BG_REVEALED = Color.DARK_GRAY;
   public static final Color FG_REVEALED = Color.YELLOW; // number of mines
   public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
   public static final int CELL_SIZE = 60;
   public static final int CANVAS_WIDTH  = CELL_SIZE * COLS; 
   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
   
   

   // Define properties (package-visible)
   /** The row and column number of the cell */
   int row, col;
   /** Already revealed? */
   boolean isRevealed;
   /** Is a mine? */
   boolean isMined;
   /** Is Flagged by player? */
   boolean isFlagged;

   /** Constructor */
   public Cell(int row, int col) {
      super();   // JTextField
      this.row = row;
      this.col = col;
      // Set JButton's default display properties
      super.setFont(FONT_NUMBERS);
      super.setPreferredSize(new Dimension(GameBoardPanel.CELL_SIZE, GameBoardPanel.CELL_SIZE));
   }

   /** Reset this cell, ready for a new game */
   ImageIcon firsticon;
   public void newGame(boolean isMined) {
	      try {
	    	    ImageIcon originalIcon3 = new ImageIcon("D:/eclipse-workspace/6620503608/Lab/src/minesweeper/Minesweeper_unopened_square.svg.png");
	    	
	    	    Image image3 = originalIcon3.getImage().getScaledInstance(CELL_SIZE, CELL_SIZE, Image.SCALE_SMOOTH);
	    	    firsticon = new ImageIcon(image3);

	    	    if (firsticon.getIconWidth() == -1) {
	    	        throw new Exception("Icon could not be loaded.");
	    	    }
	    	} catch (Exception e) {
	    	    e.printStackTrace();
	    	  firsticon = null; 
	    	}
	      
      this.isRevealed = false; // default
      this.isFlagged = false;  // default
      this.isMined = isMined;  // given
      super.setEnabled(true);  // enable button
      super.setText("");// display blank
      super.setIcon(null);
      //super.setIcon(firsticon);
      paint();
   }

   /** Paint itself based on its status */
   public void paint() {
      super.setForeground(isRevealed? FG_REVEALED: FG_NOT_REVEALED);
      super.setBackground(isRevealed? BG_REVEALED: BG_NOT_REVEALED);
   }
}
