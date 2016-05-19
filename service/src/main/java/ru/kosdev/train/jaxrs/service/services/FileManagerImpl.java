package ru.kosdev.train.jaxrs.service.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.common.exception.ServiceException;
import ru.kosdev.train.jaxrs.service.api.contract.FileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Service
public class FileManagerImpl implements FileManager {

    @Value("${images.dir}")
    private String imagesPath;

    @Override
    public String save(final InputStream inputStream) {
        final UUID filename = UUID.randomUUID();
        try {
            Files.copy(inputStream, Paths.get(imagesPath + filename));
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
        return filename.toString();
    }

    @Override
    public byte[] get(final String imageName) throws FileNotFoundException {
        Path path = Paths.get(imagesPath + imageName);

        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }

        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
