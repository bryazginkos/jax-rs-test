package ru.kosdev.train.jaxrs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.common.MessageCode;
import ru.kosdev.train.jaxrs.controller.api.ImageController;
import ru.kosdev.train.jaxrs.controller.api.ImageNotFoundException;
import ru.kosdev.train.jaxrs.controller.api.NotFoundException;
import ru.kosdev.train.jaxrs.service.api.ImageService;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by kos on 04.06.16.
 */
@Controller
public class ImageControllerImpl implements ImageController {

    @Autowired
    private ImageService fileService;

    @Override
    public String save(final InputStream inputStream) {
        return fileService.save(inputStream);
    }

    @Override
    public byte[] get(final String imageName) {
        try {
            return fileService.get(imageName);
        } catch (FileNotFoundException e) {
            throw new ImageNotFoundException();
        }
    }
}
