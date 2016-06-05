package ru.kosdev.train.jaxrs.controller.api;

import java.io.InputStream;

/**
 * Created by kos on 04.06.16.
 */
public interface ImageController {

    String save(InputStream inputStream);

    byte[] get(String imageName);
}
