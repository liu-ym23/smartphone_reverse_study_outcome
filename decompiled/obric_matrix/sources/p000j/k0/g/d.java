package p000j.k0.g;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f17874a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f17875b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f17876c = null;

    static class a extends ThreadLocal<DateFormat> {
        a() {
        }

        protected DateFormat a() {
            SimpleDateFormat r2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            r2.setLenient(false);
            r2.setTimeZone(c.o);
            return r2;
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ DateFormat initialValue() {
            return a();
        }
    }

    static {
        f17874a = new a();
        String[] r0 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f17875b = r0;
        f17876c = new DateFormat[r0.length];
    }

    public static String a(Date r1) {
        return f17874a.get().format(r1);
    }

    public static Date b(String r10) {
        if (r10.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r0 = new ParsePosition(0);
        Date r3 = f17874a.get().parse(r10, r0);
        if (r0.getIndex() != r10.length()) goto L8;
        return r3;
    L8:
        String[] r4 = f17875b;
        monitor-enter(r4);
        int r5 = r4.length;     // Catch: Throwable -> L22
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L20;
        DateFormat[] r7 = f17876c;     // Catch: Throwable -> L22
        DateFormat r8 = r7[r6];     // Catch: Throwable -> L22
        if (r8 != null) goto L15;
        r8 = new SimpleDateFormat(f17875b[r6], Locale.US);     // Catch: Throwable -> L22
        r8.setTimeZone(c.o);     // Catch: Throwable -> L22
        r7[r6] = r8;     // Catch: Throwable -> L22
    L15:
        r0.setIndex(0);     // Catch: Throwable -> L22
        Date r9 = r8.parse(r10, r0);     // Catch: Throwable -> L22
        if (r0.getIndex() != 0) goto L17;
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L11
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return r9;
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L22
        return null;
    L22:
        th = move-exception;
        throw th;
    }
}
