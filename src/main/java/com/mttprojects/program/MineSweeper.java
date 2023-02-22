/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mttprojects.program;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static utils.ToolsClass.*;

/**
 *
 * @author matiw
 */
public class MineSweeper extends javax.swing.JInternalFrame {

    public JDesktopPane parent;
    int ROWS = 20;
    int COLS = 20;
    int CELL_SIZE = 35;  // Cell width and height, in pixels
    int CANVAS_WIDTH = CELL_SIZE * COLS; // Game board width/height
    int CANVAS_HEIGHT = CELL_SIZE * ROWS;

    mineCell cells[][] = new mineCell[ROWS][COLS];
    ArrayList<mineCell> cellsList = new ArrayList<mineCell>();
    ArrayList<mineCell> realCellsList = new ArrayList<mineCell>();
    int MINES = 50;
    int preMines = 50;
    int DIFFICULTY = 1;

    int minesLeft = MINES;
    int FlagsPlaced = MINES;
    int FlagsLeft = MINES;
    int elapsedTime = 0;
    boolean GAMEWON = false;
    boolean minesPlaced = false;

    ActionListener mineLeftListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            mineCell button = (mineCell) e.getSource();

            if (!minesPlaced) {
                mines_Populate(button);
                minesPlaced = true;
            }
            if (!GAMEWON) {
                if (!timer.isRunning()) {
                    timer.start();
                }

                if (button.isMined && !button.isFlagged) {
                    GameOver(button);
                } else if (!button.isFlagged) {
                    String value = button.getText();
                    printLog("Click value: " + value);
                    revealCell(button.row, button.col);
                }
            }
        }
    };

    MouseListener mineRightListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                if (!GAMEWON) {
                    if (!timer.isRunning()) {
                        timer.start();
                    }

                    mineCell button = (mineCell) e.getSource();
                    if (!button.isRevealed) {

                        if (button.isFlagged) {
                            button.isFlagged = false;
                            FlagsLeft++;
                            if (button.isMined) {
                                minesLeft++;
                            }
                        } else if (FlagsLeft > 0) {
                            button.isFlagged = true;
                            FlagsLeft--;
                            if (button.isMined) {
                                minesLeft--;
                            }
                        }
                        button.paint();
                        printLog("Mines left = " + minesLeft);
                        TXT_mines.setText(FlagsLeft + "");

                    }
                    checkWon();
                }
            }
        }
    };

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime++;
            TXT_time.setText(String.valueOf(elapsedTime));
        }
    });

    /**
     * Creates new form MineSweeper
     */
    public MineSweeper(JDesktopPane myparent) {
        parent = myparent;
        initComponents();
        NewGame();

    }

    public static void main(String[] args) {
       
    }

    public void checkWon() {
        if (minesLeft == 0) {
            BT_middle.setText("B)");
            for (int i = 0; i < realCellsList.size(); i++) {

                mineCell myMine = realCellsList.get(i);

                if (myMine.isMined) {
                    myMine.paintCell(Color.GREEN);
                    printLog("Paint mine in " + myMine.row + "|" + myMine.col);
                } else {
                    myMine.isRevealed = true;
                    myMine.paint();
                }
            }
            timer.stop();
            //showMessage("YOU WIN!");
            GAMEWON = true;
        }

    }

    public void GameOver(mineCell minepress) {
        BT_middle.setText("X-X");

        for (int i = 0; i < realCellsList.size(); i++) {

            mineCell myMine = realCellsList.get(i);

            if (myMine.isMined) {
                myMine.paintCell(Color.RED);
                printLog("Paint mine in " + myMine.row + "|" + myMine.col);
            } else {
                myMine.isRevealed = true;
                myMine.paint();
            }
        }
        minepress.paintCell(Color.BLACK);
        timer.stop();
        //showMessage("GAME OVER!");
        GAMEWON = true;
    }

    public void GenerateGrid() {
        CANVAS_WIDTH = CELL_SIZE * COLS; // Game board width/height
        CANVAS_HEIGHT = CELL_SIZE * ROWS;

        realCellsList = new ArrayList<mineCell>();
        cellsList = new ArrayList<mineCell>();
        cells = new mineCell[ROWS][COLS];

        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();

        printLog("Genering Panel");
        gamePanel.setLayout(new GridLayout(ROWS, COLS, 1, 1));  // JPanel

        // Allocate the 2D array of Cell, and added into content-pane.
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                mineCell myMine = new mineCell(row, col);
                cells[row][col] = myMine;
                cellsList.add(myMine);
                realCellsList.add(myMine);
                gamePanel.add(cells[row][col]);
            }
        }

        Dimension gridSize = new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
        gamePanel.setSize(gridSize);
        gamePanel.setPreferredSize(gridSize);
        gamePanel.setMinimumSize(gridSize);
        gamePanel.setMaximumSize(gridSize);

        for (int i = 0; i < cellsList.size(); i++) {
            cellsList.get(i).addActionListener(mineLeftListener);
            cellsList.get(i).addMouseListener(mineRightListener);
        }

        Dimension windowSize = new Dimension(CANVAS_WIDTH + CELL_SIZE / 2, CANVAS_HEIGHT + 100 + CELL_SIZE / 2);
        this.setPreferredSize(windowSize);
        this.setMinimumSize(windowSize);
        this.setMaximumSize(windowSize);
        this.setSize(windowSize);
        this.updateUI();

        centerFrame();
    }

    private void centerFrame() {
        // Obtener el JDesktopPane que contiene el JInternalFrame
        // Obtener el tamaño del JDesktopPane
        Dimension desktopSize = parent.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    void mines_Populate(mineCell nothis) { //EL PRIMER CLICK NUNCA TIENE MINA
        cellsList.remove(nothis);

        while (MINES > 0) {
            int r = randomRangeInt(0, cellsList.size() - 1);
            mineCell myMine = cellsList.get(r);
            myMine.isMined = true;
            cellsList.remove(myMine);
            MINES--;
        }
    }

    private int getSurroundingMines(int Row, int Col) {
        int numMines = 0;
        for (int i = Row - 1; i <= Row + 1; i++) {
            for (int j = Col - 1; j <= Col + 1; j++) {
                // Need to ensure valid row and column numbers too
                if (i >= 0 && i < ROWS && j >= 0 && j < COLS) {
                    if (cells[i][j].isMined) {
                        numMines++;
                    }
                }
            }
        }
        return numMines;
    }

    private void revealCell(int Row, int Col) {
        int numMines = getSurroundingMines(Row, Col);
        cells[Row][Col].setText(numMines + "");
        cells[Row][Col].isRevealed = true;
        cells[Row][Col].paint();
        if (numMines == 0) {
            for (int i = Row - 1; i <= Row + 1; i++) {
                for (int j = Col - 1; j <= Col + 1; j++) {
                    if (i >= 0 && i < ROWS && j >= 0 && j < COLS) {
                        if (!cells[i][j].isRevealed) {
                            revealCell(i, j);
                        }
                    }
                }
            }
        }
    }

    void NewGame() {
        switch (DIFFICULTY) {
            case 1:
                ROWS = 9;
                COLS = 9;
                MINES = 10;
                break;
            case 2:
                ROWS = 16;
                COLS = 16;
                MINES = 40;
                break;
            case 3:
                ROWS = 16;
                COLS = 30;
                MINES = 99;
                break;
            case 4:
                DIFFICULTY = 5;
                ROWS = formatMaxMin(messageGetInt("Ingrese el numero de filas. (Maximo 20)"), 5, 20);
                COLS = formatMaxMin(messageGetInt("Ingrese el numero de Columnas. (Maximo 30)"), 5, 30);
                int bombsMax = ((ROWS * COLS) - ((((ROWS * 2) + (COLS * 2)) / 2) - 1));
                MINES = formatMaxMin(messageGetInt("Ingrese el numero de Columnas. (Maximo " + bombsMax + ")"), 1, bombsMax);
                preMines = MINES;
                ;
                break;
            case 5:
                MINES = preMines;
                
                break;


        }
        BT_middle.setText(":)");
        elapsedTime = 0;
        minesLeft = MINES;
        FlagsPlaced = 0;
        FlagsLeft = MINES;
        TXT_mines.setText(FlagsLeft + "");
        TXT_time.setText("0");
        timer.restart();
        timer.stop();
        GenerateGrid();
        GAMEWON = false;
        minesPlaced = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        gamePanel = new javax.swing.JPanel();
        BT_middle = new javax.swing.JButton();
        TXT_time = new javax.swing.JTextField();
        TXT_mines = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNewGame = new javax.swing.JMenuItem();
        menuClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuBeg = new javax.swing.JMenuItem();
        menuInter = new javax.swing.JMenuItem();
        menuExp = new javax.swing.JMenuItem();
        menuCustom = new javax.swing.JMenuItem();

        setResizable(true);
        setTitle("MineSweeper");

        gamePanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        BT_middle.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        BT_middle.setText(":)");
        BT_middle.setToolTipText("");
        BT_middle.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BT_middle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BT_middle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_middleActionPerformed(evt);
            }
        });

        TXT_time.setEditable(false);
        TXT_time.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        TXT_time.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TXT_time.setText("0");

        TXT_mines.setEditable(false);
        TXT_mines.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        TXT_mines.setText("0");

        jMenu1.setText("Menu");

        menuNewGame.setText("New Game");
        menuNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewGameActionPerformed(evt);
            }
        });
        jMenu1.add(menuNewGame);

        menuClose.setText("Close");
        menuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseActionPerformed(evt);
            }
        });
        jMenu1.add(menuClose);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("GameModes");

        menuBeg.setText("Begginer");
        menuBeg.setActionCommand("Begginer");
        menuBeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBegActionPerformed(evt);
            }
        });
        jMenu2.add(menuBeg);

        menuInter.setText("Intermediate");
        menuInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInterActionPerformed(evt);
            }
        });
        jMenu2.add(menuInter);

        menuExp.setText("Expert");
        menuExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExpActionPerformed(evt);
            }
        });
        jMenu2.add(menuExp);

        menuCustom.setText("Custom");
        menuCustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCustomActionPerformed(evt);
            }
        });
        jMenu2.add(menuCustom);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TXT_mines, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_middle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_time, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_middle)
                    .addComponent(TXT_mines, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_time, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewGameActionPerformed
        NewGame();
    }//GEN-LAST:event_menuNewGameActionPerformed

    private void menuBegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBegActionPerformed
        DIFFICULTY = 1;
        NewGame();
    }//GEN-LAST:event_menuBegActionPerformed

    private void BT_middleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_middleActionPerformed
        NewGame();
    }//GEN-LAST:event_BT_middleActionPerformed

    private void menuCustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCustomActionPerformed
        DIFFICULTY = 4;
        NewGame();
    }//GEN-LAST:event_menuCustomActionPerformed

    private void menuExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExpActionPerformed
        DIFFICULTY = 3;
        NewGame();
    }//GEN-LAST:event_menuExpActionPerformed

    private void menuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuCloseActionPerformed

    private void menuInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInterActionPerformed
        DIFFICULTY = 2;
        NewGame();
    }//GEN-LAST:event_menuInterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_middle;
    private javax.swing.JTextField TXT_mines;
    private javax.swing.JTextField TXT_time;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JMenuItem menuBeg;
    private javax.swing.JMenuItem menuClose;
    private javax.swing.JMenuItem menuCustom;
    private javax.swing.JMenuItem menuExp;
    private javax.swing.JMenuItem menuInter;
    private javax.swing.JMenuItem menuNewGame;
    // End of variables declaration//GEN-END:variables
}
