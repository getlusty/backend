/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.location.records.tables.records;


import java.time.Instant;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ru.lusty.backend.location.records.tables.DeviceLocations;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeviceLocationsRecord extends UpdatableRecordImpl<DeviceLocationsRecord> implements Record6<UUID, String, UUID, Double, Double, Instant> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.device_locations.id</code>.
     */
    public DeviceLocationsRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.device_locations.device_id</code>.
     */
    public DeviceLocationsRecord setDeviceId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.device_id</code>.
     */
    public String getDeviceId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.device_locations.user_id</code>.
     */
    public DeviceLocationsRecord setUserId(UUID value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(2);
    }

    /**
     * Setter for <code>public.device_locations.latitude</code>.
     */
    public DeviceLocationsRecord setLatitude(Double value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.latitude</code>.
     */
    public Double getLatitude() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.device_locations.longitude</code>.
     */
    public DeviceLocationsRecord setLongitude(Double value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.longitude</code>.
     */
    public Double getLongitude() {
        return (Double) get(4);
    }

    /**
     * Setter for <code>public.device_locations.created_at</code>.
     */
    public DeviceLocationsRecord setCreatedAt(Instant value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.device_locations.created_at</code>.
     */
    public Instant getCreatedAt() {
        return (Instant) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, String, UUID, Double, Double, Instant> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<UUID, String, UUID, Double, Double, Instant> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return DeviceLocations.DEVICE_LOCATIONS.ID;
    }

    @Override
    public Field<String> field2() {
        return DeviceLocations.DEVICE_LOCATIONS.DEVICE_ID;
    }

    @Override
    public Field<UUID> field3() {
        return DeviceLocations.DEVICE_LOCATIONS.USER_ID;
    }

    @Override
    public Field<Double> field4() {
        return DeviceLocations.DEVICE_LOCATIONS.LATITUDE;
    }

    @Override
    public Field<Double> field5() {
        return DeviceLocations.DEVICE_LOCATIONS.LONGITUDE;
    }

    @Override
    public Field<Instant> field6() {
        return DeviceLocations.DEVICE_LOCATIONS.CREATED_AT;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getDeviceId();
    }

    @Override
    public UUID component3() {
        return getUserId();
    }

    @Override
    public Double component4() {
        return getLatitude();
    }

    @Override
    public Double component5() {
        return getLongitude();
    }

    @Override
    public Instant component6() {
        return getCreatedAt();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getDeviceId();
    }

    @Override
    public UUID value3() {
        return getUserId();
    }

    @Override
    public Double value4() {
        return getLatitude();
    }

    @Override
    public Double value5() {
        return getLongitude();
    }

    @Override
    public Instant value6() {
        return getCreatedAt();
    }

    @Override
    public DeviceLocationsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord value2(String value) {
        setDeviceId(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord value3(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord value4(Double value) {
        setLatitude(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord value5(Double value) {
        setLongitude(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord value6(Instant value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public DeviceLocationsRecord values(UUID value1, String value2, UUID value3, Double value4, Double value5, Instant value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeviceLocationsRecord
     */
    public DeviceLocationsRecord() {
        super(DeviceLocations.DEVICE_LOCATIONS);
    }

    /**
     * Create a detached, initialised DeviceLocationsRecord
     */
    public DeviceLocationsRecord(UUID id, String deviceId, UUID userId, Double latitude, Double longitude, Instant createdAt) {
        super(DeviceLocations.DEVICE_LOCATIONS);

        setId(id);
        setDeviceId(deviceId);
        setUserId(userId);
        setLatitude(latitude);
        setLongitude(longitude);
        setCreatedAt(createdAt);
        resetChangedOnNotNull();
    }
}