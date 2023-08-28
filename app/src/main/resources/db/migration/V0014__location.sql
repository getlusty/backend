CREATE MATERIALIZED VIEW device_last_locations AS
SELECT DISTINCT ON (device_id)
    id,
    device_id,
    user_id,
    latitude,
    longitude,
    created_at
FROM device_locations
ORDER BY device_id, created_at DESC;

CREATE INDEX idx_device_last_locations_device_id ON device_last_locations (device_id);
CREATE INDEX idx_device_last_locations_user_id ON device_last_locations (user_id);