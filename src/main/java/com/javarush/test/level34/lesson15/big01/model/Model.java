package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Бабуин on 10.03.2016.
 */
public class Model {
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src/com/javarush/com.javarush.test/level34/lesson15/big01/res/levels.txt"));

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction){
        if(checkWallCollision(gameObjects.getPlayer(), direction) || checkBoxCollision(direction)) return;
        switch(direction){
            case LEFT:
                gameObjects.getPlayer().setX(gameObjects.getPlayer().getX() - Model.FIELD_SELL_SIZE);
                break;
            case RIGHT:
                gameObjects.getPlayer().setX(gameObjects.getPlayer().getX() + Model.FIELD_SELL_SIZE);
                break;
            case UP:
                gameObjects.getPlayer().setY(gameObjects.getPlayer().getY() - Model.FIELD_SELL_SIZE);
                break;
            case DOWN:
                gameObjects.getPlayer().setY(gameObjects.getPlayer().getY() + Model.FIELD_SELL_SIZE);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall wall : gameObjects.getWalls())
            if(gameObject.isCollision(wall, direction)) return true;
        return false;
    }

    public boolean checkBoxCollision(Direction direction){
        for(GameObject obj : gameObjects.getAll())
            if(gameObjects.getPlayer().isCollision(obj, direction)){
                if(obj instanceof Wall) return true;
                else if(obj instanceof Box){
                    Box box = (Box) obj;
                    if(checkWallCollision(box, direction)) return true;
                    for(Box b : gameObjects.getBoxes())
                        if(box.isCollision(b, direction)) return true;
                    switch(direction){
                        case LEFT:
                            box.setX(box.getX() - Model.FIELD_SELL_SIZE);
                            break;
                        case RIGHT:
                            box.setX(box.getX() + Model.FIELD_SELL_SIZE);
                            break;
                        case UP:
                            box.setY(box.getY() - Model.FIELD_SELL_SIZE);
                            break;
                        case DOWN:
                            box.setY(box.getY() + Model.FIELD_SELL_SIZE);
                            break;
                    }
                }
                return false;
            }
        return false;
    }

    public void checkCompletion(){
        for(Home home : gameObjects.getHomes()){
            boolean isCoords = false;
            for(Box box : gameObjects.getBoxes())
                if(home.getX() == box.getX() && home.getY() == box.getY()) isCoords = true;
            if(!isCoords) return;
        }
        eventListener.levelCompleted(currentLevel);
    }
}
