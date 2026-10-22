package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE = null;
    public static final TypeAdapterFactory DATE_FACTORY = null;
    public static final boolean SUPPORTS_SQL_TYPES = false;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE = null;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = null;
    public static final TypeAdapterFactory TIME_FACTORY = null;

    static {
        Class.forName("java.sql.Date");     // Catch: ClassNotFoundException -> L4
        boolean r0 = true;
    L5:
        SUPPORTS_SQL_TYPES = r0;
        if (r0 == false) goto L8;
        final Class<java.sql.Date> r1 = java.sql.Date.class;
        DATE_DATE_TYPE = new AnonymousClass1(r1);
        final Class<Timestamp> r2 = Timestamp.class;
        TIMESTAMP_DATE_TYPE = new AnonymousClass2(r2);
        DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
        TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
        TIMESTAMP_FACTORY = SqlTimestampTypeAdapter.FACTORY;
        return;
    L8:
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
        return;
    L4:
        r0 = false;
        goto L5
    }

    private SqlTypesSupport() {
    }
}
