package ru.lusty.backend.filestore.s3;

import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import ru.lusty.backend.filestore.api.ReadFile;

import java.io.InputStream;

@RequiredArgsConstructor
public class S3ReadFile implements ReadFile {
    private final S3Object s3Object;

    @Override
    public InputStream getInputStream() {
        return s3Object.getObjectContent();
    }
}
