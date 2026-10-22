package t1;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f22085a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f22086b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f22087c = null;

    static {
        Locale r5 = Locale.US;
        SimpleDateFormat r10 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", r5);
        r10.setTimeZone(TimeZone.getTimeZone("UTC"));
        f22085a = r10;
        f22086b = new SimpleDateFormat("yyyyMMdd", r5);
        f22087c = new Regex("^([-+]?)P(?:T?(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?|(?:(\\d+(?:\\.\\d+)?)W)?(?:(\\d+(?:\\.\\d+)?)D)?(?:T(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?)$", RegexOption.IGNORE_CASE);
    }

    public static long a(long r27, long r29, boolean r31, String r32) {
        if (r31 == true) goto L5;
    L11:
        if (r31 == false) goto L13;
    L64:
        return r29;
    L13:
        if (r29 != 0) goto L64;
        if (r32 == null) goto L58;
        String r5 = StringsKt.trim(r32).toString();
        if (r5.length() == 0) goto L58;
        MatchResult r10 = f22087c.matchEntire(r5);
        if (r10 == null) goto L58;
        int r11 = 1;
        if (Intrinsics.areEqual(r10.getGroupValues().get(1), DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD) == false) goto L24;
        r11 = -1;
    L24:
        Double r12 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(2));
        if (r12 == null) goto L27;
        double r13 = r12.doubleValue();
    L28:
        Double r14 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(3));
        if (r14 == null) goto L31;
        double r15 = r14.doubleValue();
    L32:
        Double r16 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(4));
        if (r16 == null) goto L35;
        double r17 = r16.doubleValue();
    L36:
        Double r18 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(5));
        if (r18 == null) goto L39;
        double r19 = r18.doubleValue();
    L40:
        Double r20 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(6));
        if (r20 == null) goto L43;
        double r110 = r20.doubleValue();
    L44:
        Double r21 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(7));
        if (r21 == null) goto L47;
        double r25 = r21.doubleValue();
    L48:
        Double r22 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(8));
        if (r22 == null) goto L51;
        double r23 = r22.doubleValue();
    L52:
        Double r24 = StringsKt.toDoubleOrNull(r10.getGroupValues().get(9));
        if (r24 == null) goto L55;
        double r26 = r24.doubleValue();
    L56:
        double r28 = 24;
        double r210 = r26;
        double r30 = 3600;
        double r33 = (r13 + r25) * r30;
        double r111 = r17 + r210;
        long r34 = (long) (((r111 + (((r15 + r23) * ((double) 60)) + (r33 + j0.B(r110, r28, r30, ((r19 * ((double) 7)) * r28) * r30)))) * ((double) 1000)) * ((double) r11));
    L60:
        if (r34 != 0) goto L62;
        int r35 = 3600000;
    L10:
        return r27 + ((long) r35);
    L62:
        return r27 + r34;
    L55:
        r26 = 0.0d;
        goto L56
    L51:
        r23 = 0.0d;
        goto L52
    L47:
        r25 = 0.0d;
        goto L48
    L43:
        r110 = 0.0d;
        goto L44
    L39:
        r19 = 0.0d;
        goto L40
    L35:
        r17 = 0.0d;
        goto L36
    L31:
        r15 = 0.0d;
        goto L32
    L27:
        r13 = 0.0d;
    L58:
        r34 = 0;
        goto L60
    L5:
        if (r29 != 0) goto L7;
    L8:
        r35 = 86400000;
        goto L10
    L7:
        if (r27 != r29) goto L11;
        goto L8
    }

    public static String b(long r5, String r10) {
        SimpleDateFormat r11 = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.US);
        r11.setTimeZone(TimeZone.getTimeZone(r10));
        return ";TZID=" + r10 + ':' + r11.format(new Date(r5));
    }

    public static String c(String r5) {
        return StringsKt.F(StringsKt.F(StringsKt.F(StringsKt.F(r5, "\\", "\\\\"), ";", "\\;"), ",", "\\,"), "\n", "\\n");
    }
}
