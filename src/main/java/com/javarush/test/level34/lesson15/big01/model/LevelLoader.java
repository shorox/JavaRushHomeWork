package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharov on 10.03.2016.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level){
        try(BufferedReader r = new BufferedReader(new FileReader(levels.toFile()))) {
            while(!r.readLine().equals("Maze: " + (level % 60 == 0 ? 60 : level % 60)));
            r.readLine();
            r.readLine();
            r.readLine();
            r.readLine();
            r.readLine();
            r.readLine();

            Set<Wall> walls = new HashSet<>();
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Player player = null;

            int y = Model.FIELD_SELL_SIZE / 2;
            for(String s = r.readLine(); !s.equals(""); s = r.readLine()){
                int x = Model.FIELD_SELL_SIZE / 2;
                for(char ch : s.toCharArray()){
                    switch (ch){
                        case 'X' :
                            walls.add(new Wall(x, y));
                            break;
                        case '*' :
                            boxes.add(new Box(x, y));
                            break;
                        case '.' :
                            homes.add(new Home(x, y));
                            break;
                        case '&' :
                            boxes.add(new Box(x, y));
                            homes.add(new Home(x, y));
                            break;
                        case '@' :
                            player = new Player(x, y);
                            break;
                    }
                    x += Model.FIELD_SELL_SIZE;
                }
                y += Model.FIELD_SELL_SIZE;
            }
            return new GameObjects(walls, boxes, homes, player);
        }catch (Exception e){
            return null;
        }
    }
}
