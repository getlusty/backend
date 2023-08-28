package ru.lusty.backend.filestore.api;

import java.io.InputStream;
import java.util.UUID;

public interface FileStoreApi {

    UUID write(InputStream content);

    ReadFile read(UUID id);

    String getUrl(UUID id);
}
