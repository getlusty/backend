/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.adminnotifier.records.tables.records;


import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import ru.lusty.backend.adminnotifier.records.tables.AdminTgChats;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AdminTgChatsRecord extends UpdatableRecordImpl<AdminTgChatsRecord> implements Record2<UUID, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.admin_tg_chats.id</code>.
     */
    public AdminTgChatsRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.admin_tg_chats.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.admin_tg_chats.chat_id</code>.
     */
    public AdminTgChatsRecord setChatId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.admin_tg_chats.chat_id</code>.
     */
    public String getChatId() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<UUID, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<UUID, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return AdminTgChats.ADMIN_TG_CHATS.ID;
    }

    @Override
    public Field<String> field2() {
        return AdminTgChats.ADMIN_TG_CHATS.CHAT_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getChatId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getChatId();
    }

    @Override
    public AdminTgChatsRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public AdminTgChatsRecord value2(String value) {
        setChatId(value);
        return this;
    }

    @Override
    public AdminTgChatsRecord values(UUID value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AdminTgChatsRecord
     */
    public AdminTgChatsRecord() {
        super(AdminTgChats.ADMIN_TG_CHATS);
    }

    /**
     * Create a detached, initialised AdminTgChatsRecord
     */
    public AdminTgChatsRecord(UUID id, String chatId) {
        super(AdminTgChats.ADMIN_TG_CHATS);

        setId(id);
        setChatId(chatId);
        resetChangedOnNotNull();
    }
}
