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
    
    
    int getSpeed() {

        switch (level) {
            case 0:
                return 700;
            case 1:
                return 600;
            case 2:
                return 500;
            case 3:
                return 400;
            case 4:
                return 350;
            case 5:
                return 300;
            case 6:
                return 250;
            case 7:
                return 200;
            case 8:
                return 150;
            case 9:
                return 100;
            default:
                return 100;
        }
    }
     
     void addScore(int sc) {
        score += sc;
    }


    
}

