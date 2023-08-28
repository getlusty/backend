package ru.lusty.backend.common.scheduler;

import com.github.kagkarlsson.scheduler.boot.config.DbSchedulerCustomizer;
import com.github.kagkarlsson.scheduler.serializer.JacksonSerializer;
import com.github.kagkarlsson.scheduler.serializer.Serializer;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

import static ru.lusty.backend.common.utils.JsonUtils.mapper;

@AutoConfiguration
public class SchedulerAutoConfiguration {

    @Configuration
    public static class DbSchedulerConfig {

        @Bean
        public DbSchedulerCustomizer dbSchedulerCustomizer() {
            return new DbSchedulerCustomizer() {

                @Override
                public Optional<Serializer> serializer() {
                    return Optional.of(new JacksonSerializer(mapper()));
                }
            };
        }
    }
}
