package kotlinx.coroutines.internal;

import androidx.appcompat.widget.ActivityChooserView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SystemPropsKt {
    public static final int a() {
        return SystemPropsKt__SystemPropsKt.f427a;
    }

    public static final long b(long r23, String r25, long r26, long r28) {
        String r5 = c(r25);
        if (r5 == null) goto L52;
        CharsKt.c(10);
        int r7 = r5.length();
        if (r7 != 0) goto L7;
    L6:
        Long r8 = null;
    L41:
        if (r8 == null) goto L50;
        long r9 = r8.longValue();
        if (r26 > r9) goto L48;
        if (r28 < r9) goto L48;
        return r9;
    L48:
        throw new IllegalStateException(("System property '" + r25 + "' should be in range " + r26 + ".." + r28 + ", but is '" + r9 + '\'').toString());
    L50:
        throw new IllegalStateException(("System property '" + r25 + "' has unrecognized value '" + r5 + '\'').toString());
    L7:
        int r10 = 0;
        char r11 = r5.charAt(0);
        long r12 = -9223372036854775807L;
        if (Intrinsics.h(r11, 48) >= 0) goto L18;
        boolean r13 = true;
        if (r7 == 1) goto L6;
        if (r11 != '-') goto L16;
        r12 = Long.MIN_VALUE;
        r10 = 1;
    L19:
        long r14 = 0;
        long r16 = -256204778801521550L;
    L20:
        if (r10 >= r7) goto L36;
        int r15 = Character.digit(r5.charAt(r10), 10);
        if (r15 < 0) goto L6;
        if (r14 >= r16) goto L32;
        if (r16 != (-256204778801521550L)) goto L6;
        r16 = r12 / ((long) 10);
        if (r14 < r16) goto L6;
    L32:
        long r17 = r14 * ((long) 10);
        long r18 = r15;
        if (r17 < (r12 + r18)) goto L6;
        r14 = r17 - r18;
        r10 = r10 + 1;
        goto L20
    L36:
        if (r13 == false) goto L39;
        Long r6 = Long.valueOf(r14);
    L38:
        r8 = r6;
        goto L41
    L39:
        r6 = Long.valueOf(-r14);
        goto L38
    L16:
        if (r11 != '+') goto L6;
        r13 = false;
        r10 = 1;
        goto L19
    L18:
        r13 = false;
        goto L19
    L52:
        return r23;
    }

    public static final String c(String r1) {
        int r0 = SystemPropsKt__SystemPropsKt.f427a;
        return System.getProperty(r1);
    L5:
        return null;
    }

    public static int d(String r7, int r8, int r9, int r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r9 = 1;
    L6:
        if ((r11 & 8) == 0) goto L9;
        r10 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L9:
        return (int) b(r8, r7, r9, r10);
    }
}
