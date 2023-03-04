package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import javax.swing.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        int number = getRandomNumber(10);
        if (gameField[x][y] == 0) {
            if (number < 9) {
                gameField[x][y] = 2;
            } else {
                gameField[x][y] = 4;
            }
        }else{
            createNewNumber();
        }
    }
    private  Color getColorByValue(int value){
        if(value == 0){
            return Color.WHITE;
        } else if (value == 2) {
            return Color.AZURE;
        } else if (value == 4) {
            return Color.AQUA;
        } else if (value == 8) {
            return Color.BEIGE;
        } else if (value == 16) {
            return Color.ALICEBLUE;
        } else if (value == 32) {
            return Color.RED;
        } else if (value == 64) {
            return Color.BISQUE;
        } else if (value == 128) {
            return Color.CORAL;
        } else if (value == 256) {
            return Color.YELLOW;
        } else if (value == 512) {
            return Color.PINK;
        } else if (value == 1024) {
            return Color.FUCHSIA;
        } else if (value == 2048) {
            return Color.LIME;
        }else{
            return Color.NONE;
        }
    }
    private void setCellColoredNumber(int x, int y, int value){
        Color color = getColorByValue(value);
        String string = "";
        if(value > 0){
            string = value + "";
        }
        setCellValueEx(x, y, color, string);
    }
}
//--module-path "C:\MyProjects\JavaRushTasks\lib\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml