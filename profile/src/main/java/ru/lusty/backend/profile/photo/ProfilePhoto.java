package ru.lusty.backend.profile.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePhoto {
    private UUID profileId;
    private UUID fileId;
    private int priority;

}
