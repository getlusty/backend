package ru.lusty.backend.feed.chain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.feed.FeedProfilesRequest;
import ru.lusty.backend.feed.Match;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedProfileChainContext {
    private UUID userId;
    private FeedProfilesRequest request;

}
