/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.location.records.tables;


import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.lusty.backend.common.jooq.JooqInstantConverter;
import ru.lusty.backend.location.records.Indexes;
import ru.lusty.backend.location.records.Keys;
import ru.lusty.backend.location.records.Public;
import ru.lusty.backend.location.records.tables.records.DeviceLocationsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DeviceLocations extends TableImpl<DeviceLocationsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.device_locations</code>
     */
    public static final DeviceLocations DEVICE_LOCATIONS = new DeviceLocations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DeviceLocationsRecord> getRecordType() {
        return DeviceLocationsRecord.class;
    }

    /**
     * The column <code>public.device_locations.id</code>.
     */
    public final TableField<DeviceLocationsRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.device_locations.device_id</code>.
     */
    public final TableField<DeviceLocationsRecord, String> DEVICE_ID = createField(DSL.name("device_id"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.device_locations.user_id</code>.
     */
    public final TableField<DeviceLocationsRecord, UUID> USER_ID = createField(DSL.name("user_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.device_locations.latitude</code>.
     */
    public final TableField<DeviceLocationsRecord, Double> LATITUDE = createField(DSL.name("latitude"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>public.device_locations.longitude</code>.
     */
    public final TableField<DeviceLocationsRecord, Double> LONGITUDE = createField(DSL.name("longitude"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>public.device_locations.created_at</code>.
     */
    public final TableField<DeviceLocationsRecord, Instant> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("now()"), SQLDataType.LOCALDATETIME)), this, "", new JooqInstantConverter());

    private DeviceLocations(Name alias, Table<DeviceLocationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private DeviceLocations(Name alias, Table<DeviceLocationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.device_locations</code> table reference
     */
    public DeviceLocations(String alias) {
        this(DSL.name(alias), DEVICE_LOCATIONS);
    }

    /**
     * Create an aliased <code>public.device_locations</code> table reference
     */
    public DeviceLocations(Name alias) {
        this(alias, DEVICE_LOCATIONS);
    }

    /**
     * Create a <code>public.device_locations</code> table reference
     */
    public DeviceLocations() {
        this(DSL.name("device_locations"), null);
    }

    public <O extends Record> DeviceLocations(Table<O> child, ForeignKey<O, DeviceLocationsRecord> key) {
        super(child, key, DEVICE_LOCATIONS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.DEVICE_LOCATIONS_LAT_LNG, Indexes.DEVICE_LOCATIONS_USER_ID_CREATED_AT);
    }

    @Override
    public UniqueKey<DeviceLocationsRecord> getPrimaryKey() {
        return Keys.DEVICE_LOCATIONS_PKEY;
    }

    @Override
    public DeviceLocations as(String alias) {
        return new DeviceLocations(DSL.name(alias), this);
    }

    @Override
    public DeviceLocations as(Name alias) {
        return new DeviceLocations(alias, this);
    }

    @Override
    public DeviceLocations as(Table<?> alias) {
        return new DeviceLocations(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public DeviceLocations rename(String name) {
        return new DeviceLocations(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DeviceLocations rename(Name name) {
        return new DeviceLocations(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public DeviceLocations rename(Table<?> name) {
        return new DeviceLocations(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UUID, String, UUID, Double, Double, Instant> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super UUID, ? super String, ? super UUID, ? super Double, ? super Double, ? super Instant, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super UUID, ? super String, ? super UUID, ? super Double, ? super Double, ? super Instant, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
