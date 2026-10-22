package kotlin.q0;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", TypedValues.TransitionType.S_FROM, "", "until", "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class d {
    public static final c a(long r3) {
        return new f((int) r3, (int) (r3 >> 32));
    }

    public static final String b(Object r2, Object r3) {
        o.f(r2, TypedValues.TransitionType.S_FROM);
        o.f(r3, "until");
        return "Random range is empty: [" + r2 + ", " + r3 + ").";
    }

    public static final void c(int r1, int r2) {
        if (r2 <= r1) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(b(Integer.valueOf(r1), Integer.valueOf(r2)).toString());
    L4:
        r0 = false;
        goto L5
    }

    public static final int d(int r0) {
        return 31 - Integer.numberOfLeadingZeros(r0);
    }

    public static final int e(c r2, kotlin.r0.d r3) {
        o.f(r2, "<this>");
        o.f(r3, "range");
        if (r3.isEmpty() == true) goto L13;
        if (r3.b() >= Integer.MAX_VALUE) goto L8;
        return r2.d(r3.a(), r3.b() + 1);
    L8:
        if (r3.a() <= Integer.MIN_VALUE) goto L11;
        return r2.d(r3.a() - 1, r3.b()) + 1;
    L11:
        return r2.c();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r3);
    }

    public static final int f(int r1, int r2) {
        return (r1 >>> (32 - r2)) & ((-r2) >> 31);
    }
}
