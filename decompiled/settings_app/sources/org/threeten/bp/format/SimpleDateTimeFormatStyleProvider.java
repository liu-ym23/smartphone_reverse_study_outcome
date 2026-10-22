package org.threeten.bp.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.chrono.Chronology;

/* JADX INFO: loaded from: classes6.dex */
final class SimpleDateTimeFormatStyleProvider extends DateTimeFormatStyleProvider {
    private static final ConcurrentMap<String, Object> FORMATTER_CACHE = null;

    SimpleDateTimeFormatStyleProvider() {
    }

    static {
        FORMATTER_CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    }

    @Override // org.threeten.bp.format.DateTimeFormatStyleProvider
    public Locale[] getAvailableLocales() {
        return DateFormat.getAvailableLocales();
    }

    @Override // org.threeten.bp.format.DateTimeFormatStyleProvider
    public DateTimeFormatter getFormatter(FormatStyle r5, FormatStyle r6, Chronology r7, Locale r8) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        throw new IllegalArgumentException("Date and Time style must not both be null");
    L7:
        String r9 = r7.getId() + '|' + r8.toString() + '|' + r5 + r6;
        ConcurrentMap<String, Object> r0 = FORMATTER_CACHE;
        Object r1 = r0.get(r9);
        if (r1 != null) goto L10;
        if (r5 == null) goto L19;
        if (r6 == null) goto L18;
        DateFormat r4 = DateFormat.getDateTimeInstance(convertStyle(r5), convertStyle(r6), r8);
    L21:
        if ((r4 instanceof SimpleDateFormat) == false) goto L24;
        DateTimeFormatter r10 = new DateTimeFormatterBuilder().appendPattern(((SimpleDateFormat) r4).toPattern()).toFormatter(r8);
        r0.putIfAbsent(r9, r10);
        return r10;
    L24:
        r0.putIfAbsent(r9, "");
        throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
    L18:
        r4 = DateFormat.getDateInstance(convertStyle(r5), r8);
        goto L21
    L19:
        r4 = DateFormat.getTimeInstance(convertStyle(r6), r8);
        goto L21
    L10:
        if (r1.equals("") == true) goto L14;
        return (DateTimeFormatter) r1;
    L14:
        throw new IllegalArgumentException("Unable to convert DateFormat to DateTimeFormatter");
    }

    private int convertStyle(FormatStyle r1) {
        return r1.ordinal();
    }
}
