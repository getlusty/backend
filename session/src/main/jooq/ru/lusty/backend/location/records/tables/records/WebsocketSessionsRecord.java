/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.location.records.tables.records;


import java.time.Instant;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.lusty.backend.location.records.tables.WebsocketSessions;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WebsocketSessionsRecord extends UpdatableRecordImpl<WebsocketSessionsRecord> implements Record5<UUID, UUID, Instant, Instant, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.websocket_sessions.id</code>.
     */
    public WebsocketSessionsRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.websocket_sessions.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.websocket_sessions.user_id</code>.
     */
    public WebsocketSessionsRecord setUserId(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.websocket_sessions.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.websocket_sessions.active_from</code>.
     */
    public WebsocketSessionsRecord setActiveFrom(Instant value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.websocket_sessions.active_from</code>.
     */
    public Instant getActiveFrom() {
        return (Instant) get(2);
    }

    /**
     * Setter for <code>public.websocket_sessions.active_to</code>.
     */
    public WebsocketSessionsRecord setActiveTo(Instant value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.websocket_sessions.active_to</code>.
     */
    public Instant getActiveTo() {
        return (Instant) get(3);
    }

    /**
     * Setter for <code>public.websocket_sessions.device_id</code>.
     */
    public WebsocketSessionsRecord setDeviceId(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.websocket_sessions.device_id</code>.
     */
    public String getDeviceId() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, UUID, Instant, Instant, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, UUID, Instant, Instant, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return WebsocketSessions.WEBSOCKET_SESSIONS.ID;
    }

    @Override
    public Field<UUID> field2() {
        return WebsocketSessions.WEBSOCKET_SESSIONS.USER_ID;
    }

    @Override
    public Field<Instant> field3() {
        return WebsocketSessions.WEBSOCKET_SESSIONS.ACTIVE_FROM;
    }

    @Override
    public Field<Instant> field4() {
        return WebsocketSessions.WEBSOCKET_SESSIONS.ACTIVE_TO;
    }

    @Override
    public Field<String> field5() {
        return WebsocketSessions.WEBSOCKET_SESSIONS.DEVICE_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public UUID component2() {
        return getUserId();
    }

    @Override
    public Instant component3() {
        return getActiveFrom();
    }

    @Override
    public Instant component4() {
        return getActiveTo();
    }

    @Override
    public String component5() {
        return getDeviceId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public UUID value2() {
        return getUserId();
    }

    @Override
    public Instant value3() {
        return getActiveFrom();
    }

    @Override
    public Instant value4() {
        return getActiveTo();
    }

    @Override
    public String value5() {
        return getDeviceId();
    }

    @Override
    public WebsocketSessionsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public WebsocketSessionsRecord value2(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public WebsocketSessionsRecord value3(Instant value) {
        setActiveFrom(value);
        return this;
    }

    @Override
    public WebsocketSessionsRecord value4(Instant value) {
        setActiveTo(value);
        return this;
    }

    @Override
    public WebsocketSessionsRecord value5(String value) {
        setDeviceId(value);
        return this;
    }

    @Override
    public WebsocketSessionsRecord values(UUID value1, UUID value2, Instant value3, Instant value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WebsocketSessionsRecord
     */
    public WebsocketSessionsRecord() {
        super(WebsocketSessions.WEBSOCKET_SESSIONS);
    }

    /**
     * Create a detached, initialised WebsocketSessionsRecord
     */
    public WebsocketSessionsRecord(UUID id, UUID userId, Instant activeFrom, Instant activeTo, String deviceId) {
        super(WebsocketSessions.WEBSOCKET_SESSIONS);

        setId(id);
        setUserId(userId);
        setActiveFrom(activeFrom);
        setActiveTo(activeTo);
        setDeviceId(deviceId);
        resetChangedOnNotNull();
    }
}
