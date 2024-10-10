package minesweeper;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static minesweeper.MineSweeperConstants.ROWS;
import static minesweeper.MineSweeperConstants.COLS;
import javax.swing.ImageIcon;

public class GameBoardPanel extends JPanel {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // Define named constants for UI sizes
   public static final int CELL_SIZE = 60;  // Cell width and height, in pixels
   public static final int CANVAS_WIDTH  = CELL_SIZE * COLS; // Game board width/height
   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
   ImageIcon icon;
   ImageIcon icon2;




   // Define properties (package-visible)
   /** The game board composes of ROWSxCOLS cells */
   Cell cells[][] = new Cell[ROWS][COLS];
   /** Number of mines */
   int numMines = 10;


   /** Constructor */
   public GameBoardPanel() {
      super.setLayout(new GridLayout(ROWS, COLS, 2, 2));  // JPanel
      try {
    	    ImageIcon originalIcon = new ImageIcon("D:/eclipse-workspace/6620503608/Lab/src/minesweeper/Minesweeper_flag.svg.png");
    	
    	    Image image = originalIcon.getImage().getScaledInstance(CELL_SIZE, CELL_SIZE, Image.SCALE_SMOOTH);
    	    icon = new ImageIcon(image);

    	    if (icon.getIconWidth() == -1) {
    	        throw new Exception("Icon could not be loaded.");
    	    }
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    icon = null; 
    	}
      
      try {
  	    ImageIcon originalIcon2 = new ImageIcon("D:/eclipse-workspace/6620503608/Lab/src/minesweeper/png-transparent-red-circle-minesweeper"
  	    		+ "-minesweeper-deluxe-minesweeper-adfree-video-games-land-mine-naval-mine-android-thumbnail.png");

  	    Image image2 = originalIcon2.getImage().getScaledInstance(CELL_SIZE, CELL_SIZE, Image.SCALE_SMOOTH);
  	    icon2 = new ImageIcon(image2);

  	    if (icon2.getIconWidth() == -1) {
  	        throw new Exception("Icon could not be loaded.");
  	    }
  	} catch (Exception e) {
  	    e.printStackTrace();
  	    icon2 = null; 
  	}
      


      // Allocate the 2D array of Cell, and added into content-pane.
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);
         }
      }

      // [TODO 3] Allocate a common listener as the MouseEvent listener for all the
      //  Cells (JButtons)
      // .........
      CellMouseListener listener = new CellMouseListener();

      // [TODO 4] Every cell adds this common listener
      // .........
 
      for (int row = 0; row < ROWS; ++row) {
          for (int col = 0; col < COLS; ++col) {
        	  cells[row][col].addMouseListener(listener);
        	  
          }
       }

      // Set the size of the content-pane and pack all the components
      //  under this container.
      super.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
   }

   // Initialize and re-initialize a new game
   public void newGame() {
      // Get a new mine map
      MineMap mineMap = new MineMap();
      mineMap.newMineMap(numMines);

      // Reset cells, mines, and flags
      for (int row = 0; row < ROWS; row++) {
         for (int col = 0; col < COLS; col++) {
            // Initialize each cell with/without mine
            cells[row][col].newGame(mineMap.isMined[row][col]);
         }
      }
   }

   // Return the number of mines [0, 8] in the 8 neighboring cells
   //  of the given cell at (srcRow, srcCol).
   private int getSurroundingMines(int srcRow, int srcCol) {
      int numMines = 0;
      for (int row = srcRow - 1; row <= srcRow + 1; row++) {
         for (int col = srcCol - 1; col <= srcCol + 1; col++) {
            // Need to ensure valid row and column numbers too
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
               if (cells[row][col].isMined) numMines++;
            }
         }
      }
      return numMines;
   }

   // Reveal the cell at (srcRow, srcCol)
   // If this cell has 0 mines, reveal the 8 neighboring cells recursively
   private void revealCell(int srcRow, int srcCol) {
      int numMines = getSurroundingMines(srcRow, srcCol);
     if(numMines==0) {
    	 cells[srcRow][srcCol].setText("");
     }
     else {
         cells[srcRow][srcCol].setText(numMines + "");
     }
     cells[srcRow][srcCol].isRevealed = true;
     cells[srcRow][srcCol].paint();  // based on isRevealed
      if (numMines == 0) {
        // Recursively reveal the 8 neighboring cells
         for (int row = srcRow - 1; row <= srcRow + 1; row++) {
            for (int col = srcCol - 1; col <= srcCol + 1; col++) {
               // Need to ensure valid row and column numbers too
               if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                  if (!cells[row][col].isRevealed) revealCell(row, col);
               }
            }
         }
      }
   }

   // Return true if the player has won (all cells have been revealed or were mined)
   public boolean hasWon() {
	   int row=0,col=0;
	    for (row = 0; row < ROWS; row++) {
	        for (col = 0; col < COLS; col++) {
	            // If the cell is not mined and not revealed, the player hasn't won yet
	            if (!cells[row][col].isMined && !cells[row][col].isRevealed) {
	                return false;
	            }
	        }
	    }
	    // If we get here, all non-mine cells have been revealed
        // reset the flagged state
	    return true;
	}

   // [TODO 2] Define a Listener Inner Class
   private class CellMouseListener extends MouseAdapter {
      private static final boolean True = false;

	@Override
      public void mouseClicked(MouseEvent e) {         // Get the source object that fired the Event
         Cell sourceCell = (Cell)e.getSource();
         // For debugging
         System.out.println("You clicked on (" + sourceCell.row + "," + sourceCell.col + ")");

         // Left-click to reveal a cell; Right-click to plant/remove the flag.
         if (e.getButton() == MouseEvent.BUTTON1) {  // Left-button clicked
            // [TODO 5] (later, after TODO 3 and 4
            // if you hit a mine, game over
            // else reveal this cell
        	if(sourceCell.getIcon()!=null) {
        		 sourceCell.enable(false);
        	}
        	else {
        		//sourceCell.enable(True);
                if (sourceCell.isMined) {
                    System.out.println("Game Over");
                    
                    sourceCell.setIcon(icon2);
                    //int ans = JOptionPane.showConfirmDialog(null, "Game Over!","MineSweeper",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Game Over!");
                    System.exit(0);

                 } else {
                    revealCell(sourceCell.row, sourceCell.col);


                 }
        	}

         } 
         else if (e.getButton() == MouseEvent.BUTTON3) { // right-button clicked
            // [TODO 6]
            // If this cell is flagged, remove the flag
            // else plant a flag.
            // ......
         	if(sourceCell.isRevealed) {
       		 sourceCell.enable(false);
       	    } 
         	else {
         	 //sourceCell.enable(True);
           	 if(sourceCell.isFlagged) {
        		 sourceCell.isFlagged = false;
        		 sourceCell.setIcon(null);
        		 sourceCell.setText("");
        	 }
        	 else {
        		 sourceCell.isFlagged = true;
                 System.out.println("You call flag");
                 sourceCell.setIcon(icon);
        	 }
           	sourceCell.repaint();
         		
         	}
 
             
         }

         // [TODO 7] Check if the player has won, after revealing this cell
         // ......
         if (hasWon()) {
        	    int response = JOptionPane.showConfirmDialog(null,
        	        "Congratulations! You won! Do you want to play again?",
        	        "Game Over",
        	        JOptionPane.YES_NO_OPTION
        	    );

        	    if (response == JOptionPane.YES_OPTION) {
        	        newGame();
        	    } else {
        	        System.exit(0);
        	    }
        	}
      }
   }
}