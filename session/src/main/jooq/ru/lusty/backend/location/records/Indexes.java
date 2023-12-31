/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.location.records;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.lusty.backend.location.records.tables.WebsocketSessions;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index IDX_WEBSOCKET_SESSIONS_ACTIVE_TO = Internal.createIndex(DSL.name("idx_websocket_sessions_active_to"), WebsocketSessions.WEBSOCKET_SESSIONS, new OrderField[] { WebsocketSessions.WEBSOCKET_SESSIONS.ACTIVE_TO }, false);
    public static final Index IDX_WEBSOCKET_SESSIONS_USER_ID = Internal.createIndex(DSL.name("idx_websocket_sessions_user_id"), WebsocketSessions.WEBSOCKET_SESSIONS, new OrderField[] { WebsocketSessions.WEBSOCKET_SESSIONS.USER_ID }, false);
}
