package com.google.gson.internal.sql;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    static {
        FACTORY = new AnonymousClass1();
    }

    public /* synthetic */ SqlTimeTypeAdapter(AnonymousClass1 r1) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time read(JsonReader r1) {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Time r2) {
        write2(r1, r2);
    }

    private SqlTimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public synchronized Time read2(JsonReader r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r4.peek() != JsonToken.NULL) goto L19;
        r4.nextNull();     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L19:
        Time r0 = new Time(this.format.parse(r4.nextString()).getTime());     // Catch: Throwable -> L9 ParseException -> L14
        monitor-exit(this);
        return r0;
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L9
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public synchronized void write2(JsonWriter r2, Time r3) {
        monitor-enter(this);
        if (r3 != null) goto L12;
        String r4 = null;
    L6:
        r2.value(r4);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r4 = this.format.format(r3);     // Catch: Throwable -> L9
        goto L6
    }
}
