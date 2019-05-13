package com.company;

class Scoreboard {
    static final int MAXLEVEL = 9;

    private int level;
    private int lines;
    private int score;
    private int topscore;
    private boolean gameOver = true;

    void reset() {
        setTopscore();
        level = lines = score = 0;
        gameOver = false;
    }

    void setGameOver() {
        gameOver = true;
    }

    boolean isGameOver() {
        return gameOver;
    }

    
    void setTopscore() {
        if (score > topscore)
            topscore = score;
    }

    int getTopscore() {
        return topscore;
    }

    
}

