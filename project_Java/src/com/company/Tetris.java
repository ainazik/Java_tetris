package com.company;

import java.awt.*;
import java.awt.event.*;

import static com.company.Config.*;
import static java.lang.Math.*;
import static java.lang.String.format;
import java.util.*;
import javax.swing.*;
//import static tetris.Config.*;

public class Tetris extends JPanel implements Runnable {
    enum Dir {
        right(1, 0), down(0, 1), left(-1, 0);

        Dir(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x, y;
    };

    public static final int EMPTY = -1;
    public static final int BORDER = -2;

    Shape fallingShape;
    Shape nextShape;

    // position of falling shape
    int fallingShapeRow;
    int fallingShapeCol;

    final int[][] grid = new int[nRows][nCols];
    
    Thread fallingThread;
    final Scoreboard scoreboard = new Scoreboard();
    static final Random rand = new Random();

    public Tetris() {
        setPreferredSize(dim);
        setBackground(bgColor);
        setFocusable(true);

        initGrid();
        selectShape();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (scoreboard.isGameOver()) {
                    startNewGame();
                    repaint();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            boolean fastDown;

            @Override
            public void keyPressed(KeyEvent e) {

                if (scoreboard.isGameOver())
                    return;

                switch (e.getKeyCode()) {

                    case KeyEvent.VK_UP:
                        if (canRotate(fallingShape))
                            rotate(fallingShape);
                        break;

                    case KeyEvent.VK_LEFT:
                        if (canMove(fallingShape, Dir.left))
                            move(Dir.left);
                        break;

                    case KeyEvent.VK_RIGHT:
                        if (canMove(fallingShape, Dir.right))
                            move(Dir.right);
                        break;

                    case KeyEvent.VK_DOWN:
                        if (!fastDown) {
                            fastDown = true;
                            while (canMove(fallingShape, Dir.down)) {
                                move(Dir.down);
                                repaint();
                            }
                            shapeHasLanded();
                        }
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                fastDown = false;
            }
        });
    }

    void selectShape() {
        fallingShapeRow = 1;
        fallingShapeCol = 5;
        fallingShape = nextShape;
        Shape[] shapes = Shape.values();
        nextShape = shapes[rand.nextInt(shapes.length)];
        if (fallingShape != null)
            fallingShape.reset();
    }

    void startNewGame() {
        stop();
        initGrid();
        selectShape();
        scoreboard.reset();
        (fallingThread = new Thread(this)).start();
    }

    void stop() {
        if (fallingThread != null) {
            Thread tmp = fallingThread;
            fallingThread = null;
            tmp.interrupt();
        }
    }

    void initGrid() {
        for (int r = 0; r < nRows; r++) {
            Arrays.fill(grid[r], EMPTY);
            for (int c = 0; c < nCols; c++) {
                if (c == 0 || c == nCols - 1 || r == nRows - 1)
                    grid[r][c] = BORDER;
            }
        }
    }

    @Override
   

}

    
