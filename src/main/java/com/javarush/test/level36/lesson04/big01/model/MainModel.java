package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by sharov on 15.03.2016.
 */
public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(refreshActiveUsers());
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id){
        userService.deleteUser(id);
    }

    private List<User> refreshActiveUsers() {
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        for (int i = 0; i < users.size(); ) {
            if (users.get(i).getName().endsWith("(deleted)")) users.remove(i);
            else i++;
        }
        return users;
    }

    @Override
    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
    }
}
