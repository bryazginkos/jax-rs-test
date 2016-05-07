package ru.kosdev.train.jaxrs.service;

import ru.kosdev.train.jaxrs.api.UserService;

/**
 * Created by Константин on 07.05.2016.
 */
public class UserServiceImpl implements UserService {

    @Override
    public String someString() {
        return "UserServiceImpl hello";
    }
}
