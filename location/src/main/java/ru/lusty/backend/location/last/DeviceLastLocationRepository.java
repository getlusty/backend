package ru.lusty.backend.location.last;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.jooq.JooqRepository;
import ru.lusty.backend.location.DeviceLocation;
import ru.lusty.backend.location.records.tables.DeviceLastLocations;
import ru.lusty.backend.location.records.tables.records.DeviceLastLocationsRecord;

import java.util.UUID;

import static ru.lusty.backend.location.records.tables.DeviceLastLocations.DEVICE_LAST_LOCATIONS;

@Component
public class DeviceLastLocationRepository extends JooqRepository<UUID, DeviceLocation, DeviceLastLocationsRecord, DeviceLastLocations> {

    @Override
    protected DeviceLocation fromRecord(DeviceLastLocationsRecord record) {
        return new DeviceLocation(record.getId(), record.getUserId(), record.getLatitude(), record.getLongitude(), record.getDeviceId(), record.getCreatedAt());
    }

    @Override
    protected DeviceLastLocations table() {
        return DEVICE_LAST_LOCATIONS;
    }
}
