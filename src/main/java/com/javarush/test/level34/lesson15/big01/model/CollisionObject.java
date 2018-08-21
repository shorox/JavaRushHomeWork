package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by sharov on 10.03.2016.
 */
public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        switch(direction){
            case LEFT:
                return this.getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY();
            case RIGHT:
                return this.getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && this.getY() == gameObject.getY();
            case UP:
                return this.getX() == gameObject.getX() && this.getY() - Model.FIELD_SELL_SIZE == gameObject.getY();
            case DOWN:
                return this.getX() == gameObject.getX() && this.getY() + Model.FIELD_SELL_SIZE == gameObject.getY();
        }
        return false;
    }
}
