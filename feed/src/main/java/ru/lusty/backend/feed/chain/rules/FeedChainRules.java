package ru.lusty.backend.feed.chain.rules;

import lombok.Data;

import java.util.List;

@Data
public class FeedChainRules {
    private List<FeedChainRule> rules;

}
