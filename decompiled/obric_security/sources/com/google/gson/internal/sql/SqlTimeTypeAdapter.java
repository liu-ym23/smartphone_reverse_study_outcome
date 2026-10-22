package com.google.gson.internal.sql;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    /* synthetic */ SqlTimeTypeAdapter(AnonymousClass1 r1) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Time read(JsonReader r1) throws IOException {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Time r2) throws IOException {
        write2(r1, r2);
    }

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Time read2(JsonReader r6) throws IOException {
        if (r6.peek() != JsonToken.NULL) goto L6;
        r6.nextNull();
        return null;
    L6:
        String r0 = r6.nextString();
        monitor-enter(this);     // Catch: ParseException -> L14
        Time r2 = new Time(this.format.parse(r0).getTime());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;     // Catch: ParseException -> L14
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r0 + "' as SQL Time; at path " + r6.getPreviousPath(), e);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r2, Time r3) throws IOException {
        if (r3 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        monitor-enter(this);
        String r4 = this.format.format(r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r2.value(r4);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
