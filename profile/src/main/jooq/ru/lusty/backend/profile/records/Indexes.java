/*
 * This file is generated by jOOQ.
 */
package ru.lusty.backend.profile.records;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.lusty.backend.profile.records.tables.Profiles;
import ru.lusty.backend.profile.records.tables.Verifications;


/**
 * A class modelling indexes of tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PROFILES_SEARCH_IDX = Internal.createIndex(DSL.name("profiles_search_idx"), Profiles.PROFILES, new OrderField[] { Profiles.PROFILES.DELETED_AT, Profiles.PROFILES.HIDDEN, Profiles.PROFILES.GENDER, Profiles.PROFILES.BIRTHDAY }, false);
    public static final Index VERIFICATIONS_APPROVED = Internal.createIndex(DSL.name("verifications_approved"), Verifications.VERIFICATIONS, new OrderField[] { Verifications.VERIFICATIONS.APPROVED, Verifications.VERIFICATIONS.CREATED_AT }, false);
    public static final Index VERIFICATIONS_PROFILE_ID = Internal.createIndex(DSL.name("verifications_profile_id"), Verifications.VERIFICATIONS, new OrderField[] { Verifications.VERIFICATIONS.PROFILE_ID }, false);
}
