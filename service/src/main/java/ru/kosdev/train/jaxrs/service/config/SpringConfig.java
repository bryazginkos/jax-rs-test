package ru.kosdev.train.jaxrs.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.kosdev.train.jaxrs.service.api.contract.FileManager;
import ru.kosdev.train.jaxrs.service.api.contract.ContactService;
import ru.kosdev.train.jaxrs.service.aspects.ServiceAspect;
import ru.kosdev.train.jaxrs.service.services.FileManagerImpl;
import ru.kosdev.train.jaxrs.service.services.ContactServiceImpl;

/**
 * Created by Константин on 07.05.2016.
 */
@Configuration
@ComponentScan(basePackages = {"ru.kosdev.train.jaxrs.service.converters" })
@Import(ru.kosdev.train.jaxrs.repository.config.SpringConfig.class)
public class SpringConfig {

    @Bean
    public ContactService contactService() {
        return new ContactServiceImpl();
    }

    @Bean
    public FileManager fileManager() {
        return new FileManagerImpl();
    }

    @Bean
    public ServiceAspect serviceAspect() {
        return new ServiceAspect();
    }
}
