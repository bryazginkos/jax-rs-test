package ru.kosdev.train.jaxrs.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.controller.api.ImageController;
import ru.kosdev.train.jaxrs.rest.api.ImageResource;

import java.io.InputStream;

/**
 * Created by kbryazgin on 5/12/2016.
 */
@Controller
public class ImageResourceImpl implements ImageResource {

    @Autowired
    private ImageController imageController;

    @Override
    public String uploadImage(final InputStream inputStream) {
        return imageController.save(inputStream);
    }

    @Override
    public byte[] loadImage(final String imageName) {
        return imageController.get(imageName);
    }
}
