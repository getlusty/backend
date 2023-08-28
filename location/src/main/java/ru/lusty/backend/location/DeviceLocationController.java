package ru.lusty.backend.location;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lusty.backend.common.web.BaseController;

import java.util.UUID;

import static ru.lusty.backend.common.utils.ClockUtils.now;

@RestController
@RequiredArgsConstructor
public class DeviceLocationController extends BaseController {
    private final DeviceLocationService deviceLocationService;

    @PostMapping("/device/location")
    public void recordDeviceLocation(RecordDeviceLocationRequest request) {
        var user = authService.getAuthenticated();
        deviceLocationService.saveDeviceLocation(new DeviceLocation(UUID.randomUUID(), user.id(), request.getLatitude(),
            request.getLongitude(), user.deviceId(), now()));
    }
}
