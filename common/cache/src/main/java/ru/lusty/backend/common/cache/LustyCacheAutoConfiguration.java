package ru.lusty.backend.common.cache;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@AutoConfiguration
public class LustyCacheAutoConfiguration {

//    @EnableCaching
    @Configuration
    public static class EnableCachingConfig {

    }

}
