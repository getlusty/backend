package ru.lusty.backend.feed.chain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.lusty.backend.feed.FeedProfilesRequest;
import ru.lusty.backend.feed.Match;
import ru.lusty.backend.feed.MatchRepository;
import ru.lusty.backend.profile.api.ProfileDto;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static ru.lusty.backend.common.utils.ClockUtils.now;

@Component
@RequiredArgsConstructor
public class FeedProfileChain {
    private final MatchRepository matchRepository;
    private final List<FeedProfileProvider> profileProviders;

    public List<ProfileDto> getFeed(UUID userId, FeedProfilesRequest request, int limit) {
        final var historicalMatches = matchRepository.findAllByAuthorSince(userId, now().minus(1, ChronoUnit.WEEKS), 500)
            .stream()
            .map(Match::getAuthorId)
            .collect(Collectors.toSet());
        final var context = prepareContext(userId, request);
        final List<ProfileDto> result = new ArrayList<>();
        for (FeedProfileProvider profileProvider : profileProviders) {
            profileProvider.enrichIfRequired(context);
            if (result.size() == limit) {
                break;
            }
            final var profiles = profileProvider.getProfiles(context, limit - result.size())
                    .stream()
                    .filter(p -> !historicalMatches.contains(p.getId()))
                    .toList();
            result.addAll(profiles);
        }
        return result;
    }

    private FeedProfileChainContext prepareContext(UUID userId, FeedProfilesRequest request) {
        return new FeedProfileChainContext(userId, request);
    }
}
