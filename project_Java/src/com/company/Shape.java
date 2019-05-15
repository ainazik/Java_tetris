package com.company;

import java.awt.*;

enum Shape {
    ZShape(new int[][]{{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}),
    SShape(new int[][]{{0, -1}, {0, 0}, {1, 0}, {1, 1}}),
    IShape(new int[][]{{0, -1}, {0, 0}, {0, 1}, {0, 2}}),
    TShape(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {0, 1}}),
    Square(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}),
    LShape(new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}}),
    JShape(new int[][]{{1, -1}, {0, -1}, {0, 0}, {0, 1}});
    
        private Shape(int[][] shape) {
        this.shape = shape;
        pos = new int[4][2];
        reset();
    }

    void reset() {
        for (int i = 0; i < pos.length; i++) {
            pos[i] = shape[i].clone();
        }
    }

    final int[][] pos, shape;
   
}

 final class Config {
    final static Color[] colors = {Color.green, Color.red, Color.blue,
            Color.pink, Color.orange, Color.cyan, Color.magenta};

    final static Font mainFont = new Font("Monospaced", Font.BOLD, 48);
    final static Font smallFont = mainFont.deriveFont(Font.BOLD, 18);

    final static Dimension dim = new Dimension(640, 640);

    final static Rectangle gridRect = new Rectangle(46, 47, 308, 517);
    final static Rectangle previewRect = new Rectangle(387, 47, 200, 200);
    final static Rectangle titleRect = new Rectangle(100, 85, 252, 100);
    final static Rectangle clickRect = new Rectangle(50, 375, 252, 40);
    
    

   
}

