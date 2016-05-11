package ru.kosdev.train.jaxrs.rest;

import java.io.InputStream;

/**
 * Created by kbryazgin on 5/11/2016.
 */
public interface FileManager {

    String save(InputStream inputStream);

    byte[] get(String imageName);
}
