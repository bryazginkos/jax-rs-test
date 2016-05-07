package ru.kosdev.train.jaxrs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kosdev.train.jaxrs.api.UserService;
import ru.kosdev.train.jaxrs.service.UserServiceImpl;

/**
 * Created by Константин on 07.05.2016.
 */
@Configuration
public class SpringConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
