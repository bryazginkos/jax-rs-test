package ru.kosdev.train.jaxrs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.controller.api.ImageController;
import ru.kosdev.train.jaxrs.service.api.ImageService;

import java.io.InputStream;

/**
 * Created by kos on 04.06.16.
 */
@Controller
public class ImageControllerImpl implements ImageController {

    @Autowired
    private ImageService fileService;

    @Override
    public String save(InputStream inputStream) {
        return null;
    }

    @Override
    public byte[] get(String imageName) {
        return new byte[0];
    }
}
