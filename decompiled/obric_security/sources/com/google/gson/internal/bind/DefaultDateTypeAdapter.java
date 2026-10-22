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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = null;
        private final Class<T> dateClass;

        protected abstract T deserialize(Date r1);

        static {
            final Class<Date> r1 = Date.class;
            DATE = new AnonymousClass1(r1);
        }

        protected DateType(Class<T> r1) {
            this.dateClass = r1;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> r1) {
            return TypeAdapters.newFactory(this.dateClass, r1);
        }

        public final TypeAdapterFactory createAdapterFactory(String r3) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, null));
        }

        public final TypeAdapterFactory createAdapterFactory(int r3) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, null));
        }

        public final TypeAdapterFactory createAdapterFactory(int r3, int r4) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, r4, null));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            int r1 = 2;
            return createFactory(new DefaultDateTypeAdapter(this, r1, r1, null));
        }
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, String r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r1) throws IOException {
        return read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) throws IOException {
        write(r1, (Date) r2);
    }

    private DefaultDateTypeAdapter(DateType<T> r2, String r3) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) Objects.requireNonNull(r2);
        r0.add(new SimpleDateFormat(r3, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(new SimpleDateFormat(r3));
        return;
    }

    private DefaultDateTypeAdapter(DateType<T> r2, int r3) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) Objects.requireNonNull(r2);
        r0.add(DateFormat.getDateInstance(r3, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(DateFormat.getDateInstance(r3));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateFormat(r3));
        return;
    }

    private DefaultDateTypeAdapter(DateType<T> r2, int r3, int r4) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) Objects.requireNonNull(r2);
        r0.add(DateFormat.getDateTimeInstance(r3, r4, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(r3, r4));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateTimeFormat(r3, r4));
        return;
    }

    public void write(JsonWriter r3, Date r4) throws IOException {
        if (r4 != null) goto L5;
        r3.nullValue();
        return;
    L5:
        DateFormat r0 = this.dateFormats.get(0);
        List<DateFormat> r2 = this.dateFormats;
        monitor-enter(r2);
        String r5 = r0.format(r4);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        r3.value(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r3) throws IOException {
        if (r3.peek() != JsonToken.NULL) goto L6;
        r3.nextNull();
        return null;
    L6:
        Date r4 = deserializeToDate(r3);
        return (T) this.dateType.deserialize(r4);
    }

    private Date deserializeToDate(JsonReader r5) throws IOException {
        String r0 = r5.nextString();
        List<DateFormat> r1 = this.dateFormats;
        monitor-enter(r1);
        Iterator<DateFormat> r4 = this.dateFormats.iterator();     // Catch: Throwable -> L17
    L6:
        if (r4.hasNext() == false) goto L11;
        Date r6 = r4.next().parse(r0);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r6;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return ISO8601Utils.parse(r0, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r0 + "' as Date; at path " + r5.getPreviousPath(), e);
    L17:
        th = move-exception;
        throw th;
    }

    public String toString() {
        DateFormat r3 = this.dateFormats.get(0);
        if ((r3 instanceof SimpleDateFormat) == false) goto L7;
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) r3).toPattern() + ')';
    L7:
        return "DefaultDateTypeAdapter(" + r3.getClass().getSimpleName() + ')';
    }
}
