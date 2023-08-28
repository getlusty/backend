package ru.lusty.backend.profile;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.replicatedmap.ReplicatedMap;
import org.springframework.stereotype.Component;
import ru.lusty.backend.common.utils.ClockUtils;
import ru.lusty.backend.profile.api.FreshProfileApi;
import ru.lusty.backend.profile.api.ProfileDto;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class FreshProfilesCache implements FreshProfileApi {
    private final ReplicatedMap<UUID, ProfileDto> freshProfiles;

    public FreshProfilesCache(HazelcastInstance hazelcastInstance) {
        this.freshProfiles = hazelcastInstance.getReplicatedMap("freshProfiles");
    }

    public void addFreshProfile(ProfileDto profile) {
        freshProfiles.put(profile.getId(), profile, 1, TimeUnit.DAYS);
    }

    public void updateFreshProfile(ProfileDto profile) {
        final var now = ClockUtils.now();
        final var aliveDuration = Duration.between(profile.getCreatedAt(), now);
        if (aliveDuration.compareTo(Duration.ofDays(1)) >= 0) {
            return;
        }
        final var left = Duration.ofDays(1).minus(aliveDuration);
        freshProfiles.put(profile.getId(), profile, left.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public Collection<ProfileDto> getFreshProfiles() {
        return freshProfiles.values();
    }
}
