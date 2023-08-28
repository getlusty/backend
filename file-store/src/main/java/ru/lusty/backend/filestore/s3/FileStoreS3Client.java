package ru.lusty.backend.filestore.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.lusty.backend.filestore.api.FileStoreApi;
import ru.lusty.backend.filestore.api.ReadFile;

import java.io.InputStream;
import java.util.UUID;

import static ru.lusty.backend.common.utils.IOUtils.closeQuietly;

@Profile("prod")
@Component
@RequiredArgsConstructor
public class FileStoreS3Client implements FileStoreApi {

    private final AmazonS3 s3;
    @Value("${bucketName:global}")
    private String bucketName;

    @Override
    public UUID write(InputStream content) {
        final var key = UUID.randomUUID();
        s3.putObject(bucketName, key.toString(), content, new ObjectMetadata());
        closeQuietly(content);
        return key;
    }

    @Override
    public ReadFile read(UUID id) {
        final var object = s3.getObject(bucketName, id.toString());
        return new S3ReadFile(object);
    }

    @Override
    public String getUrl(UUID id) {
        return "" + id;
    }

}
