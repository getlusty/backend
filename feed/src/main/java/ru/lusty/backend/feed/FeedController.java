//package ru.lusty.backend.feed;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import ru.lusty.auth.api.service.AuthService;
//import ru.lusty.backend.feed.chain.FeedProfileChain;
//
//@RestController
//@RequiredArgsConstructor
//public class FeedController {
//    private final AuthService authService;
//    private final FeedProfileChain feedProfileChain;
//
//    @PostMapping("/feed")
//    public FeedProfilesResponse getFeedProfiles(@RequestBody FeedProfilesRequest request) {
//        final var user = authService.getAuthenticated();
//        var profileDtos = feedProfileChain.getFeed(user.id(), request, 10);
//        return new FeedProfilesResponse(profileDtos);
//    }
//}
