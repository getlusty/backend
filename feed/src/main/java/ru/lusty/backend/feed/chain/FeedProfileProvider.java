package ru.lusty.backend.feed.chain;

import ru.lusty.backend.profile.api.ProfileDto;

import java.util.List;

public interface FeedProfileProvider {

    List<ProfileDto> getProfiles(FeedProfileChainContext context, int limit);

    void enrichIfRequired(FeedProfileChainContext context);
}
