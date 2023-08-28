/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.common.broker;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.lusty.backend.common.broker.tables.OutgoingMessages;
import ru.lusty.backend.common.broker.tables.records.OutgoingMessagesRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<OutgoingMessagesRecord> OUTGOING_MESSAGES_PKEY = Internal.createUniqueKey(OutgoingMessages.OUTGOING_MESSAGES, DSL.name("outgoing_messages_pkey"), new TableField[] { OutgoingMessages.OUTGOING_MESSAGES.ID }, true);
}
