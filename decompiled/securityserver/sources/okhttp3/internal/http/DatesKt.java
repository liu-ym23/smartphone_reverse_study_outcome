package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DatesKt {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 253402300799999L;
    private static final DatesKt$STANDARD_DATE_FORMAT$1 STANDARD_DATE_FORMAT = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http.DatesKt$STANDARD_DATE_FORMAT$1] */
    static {
        STANDARD_DATE_FORMAT = new DatesKt$STANDARD_DATE_FORMAT$1();
        String[] r0 = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = r0;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[r0.length];
    }

    @Nullable
    public static final Date toHttpDateOrNull(@NotNull String r10) {
        Intrinsics.f(r10, "$this$toHttpDateOrNull");
        if (r10.length() != 0) goto L5;
        return null;
    L5:
        ParsePosition r0 = new ParsePosition(0);
        Date r3 = STANDARD_DATE_FORMAT.get().parse(r10, r0);
        if (r0.getIndex() != r10.length()) goto L8;
        return r3;
    L8:
        String[] r4 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        monitor-enter(r4);
        int r5 = r4.length;     // Catch: Throwable -> L15
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L22;
        DateFormat[] r7 = BROWSER_COMPATIBLE_DATE_FORMATS;     // Catch: Throwable -> L15
        DateFormat r8 = r7[r6];     // Catch: Throwable -> L15
        if (r8 != null) goto L17;
        r8 = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[r6], Locale.US);     // Catch: Throwable -> L15
        r8.setTimeZone(Util.UTC);     // Catch: Throwable -> L15
        r7[r6] = r8;     // Catch: Throwable -> L15
    L17:
        r0.setIndex(0);     // Catch: Throwable -> L15
        Date r9 = r8.parse(r10, r0);     // Catch: Throwable -> L15
        if (r0.getIndex() != 0) goto L19;
        r6 = r6 + 1;
        goto L11
    L19:
        monitor-exit(r4);
        return r9;
    L22:
        monitor-exit(r4);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    @NotNull
    public static final String toHttpDateString(@NotNull Date r1) {
        Intrinsics.f(r1, "$this$toHttpDateString");
        String r2 = STANDARD_DATE_FORMAT.get().format(r1);
        Intrinsics.e(r2, "STANDARD_DATE_FORMAT.get().format(this)");
        return r2;
    }
}
