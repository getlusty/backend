package ru.lusty.backend.location;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;
import ru.lusty.backend.location.records.tables.DeviceLocations;
import ru.lusty.backend.location.records.tables.records.DeviceLocationsRecord;

import java.util.UUID;

import static ru.lusty.backend.location.records.tables.DeviceLocations.DEVICE_LOCATIONS;

@Component
public class DeviceLocationRepository extends JooqUpdatableRepository<UUID, DeviceLocation, DeviceLocationsRecord, DeviceLocations> {

    @Override
    protected DeviceLocationsRecord toRecord(DeviceLocation model) {
        return new DeviceLocationsRecord(model.getId(), model.getDeviceId(), model.getUserId(), model.getLatitude(),
            model.getLongitude(), model.getCreatedAt());
    }

    @Override
    protected DeviceLocation fromRecord(DeviceLocationsRecord record) {
        return new DeviceLocation(record.getId(), record.getUserId(), record.getLatitude(), record.getLongitude(),
            record.getDeviceId(), record.getCreatedAt());
    }

    @Override
    protected DeviceLocations table() {
        return DEVICE_LOCATIONS;
    }
}
