package ru.lusty.backend.common.utils;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {

    public static void closeQuietly(InputStream stream) {
        try {
            stream.close();
        } catch (IOException e) {

        }
    }

}
