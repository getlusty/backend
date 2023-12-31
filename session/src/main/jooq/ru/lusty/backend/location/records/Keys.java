/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.location.records;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.lusty.backend.location.records.tables.WebsocketSessions;
import ru.lusty.backend.location.records.tables.records.WebsocketSessionsRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<WebsocketSessionsRecord> WEBSOCKET_SESSIONS_PKEY = Internal.createUniqueKey(WebsocketSessions.WEBSOCKET_SESSIONS, DSL.name("websocket_sessions_pkey"), new TableField[] { WebsocketSessions.WEBSOCKET_SESSIONS.ID }, true);
}
