package h.a.f3;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a,\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0000\u001a,\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"systemProp", "", "propertyName", "", "defaultValue", "", "minValue", "maxValue", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/internal/SystemPropsKt")
final /* synthetic */ class i0 {
    public static final int a(String r7, int r8, int r9, int r10) {
        return (int) g0.c(r7, r8, r9, r10);
    }

    public static final long b(String r4, long r5, long r7, long r9) {
        String r0 = g0.d(r4);
        if (r0 != null) goto L5;
        return r5;
    L5:
        Long r6 = kotlin.u0.k.k(r0);
        if (r6 == null) goto L17;
        long r2 = r6.longValue();
        boolean r1 = false;
        if (r7 <= r2) goto L10;
    L12:
        if (r1 == false) goto L15;
        return r2;
    L15:
        throw new IllegalStateException(("System property '" + r4 + "' should be in range " + r7 + ".." + r9 + ", but is '" + r2 + '\'').toString());
    L10:
        if (r2 > r9) goto L12;
        r1 = true;
        goto L12
    L17:
        throw new IllegalStateException(("System property '" + r4 + "' has unrecognized value '" + r0 + '\'').toString());
    }

    public static final boolean c(String r0, boolean r1) {
        String r2 = g0.d(r0);
        if (r2 != null) goto L6;
        return r1;
    L6:
        return Boolean.parseBoolean(r2);
    }

    public static /* synthetic */ int d(String r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = Integer.MAX_VALUE;
    L9:
        return g0.b(r0, r1, r2, r3);
    }

    public static /* synthetic */ long e(String r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 1;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = LocationRequestCompat.PASSIVE_INTERVAL;
    L9:
        return g0.c(r7, r8, r3, r12);
    }
}
