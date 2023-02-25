package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE ,SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){

    }

    private void drawScene(){
        for (int y = 0; y < gameField.length; y++){
            for(int x = 0; x < gameField[y].length; x++){
                setCellColor(x,y,Color.BLUE);
            }
        }
    }

    private void createNewNumber(){
       int x = getRandomNumber(SIDE);
       int y = getRandomNumber(SIDE);
       int number = getRandomNumber(10);
    }
}
//--module-path "C:\MyProjects\JavaRushTasks\lib\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml