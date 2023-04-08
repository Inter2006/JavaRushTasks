package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import javax.swing.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;


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
        int max = getMaxTileValue();
        if (max == 2048) {
            win();
        }
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        int number = getRandomNumber(10);
        if (gameField[x][y] == 0) {
            if (number < 9) {
                gameField[x][y] = 2;
            } else {
                gameField[x][y] = 4;
            }
        } else {
            createNewNumber();
        }
    }

    private Color getColorByValue(int value) {
        if (value == 0) {
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
        } else {
            return Color.NONE;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String string = "";
        if (value > 0) {
            string = value + "";
        }
        setCellValueEx(x, y, color, string);
    }

    private boolean compressRow(int[] row) {
        int index = 0;
        boolean result = false;
        for (int x = 0; x < row.length; x++) {
            if (row[x] > 0) {
                if (x != index) {
                    row[index] = row[x];
                    row[x] = 0;
                    result = true;
                }
                index++;
            }
        }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] = row[i] + row[i + 1];
                row[i + 1] = 0;
                result = true;
            }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        } else if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        } else if (key == Key.UP) {
            moveUp();
            drawScene();
        } else if (key == Key.DOWN) {
            moveDown();
            drawScene();
        }

    }

    private void moveLeft() {
        boolean isMotion = false;

        for (int[] ints : gameField) {
            if (compressRow(ints) | mergeRow(ints) | compressRow(ints)) {
                isMotion = true;
            }
        }
        if (isMotion) {
            createNewNumber();
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] newGameField = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                newGameField[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = newGameField;
    }

    private int getMaxTileValue() {
        int max = gameField[0][0];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] > max) {
                    max = gameField[i][j];
                }
            }

        }
        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.NONE, "Победа!Вы победитель!", Color.BLACK, 75);
    }

    private boolean canUserMove() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                } else if (j < gameField[i].length - 1 && gameField[i][j] == gameField[i][j + 1]) {
                    return true;
                } else if (i < gameField.length - 1 && gameField[i][j] == gameField[i + 1][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
//--module-path "C:\MyProjects\JavaRushTasks\lib\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml