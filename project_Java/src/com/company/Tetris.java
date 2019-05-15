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
    
    }
}

    
