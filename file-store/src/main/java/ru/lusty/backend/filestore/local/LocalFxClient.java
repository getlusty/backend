package ru.lusty.backend.filestore.local;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.lusty.backend.filestore.api.FileStoreApi;
import ru.lusty.backend.filestore.api.ReadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import static com.amazonaws.util.IOUtils.copy;
import static ru.lusty.backend.common.utils.IOUtils.closeQuietly;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class LocalFxClient implements FileStoreApi {

    @Value("${fs.path:./fs}")
    private String path;

    @SneakyThrows
    @Override
    public UUID write(InputStream content) {
        final var key = UUID.randomUUID();
        var file = new File(path + "/" + key);
        file.createNewFile();
        try (var fileStream = new FileOutputStream(file)) {
            copy(content, fileStream);
        }
        closeQuietly(content);
        return key;
    }

    @Override
    public ReadFile read(UUID id) {
        return new LocalReadFile(new File(path + "/" + id));
    }

    @Override
    public String getUrl(UUID id) {
        return "" + id;
    }

}
