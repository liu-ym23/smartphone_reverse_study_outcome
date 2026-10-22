package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = null;
    private final List<DateFormat> dateFormats;

    static {
        FACTORY = new AnonymousClass1();
    }

    public DateTypeAdapter() {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        Locale r3 = Locale.US;
        r0.add(DateFormat.getDateTimeInstance(2, 2, r3));
        if (Locale.getDefault().equals(r3) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(2, 2));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        return;
    }

    private synchronized Date deserializeToDate(String r3) {
        monitor-enter(this);
        Iterator<DateFormat> r0 = this.dateFormats.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == true) goto L23;
        Date r4 = ISO8601Utils.parse(r3, new ParsePosition(0));     // Catch: Throwable -> L10 ParseException -> L15
        monitor-exit(this);
        return r4;
    L15:
        e = move-exception;
        throw new JsonSyntaxException(r3, e);     // Catch: Throwable -> L10
    L23:
        Date r5 = r0.next().parse(r3);     // Catch: ParseException -> L20 Throwable -> L10
        monitor-exit(this);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r1) {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Date r2) {
        write2(r1, r2);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r3) {
        if (r3.peek() != JsonToken.NULL) goto L7;
        r3.nextNull();
        return null;
    L7:
        return deserializeToDate(r3.nextString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public synchronized void write2(JsonWriter r3, Date r4) {
        monitor-enter(this);
        if (r4 != null) goto L9;
        r3.nullValue();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        r3.value(this.dateFormats.get(0).format(r4));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
