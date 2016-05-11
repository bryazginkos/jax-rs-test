package ru.kosdev.train.jaxrs.rest.filemanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.rest.exceptions.ServiceException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
    public byte[] get(final String imageName) {
        try {
            final BufferedImage image = ImageIO.read(new File(imagesPath + imageName));
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
