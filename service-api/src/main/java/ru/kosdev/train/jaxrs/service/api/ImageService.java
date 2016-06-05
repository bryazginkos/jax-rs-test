package ru.kosdev.train.jaxrs.service.api;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by kbryazgin on 5/11/2016.
 */
public interface ImageService {

    String save(InputStream inputStream);

    byte[] get(String imageName) throws FileNotFoundException;
}
