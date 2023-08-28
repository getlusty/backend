package ru.lusty.backend.filestore.local;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.lusty.backend.filestore.api.ReadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RequiredArgsConstructor
public class LocalReadFile implements ReadFile {
    private final File file;

    @SneakyThrows
    @Override
    public InputStream getInputStream() {
        return new FileInputStream(file);
    }
}
