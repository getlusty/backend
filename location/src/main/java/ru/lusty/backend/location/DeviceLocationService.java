package ru.lusty.backend.location;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceLocationService {
    private final DeviceLocationRepository deviceLocationRepository;

    public void saveDeviceLocation(DeviceLocation deviceLocation) {
        deviceLocationRepository.insert(deviceLocation);
    }

}
