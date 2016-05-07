package ru.kosdev.train.jaxrs.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.kosdev.train.jaxrs.service.api.contract.UserService;
import ru.kosdev.train.jaxrs.service.services.UserServiceImpl;

/**
 * Created by Константин on 07.05.2016.
 */
@Configuration
@ComponentScan(basePackages = {"ru.kosdev.train.jaxrs.service.converters"})
@Import(value = {ru.kosdev.train.jaxrs.repository.config.SpringConfig.class})
public class SpringConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
