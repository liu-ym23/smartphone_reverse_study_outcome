package kotlin.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ProgressionUtilKt {
    public static final int a(int r1, int r2, int r3) {
        if (r3 <= 0) goto L18;
        if (r1 >= r2) goto L38;
        int r0 = r2 % r3;
        if (r0 >= 0) goto L9;
        r0 = r0 + r3;
    L9:
        int r4 = r1 % r3;
        if (r4 >= 0) goto L13;
        r4 = r4 + r3;
    L13:
        int r5 = (r0 - r4) % r3;
        if (r5 >= 0) goto L37;
        r5 = r5 + r3;
    L37:
        return r2 - r5;
    L38:
        return r2;
    L18:
        if (r3 >= 0) goto L36;
        if (r1 <= r2) goto L39;
        int r6 = -r3;
        int r7 = r1 % r6;
        if (r7 >= 0) goto L25;
        r7 = r7 + r6;
    L25:
        int r8 = r2 % r6;
        if (r8 >= 0) goto L29;
        r8 = r8 + r6;
    L29:
        int r9 = (r7 - r8) % r6;
        if (r9 >= 0) goto L34;
        r9 = r9 + r6;
    L34:
        return r2 + r9;
    L39:
        return r2;
    L36:
        throw new IllegalArgumentException("Step is zero.");
    }
}
